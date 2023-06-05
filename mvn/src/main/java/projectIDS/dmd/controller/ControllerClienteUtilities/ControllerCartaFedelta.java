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

import projectIDS.dmd.model.clienteutilities.CartaFedelta;
import projectIDS.dmd.model.clienteutilities.PortafoglioCliente;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.ProgrammaFedelta;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.CartaFedeltaRepository;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.PortafoglioClienteRepository;
import projectIDS.dmd.repository.PersoneRepository.ClientRepository;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.PuntoVenditaRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Questa classe rappresenta il controller per le operazioni relative alle carte fedeltà.
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
 * viene utilizzata per iniettare le istanze di CartaFedeltaRepository, ClientRepository e PortafoglioClienteRepository nella 
 * classe ControllerCartaFedelta. L'iniezione delle dipendenze permette di utilizzare facilmente i metodi e le funzionalità offerte
 * da queste repository senza doverne gestire manualmente l'istanziazione.
 */
@RestController
@CrossOrigin
public class ControllerCartaFedelta {
    @Autowired
    CartaFedeltaRepository cartaFedeltaRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PortafoglioClienteRepository portafoglioClienteRepository;
    @Autowired
    PuntoVenditaRepository puntoVenditaRepository;

    /**
     * Restituisce una lista di tutte le carte fedeltà presenti nel sistema.
     *
     * @return una lista di oggetti CartaFedelta
     */
    @GetMapping("/getCarteFedelta")
    public List<CartaFedelta> vediCarte(){
        return cartaFedeltaRepository.findAll();
    }

    /**
     * Aggiunge una nuova carta fedeltà al sistema e aggiorna i dati del portafoglio cliente corrispondente.
     *
     * @param carta l'oggetto CartaFedelta da aggiungere
     * @param id l'ID del cliente associato alla carta fedeltà
     * @return un messaggio di conferma
     */
    @PostMapping("/insertCartaFedelta/{id}")
    public String addCartaFedelta(@RequestBody CartaFedelta carta, @PathVariable int id){
        if(portafoglioClienteRepository.findByClient(clientRepository.findById(id).get()) != null) {
            PortafoglioCliente portafoglio = portafoglioClienteRepository.findByClient(clientRepository.findById(id).get());

            int numeroCarte = cartaFedeltaRepository.findByClient(clientRepository.findById(id).get()).size();
            numeroCarte = numeroCarte + 1;
            portafoglio.setNumeroCarte(numeroCarte);
            LocalDateTime now = LocalDateTime.now();
            portafoglio.setUltimoAggiornamento(now);

            portafoglioClienteRepository.save(portafoglio);
            carta.setPortafoglioCliente(portafoglio);
            cartaFedeltaRepository.save(carta);
            
            return "Carta Fedeltà aggiunta con successo!";
        } else {
            PortafoglioCliente portafoglio = new PortafoglioCliente();
            List<CartaFedelta> listaCarteFedelta = new ArrayList<CartaFedelta>();
            listaCarteFedelta.add(carta);
            portafoglio.setCarteFedelta(listaCarteFedelta);
            portafoglio.setClient(clientRepository.findById(id).get());
            portafoglio.setNumeroCarte(1);
            LocalDateTime now = LocalDateTime.now();
            portafoglio.setUltimoAggiornamento(now);
            portafoglioClienteRepository.save(portafoglio);
            carta.setPortafoglioCliente(portafoglio);
            cartaFedeltaRepository.save(carta);
            
            return "Portafoglio creato e carta aggiunta con successo!";
        }
    }

    /**
     * Elimina una carta fedeltà dal sistema e aggiorna i dati del portafoglio cliente corrispondente.
     *
     * @param id l'ID della carta fedeltà da eliminare
     * @param idUser l'ID dell'utente associato alla carta fedeltà
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti
     */
    @DeleteMapping("/deleteCartaFedelta/{id}/{idUser}")
    public boolean deleteCarta(@PathVariable int id, @PathVariable int idUser) {
        if(cartaFedeltaRepository.existsById(id)) {
            cartaFedeltaRepository.deleteById(id);
            PortafoglioCliente portafoglio = portafoglioClienteRepository.findByClient(clientRepository.findById(idUser).get());

            int numeroCarte = cartaFedeltaRepository.findByClient(clientRepository.findById(idUser).get()).size();
            portafoglio.setNumeroCarte(numeroCarte);
            LocalDateTime now = LocalDateTime.now();
            portafoglio.setUltimoAggiornamento(now);

            portafoglioClienteRepository.save(portafoglio);
            return true;
        }
        return false;
    }

    /**
     * Modifica una carta fedeltà esistente nel sistema.
     *
     * @param carta l'oggetto CartaFedelta modificato
     * @return true se la modifica è avvenuta con successo, false altrimenti
     */
    @PutMapping("/modifyCartaFedelta")
    public boolean modifyCarta(@RequestBody CartaFedelta carta) {
        cartaFedeltaRepository.save(carta);
        return true;
    }

/**
 * Recupera una lista di CartaFedelta associate a un cliente specifico.
 *
 * @param id L'ID del cliente.
 * @return La lista di CartaFedelta associate al cliente. Se il cliente non viene trovato, viene restituita una lista vuota.
 */
@GetMapping("/getCarteFedeltaByClient/{id}")
public List<CartaFedelta> getCarteFedeltaByClient(@PathVariable int id){
    Client client = clientRepository.findById(id).get();
    if(client == null)
    {
        return Collections.emptyList();
    }
    List<CartaFedelta> listaCarte = cartaFedeltaRepository.findByClient(client);

    return listaCarte;
}

/**
 * Recupera una lista di CartaFedelta associate a un cliente specifico e a un determinato punto vendita.
 *
 * @param clientId L'ID del cliente.
 * @param puntoVenditaId L'ID del punto vendita.
 * @return La lista di CartaFedelta associate al cliente e al punto vendita. Se il cliente o il punto vendita non vengono trovati, viene restituita una lista vuota.
 */
@GetMapping("/getCarteFedeltaByClientAndPuntoVendita/{clientId}/{puntoVenditaId}")
public List<CartaFedelta> getCarteFedeltaByClientAndPuntoVendita(@PathVariable int clientId, @PathVariable int puntoVenditaId){
    Client client = clientRepository.findById(clientId).get();
    PuntoVendita puntoVendita = puntoVenditaRepository.findById(puntoVenditaId).get();

    if(client == null || puntoVendita == null) {
        return Collections.emptyList();
    }

    List<CartaFedelta> listaCarte = cartaFedeltaRepository.findByClientAndPuntoVendita(client, puntoVendita);

    return listaCarte;
}


/**
 * Aggiorna il saldo cashback di una carta fedeltà.
 *
 * @param idCarta  L'ID della carta fedeltà da aggiornare.
 * @param importo  L'importo da sottrarre al saldo cashback.
 * @return Una stringa di errore se l'importo è maggiore del saldo cashback attuale, altrimenti null.
 */
@PutMapping("/updateSaldoCashback/{idCarta}/{importo}")
public String updateSaldoCashback(@PathVariable int idCarta, @PathVariable double importo) {
    CartaFedelta carta = cartaFedeltaRepository.findById(idCarta).orElse(null);
    if (carta == null) {
        return "Carta fedeltà non trovata";
    }

    ProgrammaFedelta programmaFedelta = carta.getProgrammaFedelta();
    if (programmaFedelta == null) {
        return "Programma fedeltà non trovato";
    }

    if (programmaFedelta.getId() == 4) {
        double saldoCashback = carta.getPercentualeCashback();
        if (importo > saldoCashback) {
            return "Errore: l'importo è maggiore del saldo cashback attuale";
        }

        double nuovoSaldoCashback = saldoCashback - importo;
        carta.setPercentualeCashback(nuovoSaldoCashback);
        cartaFedeltaRepository.save(carta);

        return "Cashback aggiornato con successo";
    } else {
        return "Il programma fedeltà associato a questa carta non è un programma cashback";
    }
}




}

