package resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Endereco;
import repositories.EnderecoRepository;

@RestController
@RequestMapping("/escola")
public class EnderecoResource {

	@Autowired
	EnderecoRepository enderecorepository;
	
	@RequestMapping(value= "carregar", method= RequestMethod.GET)
	 public String carregar() {
		Endereco m = new Endereco("rua da alegria", 67, "tabuleiro", "AL","Maceió", "");
		 
		 enderecorepository.save(m);
		 return "ok";
		 
	 }
	@RequestMapping(value= "{id}", method=RequestMethod.GET)
	public Endereco buscar(@PathVariable("id") int id) {
		return enderecorepository.getOne(id);
		
	}
	

	@RequestMapping(value= "listar", method=RequestMethod.GET)
	public List<Endereco> listar() {
		return enderecorepository.findAll();
	}
	
	@RequestMapping(value= "pesquisar", method=RequestMethod.GET)
	public List<Endereco> pesquisar() {
	return enderecorepository.findAll();
	
	}
}

