package projectIDS.dmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.Client;
import projectIDS.dmd.model.PortafoglioCliente;
public interface PortafoglioClienteRepository extends JpaRepository<PortafoglioCliente,Integer>{

    PortafoglioCliente findByClient(Client cliente);
    
}
