package projectIDS.dmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectIDS.dmd.model.Recensione;

public interface RecensioneRepository extends JpaRepository<Recensione,Integer> {
    
}
