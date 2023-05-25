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

@RestController
@CrossOrigin
public class ControllerAzienda {

    @Autowired
    AziendaRepository aziendaRepository;

    @GetMapping("/getAziende")
    public List<Azienda> vediAziende(){
        return(List<Azienda>) aziendaRepository.findAll();
    }


    @PostMapping("/insertAzienda")
    public String addAzienda(@RequestBody Azienda azienda){
        aziendaRepository.save(azienda);
        return "Azienda aggiunta con successo!";
    }

    @DeleteMapping("/deleteAzienda/{id}")
    public boolean deleteAzienda(@PathVariable int id){
        if(aziendaRepository.existsById(id))
        {
            aziendaRepository.deleteById(id);
        return true;
        } 
        return false;
    }

    @PutMapping("/modifyAzienda")
    public boolean modifyAzienda(@RequestBody Azienda azienda)
    {
        aziendaRepository.save(azienda);
        return true;
    }
    
}
