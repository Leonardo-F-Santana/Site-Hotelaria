package br.com.arq.controller;

import br.com.arq.model.Imoveis;
import br.com.arq.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CategoriaController {

    @Autowired
    private ImovelRepository imovelRepository;

    @GetMapping("/categorias")
    public String listarImoveis(
            @RequestParam(required = false) Integer tipo,
            @RequestParam(required = false) Integer piscina,
            @RequestParam(required = false) Integer wifi,
            @RequestParam(required = false) Integer garagem,
            @RequestParam(required = false) Integer hidromassagem,
            @RequestParam(required = false) Integer banheira,
            @RequestParam(required = false) Integer sauna,
            @RequestParam(required = false) Integer estado,
            @RequestParam(required = false) Integer cidade,
            Model model) {

        // Filtro de pesquisa baseado nos parâmetros
        List<Imoveis> imoveis = imovelRepository.findAll(); // Pega todos os imóveis por padrão

        // Filtra os imóveis conforme os parâmetros recebidos
        if (tipo != null) {
            imoveis = imoveis.stream()
                    .filter(imovel -> imovel.getTipoImovel().equals(tipo))
                    .collect(Collectors.toList());
        }
        if (piscina != null) {
            imoveis = imoveis.stream()
                    .filter(imovel -> imovel.getPiscinaImovel().equals(piscina))
                    .collect(Collectors.toList());
        }
        if (wifi != null) {
            imoveis = imoveis.stream()
                    .filter(imovel -> imovel.getWifiImovel().equals(wifi))
                    .collect(Collectors.toList());
        }
        if (garagem != null) {
            imoveis = imoveis.stream()
                    .filter(imovel -> imovel.getGaragemImovel().equals(garagem))
                    .collect(Collectors.toList());
        }
        if (hidromassagem != null) {
            imoveis = imoveis.stream()
                    .filter(imovel -> imovel.getHidromassagemImovel().equals(hidromassagem))
                    .collect(Collectors.toList());
        }
        if (banheira != null) {
            imoveis = imoveis.stream()
                    .filter(imovel -> imovel.getBanheiraImovel().equals(banheira))
                    .collect(Collectors.toList());
        }
        if (sauna != null) {
            imoveis = imoveis.stream()
                    .filter(imovel -> imovel.getSaunaImovel().equals(sauna))
                    .collect(Collectors.toList());
        }
        if (estado != null) {
            imoveis = imoveis.stream()
                    .filter(imovel -> imovel.getEstadoImovel().equals(estado))
                    .collect(Collectors.toList());
        }

        if (cidade != null) {
            imoveis = imoveis.stream()
                    .filter(imovel -> imovel.getCidadeImovel().equals(cidade))
                    .collect(Collectors.toList());
        }

        model.addAttribute("imoveis", imoveis);
        return "categorias";
    }
}
