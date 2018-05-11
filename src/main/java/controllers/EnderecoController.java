package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.examplebr.edu.ifal.academia.academiatiweb.modelo.Endereco;

import repositories.EnderecoRepository;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoRepository enderecoRepository;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String Endereco(ModelMap model) {
		Endereco endereco = enderecoRepository.findAll();

		model.addAttribute("Endereco", endereco);

		model.addAttribute("massage", "endereco");
		System.out.println("list");

		return "endereco";

	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEndereco(ModelMap model) {

		Endereco endereco = new Endereco();
		model.addAttribute("Endereco", endereco);
		model.addAttribute("edit", false);

		return "endereco/from";

	}

	@RequestMapping(value = { "/edit-{id}-endereco" }, method = RequestMethod.GET)
	public String editCurso(@PathVariable("id") Integer id, ModelMap model) {
		Endereco endereco = enderecoRepository.getOne(id);
		model.addAttribute("Endereco", endereco);
		model.addAttribute("edit", true);
		return "endereco/from";

	}

	@RequestMapping(value = { "/edit-{id}-endereco" }, method = RequestMethod.POST)
	public String updateCurso(@Valid Endereco endereco, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "endereco/from";
		}

		enderecoRepository.saveAndFlush(endereco);

		model.addAttribute("mensagem", "Endereco" + endereco.getNome() + "atualizado com sucesso");

		return "redirect:/endereco/list";
	}

	@RequestMapping(value = { "/delete-{id}-endereco" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable Integer id) {
		enderecoRepository.deleteById(id);
		return "redirect:/endereco/list";
	}

}
