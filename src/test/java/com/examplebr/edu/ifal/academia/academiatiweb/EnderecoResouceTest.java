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

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Endereco;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import repositories.EnderecoRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EnderecoResouceTest {
	
final String BASE_PATH = "http://localhost:8080/endereco";
	
	@Autowired
	private EnderecoRepository repositorio;
	
	private RestTemplate restTemplate;
	
	private ObjectMapper MAPPER = new ObjectMapper();
	
	@Before
	public void setUp(){
		repositorio.deleteAll();
		
		repositorio.save(new Endereco( "rua da alegria",51, "tabuleiro","AL", "Maceió", "57102-100"));
		
		repositorio.save(new Endereco( "rua ernesto calheiros",64, "Graciliano Ramos", "AL", "Maceió", "68200-396"));
		
		
		restTemplate = new RestTemplate();
	
	}


	@Test
	public void  deveFuncionarAListagemDeTodosOsEnderecos() throws JsonParseException, JsonMappingException, IOException {
		
		String resposta = restTemplate.
				getForObject(BASE_PATH + "/listar", String.class);
		
		List<Endereco> enderecos = MAPPER.readValue(resposta,
				MAPPER.getTypeFactory().constructCollectionLikeType(List.class, Endereco.class));
		
		int tamanhoDaListaDeEnderecosesperado = 3;
		assertEquals(tamanhoDaListaDeEnderecosesperado, enderecos.size());
	}

}
