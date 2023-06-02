package projectIDS.dmd.repository.ClienteUtilitiesRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.clienteutilities.PortafoglioCliente;
import projectIDS.dmd.model.persone.Client;


/**
 * PortafoglioClienteRepository è un'interfaccia che estende JpaRepository<PortafoglioCliente, Integer>,
 * indicando che è un repository per l'entità PortafoglioCliente con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti PortafoglioCliente.
 */
public interface PortafoglioClienteRepository extends JpaRepository<PortafoglioCliente, Integer> {

    /**
     * findByClient è un metodo che recupera l'oggetto PortafoglioCliente associato a un determinato Client.
     *
     * @param cliente Il cliente per cui recuperare l'oggetto PortafoglioCliente associato.
     * @return L'oggetto PortafoglioCliente associato al cliente specificato.
     */
    PortafoglioCliente findByClient(Client cliente);
}

