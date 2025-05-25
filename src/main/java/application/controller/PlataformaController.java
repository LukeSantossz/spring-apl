package application.controller;

import application.model.Plataforma;
import application.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/plataformas")
public class PlataformaController {

    @Autowired
    private PlataformaRepository plataformaRepository;

    @GetMapping
    public String listarPlataformas(Model model) {
        model.addAttribute("plataformas", plataformaRepository.findAll());
        return "plataforma/lista";
    }

    @GetMapping("/novo")
    public String novaPlataforma(Model model) {
        model.addAttribute("plataforma", new Plataforma());
        return "plataforma/form";
    }

    @PostMapping("/salvar")
    public String salvarPlataforma(@ModelAttribute Plataforma plataforma) {
        plataformaRepository.save(plataforma);
        return "redirect:/plataformas";
    }

    @GetMapping("/editar/{id}")
    public String editarPlataforma(@PathVariable Long id, Model model) {
        Plataforma plataforma = plataformaRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de plataforma inválido:" + id));
        model.addAttribute("plataforma", plataforma);
        return "plataforma/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPlataforma(@PathVariable Long id) {
        plataformaRepository.deleteById(id);
        return "redirect:/plataformas";
    }
} 