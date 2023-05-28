package projectIDS.dmd.repository.PersoneRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.persone.Dipendente;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

public interface DipendenteRepository extends JpaRepository<Dipendente,Integer>{
    List<Dipendente> findByPuntoVendita(PuntoVendita puntoVendita);

}
