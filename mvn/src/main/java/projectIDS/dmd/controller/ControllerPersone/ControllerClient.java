package projectIDS.dmd.controller.ControllerPersone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;
import projectIDS.dmd.repository.PersoneRepository.ClientRepository;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.PuntoVenditaRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Questa classe rappresenta il controller per le operazioni relative ai clienti.
 * 
 * @RestController è un'annotazione in Spring che viene utilizzata per indicare che la classe è un controller,
 * che gestisce le richieste HTTP e restituisce i risultati come risposte HTTP.
 * In sostanza, definisce un endpoint REST che può essere chiamato per eseguire operazioni specifiche.
 * 
 * @CrossOrigin è un'annotazione che viene utilizzata per consentire le richieste provenienti da domini diversi.
 * Abilitando questa annotazione il controller accetta richieste provenienti da un dominio diverso da quello in cui è 
 * ospitato il server.
 * 
 * @AutoWired è un'annotazione di Spring che viene utilizzata per eseguire l'iniezione delle dipendenze. In questo caso,
 * viene utilizzata per iniettare un'istanza di clientRepository e puntoVenditaRepository nella classe ControllerClient.
 * L'iniezione delle dipendenze, permette di utilizzare facilmente i metodi e le funzionalità offerte da clientRepository
 * e puntoVenditaRepository senza doverne gestire manualmente l'istanziazione.
 * 
 */
@RestController
@CrossOrigin
public class ControllerClient {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PuntoVenditaRepository puntoVenditaRepository;

    /**
     * 
     * Restituisce una lista di tutti i clienti.
     * 
     * @return una lista di tutti i clienti.
     */
    @GetMapping("/getClienti")
    public List<Client> vediUtenti() {
        List<Client> listaClienti = new ArrayList<Client>();
        listaClienti = clientRepository.findAll();
        return listaClienti;
    }

    /**
     * 
     * Aggiunge un nuovo cliente.
     * 
     * @param client il cliente da aggiungere.
     * @return un messaggio di conferma dell'aggiunta.
     */
    @PostMapping("/insertClient")
    public String addClient(@RequestBody Client client) {
        clientRepository.save(client);
        return "Utente aggiunto con successo!";
    }

    /**
     * 
     * Elimina un cliente dato l'ID.
     * 
     * @param id l'ID del cliente da eliminare.
     * @return true se il cliente è stato eliminato con successo, false altrimenti.
     */
    @DeleteMapping("/deleteClient/{id}")
    public boolean deleteClient(@PathVariable int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * 
     * Modifica un cliente esistente.
     * 
     * @param client il cliente da modificare.
     * @return true se il cliente è stato modificato con successo, false altrimenti.
     */
    @PutMapping("/modifyClient ")
    public boolean modifyClient(@RequestBody Client client) {
        clientRepository.save(client);
        return true;
    }

    /**
     * 
     * Restituisce una lista di clienti appartenenti a un determinato punto vendita.
     * 
     * @param id l'ID del punto vendita.
     * 
     * @return una lista di clienti appartenenti al punto vendita.
     */
    @GetMapping("/getClienti/{id}")
    public List<Client> vediClientiPuntoVendita(@PathVariable int id) {
        // Ottieni il punto vendita dal repository dei punti vendita utilizzando l'ID
        // fornito
        PuntoVendita puntoVendita = puntoVenditaRepository.findById(id).get();

        if (puntoVendita == null) {
            // Punto vendita non trovato, gestire l'errore come preferisci
            // Ad esempio, restituisci una risposta di errore o una lista vuota
            return Collections.emptyList();
        }

        // Ottieni la lista dei clienti appartenenti al punto vendita
        List<Client> clientiPuntoVendita = clientRepository.findByPuntiVendita(puntoVendita);

        return clientiPuntoVendita;
    }
}
