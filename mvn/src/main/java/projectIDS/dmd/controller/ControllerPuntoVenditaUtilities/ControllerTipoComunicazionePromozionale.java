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

import projectIDS.dmd.model.puntovenditautilities.TipoComunicazionePromozionale;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.TipoComunicazionePromozionaleRepository;

import java.util.List;

/**
 * Questa classe rappresenta il controller per le operazioni relative ai tipi di comunicazione promozionale.
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
 * viene utilizzata per iniettare un'istanza di TipoComunicazionePromozionaleRepository nella classe 
 * ControllerTipoComunicazionePromozionale. L'iniezione delle dipendenze permette di utilizzare facilmente i metodi e le
 * funzionalità offerte da TipoComunicazionePromozionaleRepository senza doverne gestire manualmente l'istanziazione.
 */
@RestController
@CrossOrigin
public class ControllerTipoComunicazionePromozionale {
    @Autowired
    TipoComunicazionePromozionaleRepository tipoComunicazionePromozionaleRepository;

    /**
     * Restituisce una lista di tutti i tipi di comunicazione promozionale presenti nel sistema.
     *
     * @return una lista di oggetti TipoComunicazionePromozionale
     */
    @GetMapping("/getTipoComunicazionePromozionale")
    public List<TipoComunicazionePromozionale> vediTipiComunicazione()
    {
        return (List<TipoComunicazionePromozionale>) tipoComunicazionePromozionaleRepository.findAll();
    }

    /**
     * Aggiunge un nuovo tipo di comunicazione promozionale al sistema.
     *
     * @param tipoComunicazione l'oggetto TipoComunicazionePromozionale da aggiungere
     * @return un messaggio di conferma
     */
    @PostMapping("/insertTipoComunicazionePromozionale")
    public String addTipoComunicazione(@RequestBody TipoComunicazionePromozionale tipoComunicazione){
        tipoComunicazionePromozionaleRepository.save(tipoComunicazione);
        return "Tipo Comunicazione Promozionale aggiunto con successo!";
    }

    /**
     * Elimina un tipo di comunicazione promozionale dal sistema utilizzando l'ID.
     *
     * @param id l'ID del tipo di comunicazione promozionale da eliminare
     * @return true se l'eliminazione ha avuto successo, false altrimenti
     */
    @DeleteMapping("/deleteTipoComunicazionePromozionale/{id}")
    public boolean deleteTipoComunicazionePromozionale(@PathVariable int id){
        if(tipoComunicazionePromozionaleRepository.existsById(id))
        {
            tipoComunicazionePromozionaleRepository.deleteById(id);
            return true;
        } 
        return false;
    }

    /**
     * Modifica un tipo di comunicazione promozionale esistente nel sistema.
     *
     * @param tipoComunicazione l'oggetto TipoComunicazionePromozionale modificato
     * @return true se la modifica ha avuto successo, false altrimenti
     */
    @PutMapping("/modifyTipoComunicazionePromo")
    public boolean modifyProgramma(@RequestBody TipoComunicazionePromozionale tipoComunicazione)
    {
        tipoComunicazionePromozionaleRepository.save(tipoComunicazione);
        return true;
    }
}

