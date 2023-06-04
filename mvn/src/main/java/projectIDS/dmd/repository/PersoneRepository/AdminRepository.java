package projectIDS.dmd.repository.PersoneRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.persone.Admin;
import java.util.List;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;


/**
 * AdminRepository è un'interfaccia che estende JpaRepository<Admin, Integer>,
 * indicando che è un repository per l'entità Admin con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti Admin.
 */
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    List<Admin> findByPuntoVendita(PuntoVendita puntoVendita);
}
