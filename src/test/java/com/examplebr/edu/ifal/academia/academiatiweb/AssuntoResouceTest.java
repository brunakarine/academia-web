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

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Assunto;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import repositories.AssuntoRepository;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AssuntoResouceTest {
	
final String BASE_PATH = "http://localhost:8080/assunto";
	
	@Autowired
	private AssuntoRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp(){
		repositorio.deleteAll();
		
		repositorio.save(new Assunto(19, "plano de negocio"));
		
		repositorio.save(new Assunto(18, "placa mãe"));
		
		
		restTemplate = new RestTemplate();
	
	}


	@Test
	public void  deveFuncionarAListagemDeTodosOsAssuntos() throws JsonParseException, JsonMappingException, IOException {
		
		String resposta = restTemplate.
				getForObject(BASE_PATH + "/listar", String.class);
		
		List<Assunto> assuntos = MAPPER.readValue(resposta,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Assunto.class));
		
		int tamanhoDaListaDeAssuntosesperado = 3;
		assertEquals(tamanhoDaListaDeAssuntosesperado, assuntos.size());
	}
}
