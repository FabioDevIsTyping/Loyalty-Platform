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
import projectIDS.dmd.model.clienteutilities.CartaFedelta;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.AcquistoRepository;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.CartaFedeltaRepository;
import projectIDS.dmd.repository.PersoneRepository.ClientRepository;

import java.util.Collections;
import java.util.List;

/**
 * Questa classe rappresenta il controller per le operazioni relative agli acquisti.
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
 * viene utilizzata per iniettare le istanze di AcquistoRepository, CartaFedeltaRepository e ClientRepository nella classe 
 * ControllerAcquisto. L'iniezione delle dipendenze permette di utilizzare facilmente i metodi e le funzionalità offerte
 * da queste repository senza doverne gestire manualmente l'istanziazione.
 */
@RestController
@CrossOrigin
public class ControllerAcquisto {
    @Autowired
    AcquistoRepository acquistoRepository;
    @Autowired
    CartaFedeltaRepository cartaFedeltaRepository;
    @Autowired
    ClientRepository clientRepository;

    /**
     * Restituisce una lista di tutti gli acquisti presenti nel sistema.
     *
     * @return una lista di oggetti Acquisto
     */
    @GetMapping("/getPurchases")
    public List<Acquisto> vediAcquisto(){
        return (List<Acquisto>) acquistoRepository.findAll();
    }

    /**
     * Aggiunge un nuovo acquisto al sistema e aggiorna i dati della carta fedeltà corrispondente.
     *
     * @param acquisto l'oggetto Acquisto da aggiungere
     * @param id l'ID della carta fedeltà associata all'acquisto
     * @return un messaggio di conferma
     */
    @PostMapping("/insertPurchase/{id}")
    public String addAcquisto(@RequestBody Acquisto acquisto,@PathVariable int id){
        CartaFedelta carta = cartaFedeltaRepository.findById(id).get();
        carta.setTotaleAcquisti(carta.getTotaleAcquisti()+acquisto.getImportoAcquisto());
        
        switch (carta.getProgrammaFedelta().getId()) {
            case 1:
                carta.setPunti(carta.getPunti() + acquisto.getImportoAcquisto());
                break;
            case 2:
                if (carta.getTotaleAcquisti() > 0) {
                    carta.setLivello(1);
                }
                if (carta.getTotaleAcquisti() > 100) {
                    carta.setLivello(2);
                }
                if (carta.getTotaleAcquisti() > 200) {
                    carta.setLivello(3);
                }
                if (carta.getTotaleAcquisti() > 500) {
                    carta.setLivello(4);
                }
                if (carta.getTotaleAcquisti() > 1000) {
                    carta.setLivello(5);
                }
                break;
            case 4:
                carta.setPercentualeCashback(carta.getTotaleAcquisti() / 5);
                break;
            default:
                // Gestione di eventuali altri casi
                break;
        }
        
        acquistoRepository.save(acquisto);
        cartaFedeltaRepository.save(carta);
        return "Acquisto aggiunto con successo!";
    }

    /**
     * Elimina un acquisto dal sistema e aggiorna i dati della carta fedeltà corrispondente.
     *
     * @param id l'ID dell'acquisto da eliminare
     * @param idCarta l'ID della carta fedeltà associata all'acquisto
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti
     */
    @DeleteMapping("/deletePurchase/{id}/{idCarta}")
    public boolean deleteAcquisto(@PathVariable int id, @PathVariable int idCarta) {
        if (acquistoRepository.existsById(id)) {
            Acquisto acquisto = acquistoRepository.findById(id).get();
            CartaFedelta carta = cartaFedeltaRepository.findById(idCarta).get();

            carta.setPunti(carta.getPunti() - acquisto.getImportoAcquisto());
            cartaFedeltaRepository.save(carta);

            acquistoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Modifica un acquisto esistente nel sistema.
     *
     * @param acquisto l'oggetto Acquisto modificato
     * @return true se la modifica è avvenuta con successo, false altrimenti
     */
    @PutMapping("/modifyPurchase")
    public boolean modifyAcquisto(@RequestBody Acquisto acquisto)
    {
        acquistoRepository.save(acquisto);
        return true;
    }

    /**
     * Restituisce una lista di tutti gli acquisti effettuati da un determinato cliente.
     *
     * @param id l'ID del cliente
     * @return una lista di oggetti Acquisto
     */
    @GetMapping("/getAcquistiByClient/{id}")
    public List<Acquisto> getAcquistiByClient(@PathVariable int id)
    {
        Client client = clientRepository.findById(id).get();
        if(client == null)
            return Collections.emptyList();
        
        List<Acquisto> listaAcquisti = acquistoRepository.findByClient(client);
        return listaAcquisti;
    }
}

