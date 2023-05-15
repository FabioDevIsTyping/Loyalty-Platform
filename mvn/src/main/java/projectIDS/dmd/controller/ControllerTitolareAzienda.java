package projectIDS.dmd.controller;

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

import projectIDS.dmd.model.TitolareAzienda;
import projectIDS.dmd.repository.TitolareAziendaRepository;

@RestController
@CrossOrigin
public class ControllerTitolareAzienda {
    @Autowired
    TitolareAziendaRepository titolareAziendaRepository;
    
    @GetMapping("/getTitolariAzienda")
    public List<TitolareAzienda> vediTitolari()
    {
        return(List<TitolareAzienda>) titolareAziendaRepository.findAll();

    }

    @PostMapping("/insertTitolareAzienda")
    public String addTitolareAzienda(@RequestBody TitolareAzienda titolareAzienda)
    {
        titolareAziendaRepository.save(titolareAzienda);
        return "Titolare azienda aggiunto con successo!";
    }
    
    @DeleteMapping("/deleteTitolareAzienda/{id}")
    public boolean deleteTitolareAzienda(@PathVariable int id)
    {
        if(titolareAziendaRepository.existsById(id))
        {
            titolareAziendaRepository.deleteById(id);
            return true;
        }
        return false;

    }

    @PutMapping("/modifyTitolareAzienda")
    public boolean modifyTitolareAzienda(@RequestBody TitolareAzienda titolareAzienda)
    {
        titolareAziendaRepository.save(titolareAzienda);
        return true;
    }
}
