package projectIDS.dmd.repository.PersoneRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.persone.Dipendente;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

/**
 * DipendenteRepository è un'interfaccia che estende JpaRepository<Dipendente, Integer>,
 * indicando che è un repository per l'entità Dipendente con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti Dipendente.
 */
public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {

    /**
     * findByPuntoVendita è un metodo che recupera una lista di oggetti Dipendente associati a un determinato PuntoVendita.
     *
     * @param puntoVendita Il punto vendita per cui recuperare gli oggetti Dipendente associati.
     * @return Una lista di oggetti Dipendente associati al punto vendita specificato.
     */
    List<Dipendente> findByPuntoVendita(PuntoVendita puntoVendita);
}

