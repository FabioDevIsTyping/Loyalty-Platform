package projectIDS.dmd.controller.ControllerPuntoVenditaUtilities;

import java.time.LocalDateTime;
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

import projectIDS.dmd.model.puntovenditautilities.ComunicazionePromozionale;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;
import projectIDS.dmd.repository.PersoneRepository.ClientRepository;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.ComunicazionePromozionaleRepository;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.PuntoVenditaRepository;

@RestController
@CrossOrigin
public class ControllerComunicazionePromozionale {
    @Autowired
    ComunicazionePromozionaleRepository comunicazioniPromozionaliRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired 
    PuntoVenditaRepository puntoVenditaRepository;

    @GetMapping("/getComunicazioni")
    public List<ComunicazionePromozionale> vediMessaggi()
    {
        return (List<ComunicazionePromozionale>) comunicazioniPromozionaliRepository.findAll();
    }
    
    @PostMapping("/insertComunicazione")
    public String addMessaggio(@RequestBody ComunicazionePromozionale comunicazione)
    {
        comunicazione.setOrarioDiInvio(LocalDateTime.now());
        comunicazioniPromozionaliRepository.save(comunicazione);
        return "Messaggio inviato con successo!";
    }

    @DeleteMapping("/deleteComunicazione/{id}")
    public boolean deleteMessaggio(@PathVariable int id)
    {
        if(comunicazioniPromozionaliRepository.existsById(id))
        {
            comunicazioniPromozionaliRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/modifyMessaggio")
    public boolean modifyMessaggio(@RequestBody ComunicazionePromozionale messaggio)
    {
        comunicazioniPromozionaliRepository.save(messaggio);
        return true;
    }

    @PostMapping("/insertComunicazione/{id}")
public String addMessaggio(@RequestBody ComunicazionePromozionale comunicazione, @PathVariable int id) {
    PuntoVendita puntoVendita = puntoVenditaRepository.findById(id).get(); // Supponendo che tu abbia un repository per l'entità PuntoVendita
    
    if (puntoVendita != null) {
        comunicazione.setOrarioDiInvio(LocalDateTime.now());
        comunicazione.setPuntoVendita(puntoVendita);
        comunicazione.setClientiDestinatari(clientRepository.findByPuntiVendita(puntoVendita)); // Supponendo che il punto vendita abbia un metodo per ottenere la lista dei clienti
        
        comunicazioniPromozionaliRepository.save(comunicazione);
        
        return "Messaggio inviato con successo!";
    }
    
    return "Punto vendita non trovato!";
}

}