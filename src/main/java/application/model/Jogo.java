package application.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "jogos")
public class Jogo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String titulo;
    
    @ManyToMany
    @JoinTable(
        name = "jogos_generos",
        joinColumns = @JoinColumn(name = "jogo_id"),
        inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private Set<Genero> generos = new HashSet<>();
    
    @ManyToMany
    @JoinTable(
        name = "jogos_plataformas",
        joinColumns = @JoinColumn(name = "jogo_id"),
        inverseJoinColumns = @JoinColumn(name = "plataforma_id")
    )
    private Set<Plataforma> plataformas = new HashSet<>();
    
    @OneToOne
    @JoinColumn(name = "modo_jogo_id")
    private ModoJogo modoJogo;
    
    public Jogo() {}
    
    public Jogo(String titulo) {
        this.titulo = titulo;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Set<Genero> getGeneros() {
        return generos;
    }
    
    public void setGeneros(Set<Genero> generos) {
        this.generos = generos;
    }
    
    public Set<Plataforma> getPlataformas() {
        return plataformas;
    }
    
    public void setPlataformas(Set<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
    
    public ModoJogo getModoJogo() {
        return modoJogo;
    }
    
    public void setModoJogo(ModoJogo modoJogo) {
        this.modoJogo = modoJogo;
    }
} 