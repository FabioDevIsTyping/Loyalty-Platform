package projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.puntovenditautilities.Azienda;

/**
 * AziendaRepository è un'interfaccia che estende JpaRepository<Azienda, Integer>,
 * indicando che è un repository per l'entità Azienda con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti Azienda.
 */
public interface AziendaRepository extends JpaRepository<Azienda, Integer> {

}

