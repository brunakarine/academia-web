package resources;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Professor;

import repositories.ProfessorRepository;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {
	
	@Autowired
	 ProfessorRepository professorRepository;
	 
	 @RequestMapping(value= "carregar", method= RequestMethod.GET)
	 public String carregar() {
		Professor e = new Professor(5,"moises", "51278");
		 
		 professorRepository.save(e);
		 return "ok";
		 
	 }
	 
	@RequestMapping(value= "{id}", method=RequestMethod.GET)
	public Professor buscar(@PathVariable("id") int id) {
		return professorRepository.getOne(id);
		
	}
	

	@RequestMapping(value= "listar", method=RequestMethod.GET)
	public List<Professor> listar() {
		return professorRepository.findAll();
	}
	
	@RequestMapping(value= "pesquisar", method=RequestMethod.GET)
	public List<Professor> pesquisar() {
	return professorRepository.findAll();
	
	}

}
