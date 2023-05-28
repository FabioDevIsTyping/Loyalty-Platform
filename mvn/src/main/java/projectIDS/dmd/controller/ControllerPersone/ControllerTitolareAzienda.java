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

import projectIDS.dmd.model.persone.Dipendente;
import projectIDS.dmd.model.persone.TitolareAzienda;
import projectIDS.dmd.repository.PersoneRepository.TitolareAziendaRepository;

@RestController
@CrossOrigin
public class ControllerTitolareAzienda {
    @Autowired
    TitolareAziendaRepository titolareAziendaRepository;
    @Autowired
private ControllerDipendente controllerDipendente;

    @GetMapping("/getTitolareAzienda")
    public List<TitolareAzienda> vediTitolareAzienda(){
        return (List<TitolareAzienda>) titolareAziendaRepository.findAll();
    }

    @PostMapping("/insertTitolareAzienda")
    public String addAdmin(@RequestBody TitolareAzienda titolareAzienda){
        titolareAziendaRepository.save(titolareAzienda);
        return "Titolare azienda aggiunto con successo!";
    }

    @DeleteMapping("/deleteTitolareAzienda/{id}")
    public boolean deleteTitolareAzienda(@PathVariable int id) {
        if(titolareAziendaRepository.existsById(id))
        {
            titolareAziendaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/modifyTitolareAzienda")
    public boolean modifyTitolareAzienda(@RequestBody TitolareAzienda titolareAzienda){
        titolareAziendaRepository.save(titolareAzienda);
        return true;
    }

    @GetMapping("/getListaDipendenti")
    public List<Dipendente> getDipendenti() {
        return controllerDipendente.vediDipendenti();
    }



}
