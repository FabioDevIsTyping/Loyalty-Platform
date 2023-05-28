package projectIDS.dmd.repository.ClienteUtilitiesRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.clienteutilities.Acquisto;
import projectIDS.dmd.model.persone.Client;

public interface AcquistoRepository extends JpaRepository<Acquisto,Integer>{
    
    List<Acquisto> findByClient(Client client);
}
