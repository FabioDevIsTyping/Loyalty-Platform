package projectIDS.dmd.repository.PersoneRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

/**
 * ClientRepository è un'interfaccia che estende JpaRepository<Client, Integer>,
 * indicando che è un repository per l'entità Client con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti Client.
 */
public interface ClientRepository extends JpaRepository<Client, Integer> {

    /**
     * findByPuntiVendita è un metodo che recupera una lista di oggetti Client associati a un determinato PuntoVendita.
     *
     * @param puntoVendita Il punto vendita per cui recuperare gli oggetti Client associati.
     * @return Una lista di oggetti Client associati al punto vendita specificato.
     */
    List<Client> findByPuntiVendita(PuntoVendita puntoVendita);
}

