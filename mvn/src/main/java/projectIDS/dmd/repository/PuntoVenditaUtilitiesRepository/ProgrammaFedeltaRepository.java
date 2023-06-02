package projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.puntovenditautilities.ProgrammaFedelta;

/**
 * ProgrammaFedeltaRepository è un'interfaccia che estende JpaRepository<ProgrammaFedelta, Integer>,
 * indicando che è un repository per l'entità ProgrammaFedelta con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti ProgrammaFedelta.
 */
public interface ProgrammaFedeltaRepository extends JpaRepository<ProgrammaFedelta, Integer> {

}

