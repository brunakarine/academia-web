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

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Escola;
import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Professor;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import repositories.EscolaRepository;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EscolaRerourceTest {
	
final String BASE_PATH = "http://localhost:8080/escola";
	
	@Autowired
	private EscolaRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp(){
		repositorio.deleteAll();
		
		repositorio.save(new Escola("IFAL Campus-RL"));
		
		repositorio.save(new Escola("IFAL Campus-Meceió"));
		
		restTemplate = new RestTemplate();
	
	}

	

	@Test
	public void testdeveFuncionarAListagemDeTodosAsEscolas() throws JsonParseException, JsonMappingException, IOException {
		
		String resposta = restTemplate.
				getForObject(BASE_PATH + "/listar", String.class);
		
		List<Escola> escolas = MAPPER.readValue(resposta,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Escola.class));
		
		int tamanhoDaListaDeEscolasesperado = 3;
		assertEquals(tamanhoDaListaDeEscolasesperado, escolas.size());
		
	}

}
