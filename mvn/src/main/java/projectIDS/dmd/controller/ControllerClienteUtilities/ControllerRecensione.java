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

import projectIDS.dmd.model.clienteutilities.Recensione;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.RecensioneRepository;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.PuntoVenditaRepository;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerRecensione {
    @Autowired
    PuntoVenditaRepository puntoVenditaRepository;
    @Autowired
    RecensioneRepository recensioneRepository;

    @GetMapping("/getRecensioni")
    public List<Recensione> vediRecensioni(){

        return (List<Recensione>) recensioneRepository.findAll();
    }

    @PostMapping("/insertRecensione")
    public String addRecensione(@RequestBody Recensione recensione){
        recensioneRepository.save(recensione);
        return "Recensione aggiunta con successo!";
    }

    @DeleteMapping("/deleteRecensione/{id}")
    public boolean deleteRecensione(@PathVariable int id){
        if(recensioneRepository.existsById(id))
        {
            recensioneRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/modifyRecensione")
    public boolean modifyRecensione(@RequestBody Recensione recensione){
        recensioneRepository.save(recensione);
        return true;
    }

    @GetMapping("/getPuntoVenditaMedia/{id}")
    public Double getMediaVotiByPuntoVendita(@PathVariable int id) {

        PuntoVendita puntoVendita = puntoVenditaRepository.findById(id).get();
        List <Recensione> listaRecensioni = recensioneRepository.findByPuntoVendita(puntoVendita);
        int sommaVoti = 0;
        for (Recensione r : listaRecensioni) {
           sommaVoti += r.getVoto();
    }

double mediaVoti = (double) sommaVoti / listaRecensioni.size();
        //List<Integer> votiRecensioni

    return mediaVoti;
}


    
    
}
