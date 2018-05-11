package resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Disciplina;
import repositories.DisciplinaRepository;


@RestController
@RequestMapping("api/diciplina")
public class DisciplinaResource {
	
	@Autowired
	 DisciplinaRepository disciplinaRepository;
	 
	 @RequestMapping(value= "carregar", method= RequestMethod.GET)
	 public String carregar() {
		 Disciplina d = new Disciplina ();
		 
		 
		 
		disciplinaRepository.save(d);
		 return "ok";
		 
	 }
	 
	@RequestMapping(value= "{id}", method=RequestMethod.GET)
	public Disciplina buscar(@PathVariable("id") int id) {
		return disciplinaRepository.getOne(id);
		
	}
	

	@RequestMapping(value= "listar", method=RequestMethod.GET)
	public List<Disciplina> listar() {
		return disciplinaRepository.findAll();
	}
	
	@RequestMapping(value= "pesquisar", method=RequestMethod.GET)
	public List<Disciplina> pesquisar() {
	return disciplinaRepository.findAll();
	
	}
}

	




