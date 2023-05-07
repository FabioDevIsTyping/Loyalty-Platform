package projectIDS.dmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectIDS.dmd.model.Azienda;

public interface AziendaRepository extends JpaRepository<Azienda,Integer> {
    
}
