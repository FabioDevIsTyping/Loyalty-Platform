package projectIDS.dmd.controller.ControllerPersone;

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

import projectIDS.dmd.controller.ControllerPuntoVenditaUtilities.ControllerProgrammaFedelta;
import projectIDS.dmd.model.persone.Dipendente;
import projectIDS.dmd.model.persone.TitolareAzienda;
import projectIDS.dmd.model.puntovenditautilities.ProgrammaFedelta;
import projectIDS.dmd.repository.PersoneRepository.TitolareAziendaRepository;

/**
 * Questa classe rappresenta il controller per le operazioni relative al titolare dell'azienda.
 * 
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
 * viene utilizzata per iniettare un'istanza di titolareAziendaRepository,controllerDipendente,controllerProgrammaFedelta 
 * nella classe ControllerTitolareAzienda. L'iniezione delle dipendenze, permette di utilizzare facilmente i metodi 
 * e le funzionalità offerte da titolareAziendaRepository,controllerDipendente,controllerProgrammaFedelta
 * senza doverne gestire manualmente l'istanziazione.
 */
@RestController
@CrossOrigin
public class ControllerTitolareAzienda {
    @Autowired
    TitolareAziendaRepository titolareAziendaRepository;
    @Autowired
    private ControllerDipendente controllerDipendente;
    @Autowired 
    private ControllerProgrammaFedelta controllerProgrammaFedelta;

    /**
     * Restituisce una lista di tutti i titolari azienda.
     *
     * @return una lista di tutti i titolari azienda.
     */
    @GetMapping("/getTitolariAzienda")
    public List<TitolareAzienda> vediTitolareAzienda(){
        return (List<TitolareAzienda>) titolareAziendaRepository.findAll();
    }

    /**
     * Aggiunge un nuovo titolare azienda.
     *
     * @param titolareAzienda il titolare azienda da aggiungere.
     * @return un messaggio di conferma dell'aggiunta.
     */
    @PostMapping("/insertTitolareAzienda")
    public String addAdmin(@RequestBody TitolareAzienda titolareAzienda){
        titolareAziendaRepository.save(titolareAzienda);
        return "Titolare azienda aggiunto con successo!";
    }

    /**
     * Elimina un titolare azienda dato l'ID.
     *
     * @param id l'ID del titolare azienda da eliminare.
     * @return true se il titolare azienda è stato eliminato con successo, false altrimenti.
     */
    @DeleteMapping("/deleteTitolareAzienda/{id}")
    public boolean deleteTitolareAzienda(@PathVariable int id) {
        if(titolareAziendaRepository.existsById(id))
        {
            titolareAziendaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Modifica un titolare azienda esistente.
     *
     * @param titolareAzienda il titolare azienda da modificare.
     * @return true se il titolare azienda è stato modificato con successo, false altrimenti.
     */
    @PutMapping("/modifyTitolareAzienda")
    public boolean modifyTitolareAzienda(@RequestBody TitolareAzienda titolareAzienda){
        titolareAziendaRepository.save(titolareAzienda);
        return true;
    }

    /**
     * Restituisce una lista di tutti i dipendenti.
     *
     * @return una lista di tutti i dipendenti.
     */
    @GetMapping("/getListaDipendenti")
    public List<Dipendente> getDipendenti() {
        return controllerDipendente.vediDipendenti();
    }

    /**
     * Restituisce una lista di tutti i programmi fedeltà.
     *
     * @return una lista di tutti i programmi fedeltà.
     */
    @GetMapping("/adesioneProgrammaFedelta")
    public List<ProgrammaFedelta> adesioneProgrammaFedelta()
    {
        return controllerProgrammaFedelta.vediProgramma();
    }
}

