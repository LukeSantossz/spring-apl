package application.repository;

import application.model.ModoJogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModoJogoRepository extends JpaRepository<ModoJogo, Long> {
    ModoJogo findByDescricao(String descricao);
} 