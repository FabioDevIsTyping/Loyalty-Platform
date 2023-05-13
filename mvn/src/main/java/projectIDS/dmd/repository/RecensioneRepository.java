package projectIDS.dmd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.PuntoVendita;
import projectIDS.dmd.model.Recensione;

public interface RecensioneRepository extends JpaRepository<Recensione,Integer> {
    List<Recensione> findByPuntoVendita(PuntoVendita puntoVendita);
}
