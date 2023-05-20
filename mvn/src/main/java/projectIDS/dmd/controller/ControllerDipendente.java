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
import projectIDS.dmd.model.Dipendente;
import projectIDS.dmd.repository.DipendenteRepository;

@RestController
@CrossOrigin
public class ControllerDipendente {
    @Autowired
    DipendenteRepository dipendenteRepository;

    @GetMapping("/getDipendenti")
    public List<Dipendente> vediDipendenti()
    {
        return (List<Dipendente>) dipendenteRepository.findAll();
    }

    @PostMapping("/insertDipendente")
    public String addDipendente(@RequestBody Dipendente dipendente)
    {
        dipendenteRepository.save(dipendente);
        return "Dipendente aggiunto con successo";
    }

    @DeleteMapping("/deleteDipendente/{id}")
    public boolean deleteDipendente(@PathVariable int id)
    {
        if(dipendenteRepository.existsById(id))
        {
            dipendenteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/modifyDipendente")
    public boolean modifyDipendente(@RequestBody Dipendente dipendente)
    {
        dipendenteRepository.save(dipendente);
        return true;
    }
}
