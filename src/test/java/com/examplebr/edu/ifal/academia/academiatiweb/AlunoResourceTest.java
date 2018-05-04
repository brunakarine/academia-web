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

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.TIPO_ALUNO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import repositories.AlunoRepository;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AlunoResourceTest {
	
	final String BASE_PATH = "http://localhost:8080/aluno";
	
	@Autowired
	private AlunoRepository repositorio;
	
    private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp(){
		
		repositorio.deleteAll();
		
		repositorio.save(new Aluno(  1, "lucas", "96547", "empreendedorismo" ));
		
		repositorio.save(new Aluno(  2, "ana", "85547", "manutenção" ));
		
		
		restTemplate = new RestTemplate();
	
	}
	
	
	
	@Test
	public void testdeveFuncionarAListagemDeTodosOsAlunos() throws JsonParseException, JsonMappingException, IOException {
		
		String resposta = restTemplate.
				getForObject(BASE_PATH + "/listar", String.class);
		
		List<Aluno> alunos = MAPPER.readValue(resposta,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Aluno.class));
		
		int tamanhoDaListaDeAlunosesperado = 3;
		assertEquals(tamanhoDaListaDeAlunosesperado, alunos.size());
		
	}

		
	}

