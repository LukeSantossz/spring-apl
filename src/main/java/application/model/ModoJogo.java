package application.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "modos_jogo")
public class ModoJogo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String descricao;
    
    @OneToMany(mappedBy = "modoJogo")
    private Set<Jogo> jogos = new HashSet<>();
    
    public ModoJogo() {}
    
    public ModoJogo(String descricao) {
        this.descricao = descricao;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Set<Jogo> getJogos() {
        return jogos;
    }
    
    public void setJogos(Set<Jogo> jogos) {
        this.jogos = jogos;
    }
} 