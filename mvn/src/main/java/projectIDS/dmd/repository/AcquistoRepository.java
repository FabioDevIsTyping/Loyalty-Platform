package projectIDS.dmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectIDS.dmd.model.Acquisto;

public interface AcquistoRepository extends JpaRepository<Acquisto,Integer>{
    
    // List<Acquisto> findByClient(Client client);
}
