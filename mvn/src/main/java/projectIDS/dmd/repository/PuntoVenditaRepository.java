package projectIDS.dmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectIDS.dmd.model.PuntoVendita;

public interface PuntoVenditaRepository extends JpaRepository<PuntoVendita,Integer>{
    
}
