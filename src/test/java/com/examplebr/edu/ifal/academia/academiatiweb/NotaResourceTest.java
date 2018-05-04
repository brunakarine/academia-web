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

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Nota;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import repositories.NotaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class NotaResourceTest {
	
final String BASE_PATH = "http://localhost:8080/nota";
	
	@Autowired
	private NotaRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp(){
		repositorio.deleteAll();
		
		repositorio.save(new Nota(15, "Lucas", "empreendedorismo", 8.0));
		
		repositorio.save(new Nota(16, "Ana", "manutenção", 9.5));
		
		
		restTemplate = new RestTemplate();
	
	}


	@Test
	public void  deveFuncionarAListagemDeTodasAsNotas() throws JsonParseException, JsonMappingException, IOException {
		
		String resposta = restTemplate.
				getForObject(BASE_PATH + "/listar", String.class);
		
		List<Nota> notas = MAPPER.readValue(resposta,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Nota.class));
		
		int tamanhoDaListaDeNotasesperado = 3;
		assertEquals(tamanhoDaListaDeNotasesperado, notas.size());
	}

}
