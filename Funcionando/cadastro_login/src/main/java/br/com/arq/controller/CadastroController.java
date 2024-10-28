package br.com.arq.controller;
import br.com.arq.util.CriptografiaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.arq.model.Users;
import br.com.arq.repository.UserRepository;


@Controller
public class CadastroController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/cadastro")
	public String cadastroPage(Model model) {
		Users users = new Users();
		model.addAttribute("users", users);
		return "cadastro";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrarUsers(@ModelAttribute("users") Users users, BindingResult result, Model model) {
		try {
			users.setPassword(CriptografiaUtils.criptografar(users.getPassword()));
			 Users resp = userRepository.save(users);
			 	if (resp==null) {
			 		throw new Exception("Não Gravado!");
			 	}
			 model.addAttribute("message", "Usuário Gravado!");
			
			return "cadastro";
		}catch(Exception ex){
			model.addAttribute("message", "ERROR!" + ex.getMessage());
			return "cadastro";
		}
	}
	

}
