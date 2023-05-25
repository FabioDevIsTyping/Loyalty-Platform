package projectIDS.dmd.repository.ClienteUtilitiesRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.clienteutilities.Recensione;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

public interface RecensioneRepository extends JpaRepository<Recensione,Integer> {
    List<Recensione> findByPuntoVendita(PuntoVendita puntoVendita);
}
