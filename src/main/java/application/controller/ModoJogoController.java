package application.controller;

import application.model.ModoJogo;
import application.repository.ModoJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/modos-jogo")
public class ModoJogoController {

    @Autowired
    private ModoJogoRepository modoJogoRepository;

    @GetMapping
    public String listarModosJogo(Model model) {
        model.addAttribute("modosJogo", modoJogoRepository.findAll());
        return "modo-jogo/lista";
    }

    @GetMapping("/novo")
    public String novoModoJogo(Model model) {
        model.addAttribute("modoJogo", new ModoJogo());
        return "modo-jogo/form";
    }

    @PostMapping("/salvar")
    public String salvarModoJogo(@ModelAttribute ModoJogo modoJogo) {
        modoJogoRepository.save(modoJogo);
        return "redirect:/modos-jogo";
    }

    @GetMapping("/editar/{id}")
    public String editarModoJogo(@PathVariable Long id, Model model) {
        ModoJogo modoJogo = modoJogoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de modo de jogo inválido:" + id));
        model.addAttribute("modoJogo", modoJogo);
        return "modo-jogo/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirModoJogo(@PathVariable Long id) {
        modoJogoRepository.deleteById(id);
        return "redirect:/modos-jogo";
    }
} 