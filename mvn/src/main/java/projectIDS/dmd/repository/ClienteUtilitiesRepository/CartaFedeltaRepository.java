package projectIDS.dmd.repository.ClienteUtilitiesRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.clienteutilities.CartaFedelta;
import projectIDS.dmd.model.persone.Client;

public interface CartaFedeltaRepository extends JpaRepository<CartaFedelta,Integer>{
    
    List<CartaFedelta> findByClient(Client client);
}
