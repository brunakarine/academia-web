package com.examplebr.edu.ifal.academia.academiatiweb;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Aluno;
import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Curso;
import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Disciplina;

import repositories.CursoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AcademiaTiWebApplicationTests {

	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Test
	public void contextLoads() {
		
		Curso c = new Curso();
		
		
		
		cursoRepository.save(c);
		
	}

}
