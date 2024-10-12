// Source code is decompiled from a .class file using FernFlower decompiler.
package br.com.arq.controller;

import br.com.arq.model.Users;
import br.com.arq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
   @Autowired
   private UserRepository userRepository;

   @GetMapping({"/cadastro"})
   public String cadastroUsers(Model model) {
      Users users = new Users();
      model.addAttribute("users", users);
      return "usersform";
   }

   @PostMapping("/cadastrar")
	public String cadastrarusuario(@ModelAttribute("users") Users users, BindingResult result, Model model) {
		try {
			users.setPassword(users.criptografia(users.getPassword()));
			 Users resp = userRepository.save(users);
			 	if (resp==null) {
			 		throw new Exception("Não Gravado!");
			 	}
			 model.addAttribute("message", "Usuário Gravado!" + resp.toString());
			
			return "usersform";
		}catch(Exception ex){
			model.addAttribute("message", "ERROR!" + ex.getMessage());
			return "usersform";
		}
   }
}
