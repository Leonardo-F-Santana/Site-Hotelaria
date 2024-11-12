package br.com.arq.controller;

import br.com.arq.repository.ImovelRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.arq.model.Imoveis;
import br.com.arq.model.Users;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class CadastroImovelController {

    private static final String CAMINHO_IMAGENS = "src/main/resources/static/image/fotoImovel";

    @Autowired
    private ImovelRepository imovelRepository;

    @GetMapping("/cadastrarImoveis")
    public String cadastrarImoveis(HttpSession session, Model model) {
        // Verificar se o usuário está logado e é um administrador
        Users user = (Users) session.getAttribute("user"); // Atributo de sessão do usuário

        // Se o usuário não for um administrador, redireciona para a página inicial
        if (user == null || user.getAdmin() != 1) {
            return "redirect:/"; // Redireciona para a página inicial
        }

        Imoveis imoveis = new Imoveis();
        model.addAttribute("imoveis", imoveis);
        return "cadastrarImoveis";
    }

    @PostMapping("/cadastrarImovel")
    public String cadastrarImovel(@ModelAttribute("imoveis") Imoveis imoveis, BindingResult result, Model model, @RequestParam("file") MultipartFile arquivo) {

        if (arquivo.isEmpty()) {
            model.addAttribute("message", "Nenhum arquivo foi selecionado.");
            return "cadastrarImoveis";
        }

        try {
            // Salva o imóvel no banco de dados
            Imoveis resp = imovelRepository.save(imoveis);
            if (resp == null) {
                throw new Exception("Imóvel não gravado!");
            }

            // Verificar e criar o diretório se não existir
            Path diretorio = Paths.get(CAMINHO_IMAGENS);
            if (!Files.exists(diretorio)) {
                Files.createDirectories(diretorio);
            }

            // Definir o nome do arquivo
            String nomeArquivo = imoveis.getIdImovel() + "_" + arquivo.getOriginalFilename();
            Path caminhoArquivo = diretorio.resolve(nomeArquivo);

            // Salvar o arquivo
            byte[] bytes = arquivo.getBytes();
            Files.write(caminhoArquivo, bytes);

            // Atualizar o nome da imagem e salvar o imóvel novamente
            imoveis.setNomeImagemImovel(nomeArquivo);
            imovelRepository.save(imoveis);

            model.addAttribute("message", "Imóvel gravado com sucesso!");
        } catch (IOException e) {
            model.addAttribute("message", "Erro ao salvar o arquivo: " + e.getMessage());
        } catch (Exception e) {
            model.addAttribute("message", "Erro ao salvar o imóvel: " + e.getMessage());
        }

        return "cadastrarImoveis";
    }

}
