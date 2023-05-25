package projectIDS.dmd.repository.ClienteUtilitiesRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.clienteutilities.Acquisto;

public interface AcquistoRepository extends JpaRepository<Acquisto,Integer>{
    
    // List<Acquisto> findByClient(Client client);
}
