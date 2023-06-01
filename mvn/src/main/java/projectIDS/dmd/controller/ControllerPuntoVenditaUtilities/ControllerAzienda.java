package projectIDS.dmd.controller.ControllerPuntoVenditaUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projectIDS.dmd.model.puntovenditautilities.Azienda;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.AziendaRepository;

import java.util.List;

/**
 * Questa classe rappresenta il controller per le operazioni relative ai clienti.
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
 * viene utilizzata per iniettare un'istanza di ClientRepository e PuntoVenditaRepository nella classe ControllerClient.
 * L'iniezione delle dipendenze permette di utilizzare facilmente i metodi e le funzionalità offerte da ClientRepository
 * e PuntoVenditaRepository senza doverne gestire manualmente l'istanziazione.
 */

@RestController
@CrossOrigin
public class ControllerAzienda {

    @Autowired
    AziendaRepository aziendaRepository;

    /**
     * Restituisce una lista di tutte le aziende.
     *
     * @return una lista di tutte le aziende.
     */
    @GetMapping("/getAziende")
    public List<Azienda> vediAziende(){
        return(List<Azienda>) aziendaRepository.findAll();
    }

    /**
     * Aggiunge una nuova azienda.
     *
     * @param azienda l'azienda da aggiungere.
     * @return un messaggio di conferma dell'aggiunta.
     */
    @PostMapping("/insertAzienda")
    public String addAzienda(@RequestBody Azienda azienda){
        aziendaRepository.save(azienda);
        return "Azienda aggiunta con successo!";
    }

    /**
     * Elimina un'azienda dato l'ID.
     *
     * @param id l'ID dell'azienda da eliminare.
     * @return true se l'azienda è stata eliminata con successo, false altrimenti.
     */
    @DeleteMapping("/deleteAzienda/{id}")
    public boolean deleteAzienda(@PathVariable int id){
        if(aziendaRepository.existsById(id))
        {
            aziendaRepository.deleteById(id);
            return true;
        } 
        return false;
    }

    /**
     * Modifica un'azienda esistente.
     *
     * @param azienda l'azienda da modificare.
     * @return true se l'azienda è stata modificata con successo, false altrimenti.
     */
    @PutMapping("/modifyAzienda")
    public boolean modifyAzienda(@RequestBody Azienda azienda)
    {
        aziendaRepository.save(azienda);
        return true;
    }
}

