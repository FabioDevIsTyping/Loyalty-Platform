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

import projectIDS.dmd.model.puntovenditautilities.ProgrammaFedelta;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.ProgrammaFedeltaRepository;

import java.util.List;

/**
 * Questa classe rappresenta il controller per le operazioni relative ai programmi fedeltà.
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
 * viene utilizzata per iniettare un'istanza di ProgrammaFedeltaRepository nella classe ControllerProgrammaFedelta.
 * L'iniezione delle dipendenze permette di utilizzare facilmente i metodi e le funzionalità offerte da 
 * ProgrammaFedeltaRepository senza doverne gestire manualmente l'istanziazione.
 */
@RestController
@CrossOrigin
public class ControllerProgrammaFedelta {
    
    @Autowired
    ProgrammaFedeltaRepository programmaFedeltaRepository;

    /**
     * Restituisce una lista di tutti i programmi fedeltà presenti nel sistema.
     *
     * @return una lista di oggetti ProgrammaFedelta
     */
    @GetMapping("/getProgrammiFedelta")
    public List<ProgrammaFedelta> vediProgramma(){
        return (List<ProgrammaFedelta>) programmaFedeltaRepository.findAll();
    }

    /**
     * Aggiunge un nuovo programma fedeltà al sistema.
     *
     * @param programma l'oggetto ProgrammaFedelta da aggiungere
     * @return un messaggio di conferma
     */
    @PostMapping("/insertProgrammaFedelta")
    public String addProgramma(@RequestBody ProgrammaFedelta programma){
        programmaFedeltaRepository.save(programma);
        return "Programma Fedelta aggiunto con successo!";
    }

    /**
     * Elimina un programma fedeltà dal sistema utilizzando l'ID.
     *
     * @param id l'ID del programma fedeltà da eliminare
     * @return true se l'eliminazione ha avuto successo, false altrimenti
     */
    @DeleteMapping("/deleteProgrammaFedelta/{id}")
    public boolean deleteProgrammaFedelta(@PathVariable int id){
        if(programmaFedeltaRepository.existsById(id))
        {
            programmaFedeltaRepository.deleteById(id);
            return true;
        } 
        return false;
    }
    
    /**
     * Modifica un programma fedeltà esistente nel sistema.
     *
     * @param programma l'oggetto ProgrammaFedelta modificato
     * @return true se la modifica ha avuto successo, false altrimenti
     */
    @PutMapping("/modifyProgrammaFedelta")
    public boolean modifyProgramma(@RequestBody ProgrammaFedelta programma){
        programmaFedeltaRepository.save(programma);
        return true;
    }
}

