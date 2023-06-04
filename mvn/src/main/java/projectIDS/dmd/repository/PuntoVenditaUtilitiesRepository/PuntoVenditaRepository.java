package projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

/**
 * PuntoVenditaRepository è un'interfaccia che estende JpaRepository<PuntoVendita, Integer>,
 * indicando che è un repository per l'entità PuntoVendita con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti PuntoVendita.
 */
public interface PuntoVenditaRepository extends JpaRepository<PuntoVendita, Integer> {
    List<PuntoVendita> findByAziendaId(int idAzienda);

}

