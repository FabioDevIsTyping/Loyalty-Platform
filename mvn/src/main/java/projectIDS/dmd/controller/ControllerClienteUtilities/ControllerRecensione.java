package projectIDS.dmd.controller.ControllerClienteUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projectIDS.dmd.model.clienteutilities.Acquisto;
import projectIDS.dmd.model.clienteutilities.Recensione;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.AcquistoRepository;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.RecensioneRepository;
import projectIDS.dmd.repository.PersoneRepository.ClientRepository;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.PuntoVenditaRepository;

import java.util.Collections;
import java.util.List;


/**
 * Questa classe rappresenta il controller per le operazioni relative alle recensioni.
 *
 * @RestController è un'annotazione in Spring che viene utilizzata per indicare che la classe è un controller,
 * che gestisce le richieste HTTP e restituisce i risultati come risposte HTTP.
 * In sostanza, definisce un endpoint REST che può essere chiamato per eseguire operazioni specifiche.
 *
 * @CrossOrigin è un'annotazione che viene utilizzata per consentire le richieste provenienti da domini diversi.
 * Abilitando questa annotazione, il controller accetta richieste provenienti da un dominio diverso da quello in cui è
 * ospitato il server.
 *
 * @Autowired è un'annotazione di Spring che viene utilizzata per eseguire l'iniezione delle dipendenze. In questo caso,
 * viene utilizzata per iniettare istanze di PuntoVenditaRepository e RecensioneRepository nella classe ControllerRecensione.
 * L'iniezione delle dipendenze permette di utilizzare facilmente i metodi e le funzionalità offerte dalle repository senza
 * doverne gestire manualmente l'istanziazione.
 */
@RestController
@CrossOrigin
public class ControllerRecensione {

    @Autowired
    PuntoVenditaRepository puntoVenditaRepository;
    @Autowired
    RecensioneRepository recensioneRepository;
    @Autowired
    AcquistoRepository acquistoRepository;
    @Autowired 
    ClientRepository clientRepository;



    /**
     * Restituisce una lista di tutte le recensioni presenti nel sistema.
     *
     * @return una lista di oggetti Recensione
     */
    @GetMapping("/getRecensioni")
    public List<Recensione> vediRecensioni(){
        return (List<Recensione>) recensioneRepository.findAll();
    }

    /**
 * Recupera le recensioni associate a un punto vendita specifico mediante l'ID del punto vendita.
 *
 * @param idPuntoVendita L'ID del punto vendita.
 * @return Una lista di recensioni associate al punto vendita specificato.
 */
@GetMapping("/getRecensioniByPuntoVendita/{idPuntoVendita}")
public List<Recensione> getRecensioniByPuntoVendita(@PathVariable int idPuntoVendita) {
    // Ottieni il punto vendita dal repository dei punti vendita utilizzando l'ID fornito
    PuntoVendita puntoVendita = puntoVenditaRepository.findById(idPuntoVendita).get();

    if (puntoVendita == null) {
        // Punto vendita non trovato, restituisco una lista vuota
        return Collections.emptyList();
    }

    // Ottieni la lista di recensioni associate al punto vendita
    List<Recensione> recensioniPuntoVendita = recensioneRepository.findByPuntoVendita(puntoVendita);
    return recensioniPuntoVendita;
}


    /**
     * Aggiunge una nuova recensione al sistema.
     *
     * @param recensione l'oggetto Recensione da aggiungere
     * @return un messaggio di conferma
     */
    @PostMapping("/insertRecensione")
    public String addRecensione(@RequestBody Recensione recensione){
        recensioneRepository.save(recensione);
        return "Recensione aggiunta con successo!";
    }

/**
 * Inserisce una recensione se il cliente specificato ha effettuato almeno un acquisto presso il punto vendita specificato.
 *
 * @param recensione l'oggetto Recensione contenente i dettagli della recensione da inserire
 * @return una stringa indicante l'esito dell'operazione di inserimento della recensione
 * @throws IllegalArgumentException se il cliente o il punto vendita specificati non esistono
 */
@PostMapping("/insertRecensioneIfCliente")
public String insertRecensioneIfCliente(@RequestBody Recensione recensione) {
    Client client = clientRepository.findById(recensione.getCliente().getId())
            .orElseThrow(() -> new IllegalArgumentException("Il cliente specificato non esiste."));

    PuntoVendita puntoVendita = puntoVenditaRepository.findById(recensione.getPuntoVendita().getId())
            .orElseThrow(() -> new IllegalArgumentException("Il punto vendita specificato non esiste."));


    // Verifica se il cliente ha effettuato almeno un acquisto presso il punto vendita specificato
    if (client != null && puntoVendita != null && haEffettuatoAcquisto(client, puntoVendita)) {
        recensioneRepository.save(recensione);
        return "Recensione aggiunta con successo!";
    } else {
        return "Il cliente deve aver effettuato almeno un acquisto presso il punto vendita specificato.";
    }
}

    

/**
 * Verifica se il cliente specificato ha effettuato almeno un acquisto presso il punto vendita specificato.
 *
 * @param client il cliente per il quale verificare gli acquisti
 * @param puntoVendita il punto vendita presso il quale verificare gli acquisti
 * @return true se il cliente ha effettuato almeno un acquisto, false altrimenti
 */
private boolean haEffettuatoAcquisto(Client client, PuntoVendita puntoVendita) {
    List<Acquisto> acquisti = acquistoRepository.findByClientAndPuntoVendita(client, puntoVendita);
    return !acquisti.isEmpty();
}





 

    /**
     * Elimina una recensione dal sistema.
     *
     * @param id l'ID della recensione da eliminare
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti
     */
    @DeleteMapping("/deleteRecensione/{id}")
    public boolean deleteRecensione(@PathVariable int id){
        if(recensioneRepository.existsById(id))
        {
            recensioneRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Modifica una recensione esistente nel sistema.
     *
     * @param recensione l'oggetto Recensione modificato
     * @return true se la modifica è avvenuta con successo, false altrimenti
     */
    @PutMapping("/modifyRecensione")
    public boolean modifyRecensione(@RequestBody Recensione recensione){
        recensioneRepository.save(recensione);
        return true;
    }

    /**
     * Calcola la media dei voti delle recensioni per un dato punto vendita.
     *
     * @param id l'ID del punto vendita
     * @return la media dei voti come un numero decimale
     */
    @GetMapping("/getPuntoVenditaMedia/{id}")
    public Double getMediaVotiByPuntoVendita(@PathVariable int id) {
        PuntoVendita puntoVendita = puntoVenditaRepository.findById(id).get();
        List<Recensione> listaRecensioni = recensioneRepository.findByPuntoVendita(puntoVendita);
        int sommaVoti = 0;
        for (Recensione r : listaRecensioni) {
            sommaVoti += r.getVoto();
        }
        double mediaVoti = (double) sommaVoti / listaRecensioni.size();
        return mediaVoti;
    }
}

