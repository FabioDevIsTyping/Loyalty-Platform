package projectIDS.dmd.repository.ClienteUtilitiesRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.clienteutilities.PortafoglioCliente;
import projectIDS.dmd.model.persone.Client;
public interface PortafoglioClienteRepository extends JpaRepository<PortafoglioCliente,Integer>{

    PortafoglioCliente findByClient(Client cliente);
    
}
