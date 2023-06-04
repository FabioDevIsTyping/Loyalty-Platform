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

import projectIDS.dmd.controller.ControllerClienteUtilities.ControllerCartaFedelta;
import projectIDS.dmd.controller.ControllerPersone.ControllerClient;
import projectIDS.dmd.model.clienteutilities.CartaFedelta;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.ComunicazionePromozionale;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;
import projectIDS.dmd.model.puntovenditautilities.TipoComunicazionePromozionale;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.PuntoVenditaRepository;

import java.util.List;

/**
 * Questa classe rappresenta il controller per le operazioni relative ai punti vendita.
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
 * viene utilizzata per iniettare un'istanza di PuntoVenditaRepository, ControllerTipoComunicazionePromozionale,
 * ControllerComunicazionePromozionale, ControllerClient e ControllerCartaFedelta nella classe ControllerPuntoVendita.
 * L'iniezione delle dipendenze permette di utilizzare facilmente i metodi e le funzionalità offerte da 
 * PuntoVenditaRepository, ControllerTipoComunicazionePromozionale, ControllerComunicazionePromozionale, 
 * ControllerClient e ControllerCartaFedelta senza doverne gestire manualmente l'istanziazione.
 */
@RestController
@CrossOrigin
public class ControllerPuntoVendita {

    @Autowired
    PuntoVenditaRepository puntoVenditaRepository;
    @Autowired
    private ControllerTipoComunicazionePromozionale controllerTipoComunicazionePromozionale;
    @Autowired
    private ControllerComunicazionePromozionale controllerComunicazionePromozionale;
    @Autowired
    private ControllerClient controllerClient;
    @Autowired
    private ControllerCartaFedelta controllerCartaFedelta;

    /**
     * Restituisce una lista di tutti i punti vendita presenti nel sistema.
     *
     * @return una lista di oggetti PuntoVendita
     */
    @GetMapping("/getPuntiVendita")
    public List<PuntoVendita> vediPuntiVendita() {
        return (List<PuntoVendita>) puntoVenditaRepository.findAll();
    }

    /**
     * Restituisce una lista di tutti i punti vendita appartenenti a un'azienda specificata.
     *
     * @param idAzienda l'ID dell'azienda di cui si vogliono ottenere i punti vendita
     * @return una lista di oggetti PuntoVendita appartenenti all'azienda specificata
     */
     @GetMapping("/getPuntiVenditaByAzienda/{idAzienda}")
     public List<PuntoVendita> getPuntiVenditaByAzienda(@PathVariable int idAzienda) {
    
     return puntoVenditaRepository.findByAziendaId(idAzienda);
}


    /**
     * Aggiunge un nuovo punto vendita al sistema.
     *
     * @param negozio l'oggetto PuntoVendita da aggiungere
     * @return un messaggio di conferma
     */
     @PostMapping("/insertPuntoVendita")
     public String addPuntoVendita(@RequestBody PuntoVendita negozio) {
     puntoVenditaRepository.save(negozio);
     return "Punto vendita aggiunto con successo!";
}


    /**
     * Elimina un punto vendita dal sistema utilizzando l'ID.
     *
     * @param id l'ID del punto vendita da eliminare
     * @return true se l'eliminazione ha avuto successo, false altrimenti
     */
    @DeleteMapping("/deletePuntoVendita/{id}")
    public boolean deletePuntoVendita(@PathVariable int id){
        if(puntoVenditaRepository.existsById(id))
        {
            puntoVenditaRepository.deleteById(id);
            return true;
        } 
        return false;
    }

    /**
     * Modifica un punto vendita esistente nel sistema.
     *
     * @param negozio l'oggetto PuntoVendita modificato
     * @return true se la modifica ha avuto successo, false altrimenti
     */
    @PutMapping("/modifyPuntoVendita")
    public boolean modifyPuntoVendita(@RequestBody PuntoVendita negozio)
    {
        puntoVenditaRepository.save(negozio);
        return true;
    }

    /**
     * Restituisce una lista di tutti i tipi di comunicazione promozionale presenti nel sistema.
     *
     * @return una lista di oggetti TipoComunicazionePromozionale
     */
    @GetMapping("/sceltaTipoComunicazione")
    public List<TipoComunicazionePromozionale> sceltTipoComunicazionePromozionale()
    {
        return controllerTipoComunicazionePromozionale.vediTipiComunicazione();
    }

    /**
     * Restituisce una lista di clienti associati a un punto vendita specifico.
     *
     * @param id l'ID del punto vendita
     * @return una lista di oggetti Client
     */
    @GetMapping("/richiestaListaClienti/{id}")
    public List<Client> richiestaListaClienti(@PathVariable int id)
    {
        return controllerClient.vediClientiPuntoVendita(id);
    }

    /**
     * Invia una comunicazione promozionale.
     *
     * @param comunicazione l'oggetto ComunicazionePromozionale da inviare
     * @return un messaggio di conferma
     */
    @PostMapping("/invioComunicazione")
    public String invioComunicazione(@RequestBody ComunicazionePromozionale comunicazione)
    {
        return controllerComunicazionePromozionale.addMessaggio(comunicazione);
    }

    /**
     * Crea una carta fedeltà associata a un punto vendita specifico.
     *
     * @param carta l'oggetto CartaFedelta da creare
     * @param id l'ID del punto vendita
     * @return un messaggio di conferma
     */
    @PostMapping("/creazioneCartaFedelta/{id}")
    public String creazioneCartaFedelta(@RequestBody CartaFedelta carta,@PathVariable int id)
    {
        return controllerCartaFedelta.addCartaFedelta(carta, id);
    }
}

