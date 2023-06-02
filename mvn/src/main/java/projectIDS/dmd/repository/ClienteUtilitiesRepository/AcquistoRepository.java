package projectIDS.dmd.repository.ClienteUtilitiesRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.clienteutilities.Acquisto;
import projectIDS.dmd.model.persone.Client;

/**
 * AcquistoRepository è un'interfaccia che estende JpaRepository<Acquisto, Integer>,
 * indicando che è un repository per l'entità Acquisto con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti Acquisto.
 */
public interface AcquistoRepository extends JpaRepository<Acquisto, Integer> {

    /**
     * findByClient è un metodo che recupera una lista di oggetti Acquisto associati a un determinato Client.
     *
     * @param client Il cliente per cui recuperare gli oggetti Acquisto associati.
     * @return Una lista di oggetti Acquisto associati al cliente specificato.
     */
    List<Acquisto> findByClient(Client client);
}


