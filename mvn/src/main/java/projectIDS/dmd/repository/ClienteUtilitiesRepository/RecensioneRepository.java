package projectIDS.dmd.repository.ClienteUtilitiesRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.clienteutilities.Recensione;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

/**
 * RecensioneRepository è un'interfaccia che estende JpaRepository<Recensione, Integer>,
 * indicando che è un repository per l'entità Recensione con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti Recensione.
 */
public interface RecensioneRepository extends JpaRepository<Recensione, Integer> {

    /**
     * findByPuntoVendita è un metodo che recupera una lista di oggetti Recensione associati a un determinato PuntoVendita.
     *
     * @param puntoVendita Il punto vendita per cui recuperare gli oggetti Recensione associati.
     * @return Una lista di oggetti Recensione associati al punto vendita specificato.
     */
    List<Recensione> findByPuntoVendita(PuntoVendita puntoVendita);
}

