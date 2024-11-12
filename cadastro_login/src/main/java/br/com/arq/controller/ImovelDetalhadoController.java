package br.com.arq.controller;

import br.com.arq.model.Imoveis;
import br.com.arq.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ImovelDetalhadoController {

    @Autowired
    private ImovelRepository imovelRepository;

    @GetMapping("/detalhesImovel/{id}")
    public String detalhesImovel(@PathVariable Integer id, Model model) {
        // Busca o imóvel pelo id
        Imoveis imovel = imovelRepository.findById(id).orElse(null);

        // Verifica se o imóvel foi encontrado
        if (imovel != null) {
            model.addAttribute("imovel", imovel);
        } else {
            // Se não encontrar, pode redirecionar ou exibir uma mensagem
            model.addAttribute("message", "Imóvel não encontrado");
        }

        // Retorna o nome do template de detalhes
        return "detalhesImovel"; // Nome do template de detalhes
    }
}
