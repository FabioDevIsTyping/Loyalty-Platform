package projectIDS.dmd.repository.PersoneRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

public interface ClientRepository extends JpaRepository<Client,Integer> {
    List<Client> findByPuntiVendita(PuntoVendita puntoVendita);

}
