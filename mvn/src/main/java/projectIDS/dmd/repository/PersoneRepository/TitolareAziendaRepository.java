package projectIDS.dmd.repository.PersoneRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.persone.TitolareAzienda;

/**
 * TitolareAziendaRepository è un'interfaccia che estende JpaRepository<TitolareAzienda, Integer>,
 * indicando che è un repository per l'entità TitolareAzienda con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti TitolareAzienda.
 */
public interface TitolareAziendaRepository extends JpaRepository<TitolareAzienda, Integer> {

}

