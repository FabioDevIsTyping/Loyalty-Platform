package projectIDS.dmd.controller.ControllerPuntoVenditaUtilities;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projectIDS.dmd.model.puntovenditautilities.ComunicazionePromozionale;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;
import projectIDS.dmd.repository.PersoneRepository.ClientRepository;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.ComunicazionePromozionaleRepository;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.PuntoVenditaRepository;

/**
 * Questa classe rappresenta il controller per le operazioni relative alle
 * comunicazioni promozionali.
 * 
 * @RestController è un'annotazione in Spring che viene utilizzata per indicare
 *                 che la classe è un controller,
 *                 che gestisce le richieste HTTP e restituisce i risultati come
 *                 risposte HTTP.
 *                 In sostanza, definisce un endpoint REST che può essere
 *                 chiamato per eseguire operazioni specifiche.
 * 
 * @CrossOrigin è un'annotazione che viene utilizzata per consentire le
 *              richieste provenienti da domini diversi.
 *              Abilitando questa annotazione, il controller accetta richieste
 *              provenienti da un dominio diverso da quello in cui è
 *              ospitato il server.
 * 
 * @Autowired è un'annotazione di Spring che viene utilizzata per eseguire
 *            l'iniezione delle dipendenze. In questo caso,
 *            viene utilizzata per iniettare un'istanza di
 *            ComunicazionePromozionaleRepository, ClientRepository e
 *            PuntoVenditaRepository nella classe
 *            ControllerComunicazionePromozionale. L'iniezione delle dipendenze
 *            permette di
 *            utilizzare facilmente i metodi e le funzionalità offerte da
 *            ComunicazionePromozionaleRepository, ClientRepository e
 *            PuntoVenditaRepository senza doverne gestire manualmente
 *            l'istanziazione.
 */
@RestController
@CrossOrigin
public class ControllerComunicazionePromozionale {

    @Autowired
    ComunicazionePromozionaleRepository comunicazioniPromozionaliRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PuntoVenditaRepository puntoVenditaRepository;

    /**
     * Restituisce una lista di tutte le comunicazioni promozionali presenti nel
     * sistema.
     *
     * @return una lista di oggetti ComunicazionePromozionale
     */
    @GetMapping("/getComunicazioni")
    public List<ComunicazionePromozionale> vediMessaggi() {
        return (List<ComunicazionePromozionale>) comunicazioniPromozionaliRepository.findAll();
    }

    /**
     * Restituisce una lista di comunicazioni promozionali associate a un punto
     * vendita specifico mediante l'ID del punto vendita.
     *
     * @param idPuntoVendita L'ID del punto vendita.
     * @return Una lista di comunicazioni promozionali associate al punto vendita
     *         specificato.
     */
    @GetMapping("/getComunicazioniByPuntoVendita/{idPuntoVendita}")
    public List<ComunicazionePromozionale> getComunicazioniByPuntoVendita(@PathVariable int idPuntoVendita) {
        // Ottieni il punto vendita dal repository dei punti vendita utilizzando l'ID
        // fornito
        PuntoVendita puntoVendita = puntoVenditaRepository.findById(idPuntoVendita).get();

        if (puntoVendita == null) {
            // Punto vendita non trovato, gestisci l'errore come desideri
            // Ad esempio, restituisci una risposta di errore o una lista vuota
            return Collections.emptyList();
        }

        // Ottieni la lista di comunicazioni promozionali associate al punto vendita
        List<ComunicazionePromozionale> comunicazioniPuntoVendita = comunicazioniPromozionaliRepository
                .findByPuntoVenditaMittente(puntoVendita);
        return comunicazioniPuntoVendita;
    }

    /**
     * Aggiunge una nuova comunicazione promozionale al sistema.
     *
     * @param comunicazione l'oggetto ComunicazionePromozionale da aggiungere
     * @return un messaggio di conferma
     */
    @PostMapping("/insertComunicazione")
    public String addMessaggio(@RequestBody ComunicazionePromozionale comunicazione) {
        comunicazione.setOrarioDiInvio(LocalDateTime.now());
        comunicazioniPromozionaliRepository.save(comunicazione);
        return "Messaggio inviato con successo!";
    }

    /**
     * Elimina una comunicazione promozionale dal sistema utilizzando l'ID.
     *
     * @param id l'ID della comunicazione promozionale da eliminare
     * @return true se l'eliminazione ha avuto successo, false altrimenti
     */
    @DeleteMapping("/deleteComunicazione/{id}")
    public boolean deleteMessaggio(@PathVariable int id) {
        if (comunicazioniPromozionaliRepository.existsById(id)) {
            comunicazioniPromozionaliRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Modifica una comunicazione promozionale esistente nel sistema.
     *
     * @param messaggio l'oggetto ComunicazionePromozionale modificato
     * @return true se la modifica ha avuto successo, false altrimenti
     */
    @PutMapping("/modifyMessaggio")
    public boolean modifyMessaggio(@RequestBody ComunicazionePromozionale messaggio) {
        comunicazioniPromozionaliRepository.save(messaggio);
        return true;
    }

    /**
     * Aggiunge una nuova comunicazione promozionale associata a un punto vendita
     * specifico.
     *
     * @param comunicazione l'oggetto ComunicazionePromozionale da aggiungere
     * @param id            l'ID del punto vendita associato
     * @return un messaggio di conferma
     */
    @PostMapping("/insertComunicazioneByPuntoVendita/{id}")
    public String insertComunicazionePuntoVendita(@RequestBody ComunicazionePromozionale comunicazione, @PathVariable int id) {
        PuntoVendita puntoVendita = puntoVenditaRepository.findById(id).get();

        if (puntoVendita != null) {
            comunicazione.setOrarioDiInvio(LocalDateTime.now());
            comunicazione.setPuntoVendita(puntoVendita);
            comunicazione.setClientiDestinatari(clientRepository.findByPuntiVendita(puntoVendita));

            comunicazioniPromozionaliRepository.save(comunicazione);

            return "Messaggio inviato con successo!";
        }

        return "Punto vendita non trovato!";
    }
}
