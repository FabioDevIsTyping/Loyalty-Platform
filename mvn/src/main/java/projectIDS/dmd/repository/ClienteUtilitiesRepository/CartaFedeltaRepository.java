package projectIDS.dmd.repository.ClienteUtilitiesRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.clienteutilities.CartaFedelta;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

/**
 * CartaFedeltaRepository è un'interfaccia che estende JpaRepository<CartaFedelta, Integer>,
 * indicando che è un repository per l'entità CartaFedelta con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti CartaFedelta.
 */
public interface CartaFedeltaRepository extends JpaRepository<CartaFedelta, Integer> {

    /**
     * findByClient è un metodo che recupera una lista di oggetti CartaFedelta associati a un determinato Client.
     *
     * @param client Il cliente per cui recuperare gli oggetti CartaFedelta associati.
     * @return Una lista di oggetti CartaFedelta associati al cliente specificato.
     */
    List<CartaFedelta> findByClient(Client client);
    List<CartaFedelta> findByClientAndPuntoVendita(Client client, PuntoVendita puntoVendita);
}

