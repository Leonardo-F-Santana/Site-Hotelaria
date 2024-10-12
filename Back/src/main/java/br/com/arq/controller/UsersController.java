// Source code is decompiled from a .class file using FernFlower decompiler.
package br.com.arq.controller;

import br.com.arq.model.Users;
import br.com.arq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
   @Autowired
   private UserRepository userRepository;

   public UsersController() {
   }

   @GetMapping({"/cadastro"})
   public String cadastroUsers(Model model) {
      Users users = new Users();
      model.addAttribute("users", users);
      return "usersform";
   }

   @CrossOrigin(origins = "http://127.0.0.1:5500")
   @PostMapping({"/cadastrar"})
   public String cadastrarusuario(@ModelAttribute Users users, BindingResult result, Model model) {
      try {
         users.setPassword(users.criptografia(users.getPassword()));
         Users resp = (Users)this.userRepository.save(users);
         if (resp == null) {
            throw new Exception("N\u00e3o Gravado!");
         } else {
            model.addAttribute("message", "Usu\u00e1rio Gravado!" + resp.toString());
            return "usersform";
         }
      } catch (Exception var5) {
         model.addAttribute("message", "ERROR!" + var5.getMessage());
         return "usersform";
      }
   }
}
