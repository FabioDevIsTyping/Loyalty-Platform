package projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository;


import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.puntovenditautilities.TipoComunicazionePromozionale;

/**
 * TipoComunicazionePromozionaleRepository è un'interfaccia che estende JpaRepository<TipoComunicazionePromozionale, Integer>,
 * indicando che è un repository per l'entità TipoComunicazionePromozionale con un identificatore di tipo Integer.
 * Fornisce operazioni di accesso ai dati per gestire gli oggetti TipoComunicazionePromozionale.
 */
public interface TipoComunicazionePromozionaleRepository extends JpaRepository<TipoComunicazionePromozionale, Integer> {

}

