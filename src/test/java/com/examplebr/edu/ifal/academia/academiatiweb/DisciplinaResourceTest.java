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

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Aluno;
import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Disciplina;
import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Professor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import repositories.DisciplinaRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class DisciplinaResourceTest {
	
final String BASE_PATH = "http://localhost:8080/disciplina";
	
	@Autowired
	private DisciplinaRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp(){
		repositorio.deleteAll();
		
		repositorio.save(new Disciplina(12, "empreendedorismo", "Lucas","plano de negocio", "moies"));
		
		repositorio.save(new Disciplina(13, "manutenção", "Ana", "placa mãe", "lucrecia"));
		
		
		restTemplate = new RestTemplate();
	
	}

	@Test
	public void deveFuncionarAListagemDeTodosAsDisciplinas() throws JsonParseException, JsonMappingException, IOException {
		
		String resposta = restTemplate.
				getForObject(BASE_PATH + "/listar", String.class);
		
		List<Disciplina> disciplinas = MAPPER.readValue(resposta,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Disciplina.class));
		
		int tamanhoDaListaDeDisciplinasesperado = 3;
		assertEquals(tamanhoDaListaDeDisciplinasesperado, disciplinas.size());
		
	}
	

}