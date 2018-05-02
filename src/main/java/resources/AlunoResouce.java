package resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Aluno;
import repositories.AlunoRepository;


@RestController
@RequestMapping("/aluno")
public class AlunoResouce {
	
	@Autowired
	 AlunoRepository alunoRepository;
	 
	 @RequestMapping(value= "carregar", method= RequestMethod.GET)
	 public String carregar() {
		 Aluno k = new Aluno(2, "lucas", "96547", "empreendedorismo", "");
		 
		 AlunoRepository.save(k);
		 return "ok";
		 
	 }
	 
	@RequestMapping(value= "{id}", method=RequestMethod.GET)
	public Aluno buscar(@PathVariable("id") int id) {
		return alunoRepository.getOne(id);
		
	}
	

	@RequestMapping(value= "listar", method=RequestMethod.GET)
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}
	
	@RequestMapping(value= "pesquisar", method=RequestMethod.GET)
	public List<Aluno> pesquisar() {
	    return alunoRepository.findAll();
	
	}
}


