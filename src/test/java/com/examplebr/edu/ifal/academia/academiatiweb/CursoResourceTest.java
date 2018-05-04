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

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Curso;
import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Professor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import repositories.CursoRepository;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CursoResourceTest {
	
    String BASE_PATH = "http://localhost:8080/curso";
	
	@Autowired
	private CursoRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp(){
		repositorio.deleteAll();
		
		repositorio.save(new Curso(9, "informatica", "lucrecia", "lucas"));
		
		repositorio.save(new Curso(10, "logistica", "josue", "Ana"));
		
		
		restTemplate = new RestTemplate();
	
	}

	@Test
	public void deveFuncionarAListagemDeTodosOsCursos() throws JsonParseException, JsonMappingException, IOException {
		
		String resposta = restTemplate.
				getForObject(BASE_PATH + "/listar", String.class);
		
		List<Curso> cursos = MAPPER.readValue(resposta,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Curso.class));
		
		int tamanhoDaListaDeCursosesperado = 3;
		assertEquals(tamanhoDaListaDeCursosesperado, cursos.size());
		
	}
		
	}

