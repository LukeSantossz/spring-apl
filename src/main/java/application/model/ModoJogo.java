package application.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modos_jogo")
public class ModoJogo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String descricao;
    
    @OneToOne(mappedBy = "modoJogo")
    private Jogo jogo;
    
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
    
    public Jogo getJogo() {
        return jogo;
    }
    
    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
} 