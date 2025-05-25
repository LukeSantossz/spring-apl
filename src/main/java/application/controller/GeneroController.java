package application.controller;

import application.model.Genero;
import application.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public String listarGeneros(Model model) {
        model.addAttribute("generos", generoRepository.findAll());
        return "genero/lista";
    }

    @GetMapping("/novo")
    public String novoGenero(Model model) {
        model.addAttribute("genero", new Genero());
        return "genero/form";
    }

    @PostMapping("/salvar")
    public String salvarGenero(@ModelAttribute Genero genero) {
        generoRepository.save(genero);
        return "redirect:/generos";
    }

    @GetMapping("/editar/{id}")
    public String editarGenero(@PathVariable Long id, Model model) {
        Genero genero = generoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de gênero inválido:" + id));
        model.addAttribute("genero", genero);
        return "genero/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirGenero(@PathVariable Long id) {
        generoRepository.deleteById(id);
        return "redirect:/generos";
    }
} 