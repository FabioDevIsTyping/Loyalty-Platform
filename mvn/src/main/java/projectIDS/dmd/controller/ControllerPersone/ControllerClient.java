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

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class ControllerClient {

    @Autowired
    ClientRepository clientRepository;
    @Autowired 
    PuntoVenditaRepository puntoVenditaRepository;
    
    @GetMapping("/getClienti")
    public List<Client> vediUtenti() {
        return (List<Client>) clientRepository.findAll();
    }

    @PostMapping("/insertClient")
    public String addClient(@RequestBody Client client){
        clientRepository.save(client);
        return "Utente aggiunto con successo!";
    }

    @DeleteMapping("/deleteClient/{id}")
    public boolean deleteClient(@PathVariable int id){
        if(clientRepository.existsById(id))
        {
            clientRepository.deleteById(id);
        return true;
        } 
        return false;
    }

    @PutMapping("/modifyClient ")
    public boolean modifyClient(@RequestBody Client client)
    {
        clientRepository.save(client);
        return true;
    }

    @GetMapping("/getClienti/{id}")
public List<Client> vediClientiPuntoVendita(@PathVariable int id) {
    // Ottieni il punto vendita dal repository dei punti vendita utilizzando l'ID fornito
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
