package br.com.arq.controller;

import br.com.arq.model.Users;
import br.com.arq.repository.UserRepository;
import br.com.arq.util.CriptografiaUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        return "login";
    }

    @PostMapping("/logar")
    public String loginUsers(@ModelAttribute("users") Users users, Model model, HttpSession session) {
        try {
            Users foundUser = userRepository.findByEmail(users.getEmail());

            if (foundUser != null && foundUser.getPassword().equals(CriptografiaUtils.criptografar(users.getPassword()))) {
                session.setAttribute("user", foundUser);
                model.addAttribute("message", "Login realizado com Sucesso!");
                return "redirect:/";
            } else {
                throw new Exception("Usuário ou senha inválidos!");
            }
        } catch (Exception ex) {
            model.addAttribute("message", "ERROR!" + ex.getMessage());
            return "login";
        }
    }
}
