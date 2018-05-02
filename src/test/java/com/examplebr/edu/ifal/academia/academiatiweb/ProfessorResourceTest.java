package com.examplebr.edu.ifal.academia.academiatiweb;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Professor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import repositories.ProfessorRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProfessorResourceTest {
	
	final String BASE_PATH = "http://localhost:8080/professor";
	
	@Autowired
	private ProfessorRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp(){
		repositorio.deleteAll();
		
		repositorio.save(new Professor(3, "514793", "lucrecia"));
		
		repositorio.save(new Professor(8, "47892", "josue"));
		
		repositorio.save(new Professor(7, "78945", "Elaine Block"));
		
		restTemplate = new RestTemplate();
	
	}

	@Test
	public void deveFuncionarAListagemDeTodosOsProfessores() throws JsonParseException, JsonMappingException, IOException {
		
		String resposta = restTemplate.
				getForObject(BASE_PATH + "/listar", String.class);
		
		List<Professor> professores = MAPPER.readValue(resposta,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Professor.class));
		
		int tamanhoDaListaDeProfessoresesperado = 3;
		assertEquals(tamanhoDaListaDeProfessoresesperado, professores.size());
		
	}

}
