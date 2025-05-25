package application.controller;

import application.model.Jogo;
import application.model.Genero;
import application.model.Plataforma;
import application.model.ModoJogo;
import application.repository.JogoRepository;
import application.repository.GeneroRepository;
import application.repository.PlataformaRepository;
import application.repository.ModoJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;
    
    @Autowired
    private GeneroRepository generoRepository;
    
    @Autowired
    private PlataformaRepository plataformaRepository;
    
    @Autowired
    private ModoJogoRepository modoJogoRepository;

    @GetMapping
    public String listarJogos(Model model) {
        model.addAttribute("jogos", jogoRepository.findAll());
        return "jogo/lista";
    }

    @GetMapping("/novo")
    public String novoJogo(Model model) {
        model.addAttribute("jogo", new Jogo());
        model.addAttribute("generos", generoRepository.findAll());
        model.addAttribute("plataformas", plataformaRepository.findAll());
        model.addAttribute("modosJogo", modoJogoRepository.findAll());
        return "jogo/form";
    }

    @PostMapping("/salvar")
    public String salvarJogo(@ModelAttribute Jogo jogo) {
        jogoRepository.save(jogo);
        return "redirect:/jogos";
    }

    @GetMapping("/editar/{id}")
    public String editarJogo(@PathVariable Long id, Model model) {
        Jogo jogo = jogoRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("ID de jogo inválido:" + id));
        model.addAttribute("jogo", jogo);
        model.addAttribute("generos", generoRepository.findAll());
        model.addAttribute("plataformas", plataformaRepository.findAll());
        model.addAttribute("modosJogo", modoJogoRepository.findAll());
        return "jogo/form";
    }

    @GetMapping("/excluir/{id}")
    public String excluirJogo(@PathVariable Long id) {
        jogoRepository.deleteById(id);
        return "redirect:/jogos";
    }
} 