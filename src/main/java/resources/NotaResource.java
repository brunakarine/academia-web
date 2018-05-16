package resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Nota;
import repositories.NotaRepository;

@RestController
@RequestMapping("/api/nota")
public class NotaResource {
	
	@Autowired
	NotaRepository notarepository;
	
	@RequestMapping(value= "/carregar", method= RequestMethod.GET)
    public String carregar() {
	 Nota b = new Nota();
	 
	 
	 notarepository.save(b);
	 return "b";
		 
	 }
	@RequestMapping(value= "/{id}", method=RequestMethod.GET)
	public Nota buscar(@PathVariable("id") int id) {
		return notarepository.getOne(id);
		
	}
	

	@RequestMapping(value= "/listar", method=RequestMethod.GET)
	public List<Nota> listar() {
		return notarepository.findAll();
	}
	
	@RequestMapping(value= "/pesquisar", method=RequestMethod.GET)
	public List<Nota> pesquisar() {
	return notarepository.findAll();
	
	}
}


