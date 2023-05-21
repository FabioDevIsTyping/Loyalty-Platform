package projectIDS.dmd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import projectIDS.dmd.model.Client;
import projectIDS.dmd.model.PuntoVendita;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    List<Client> findByPuntiVendita(PuntoVendita puntoVendita);

}
