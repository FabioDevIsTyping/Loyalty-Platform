package projectIDS.dmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectIDS.dmd.model.Messaggio;
public interface MessaggioRepository extends JpaRepository<Messaggio,Integer>{
    
}
