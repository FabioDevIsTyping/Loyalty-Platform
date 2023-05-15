package projectIDS.dmd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import projectIDS.dmd.model.CartaFedelta;
import projectIDS.dmd.model.Client;

public interface CartaFedeltaRepository extends JpaRepository<CartaFedelta,Integer>{
    
    List<CartaFedelta> findByClient(Client client);
}
