package projectIDS.dmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projectIDS.dmd.model.PuntoVendita;
import projectIDS.dmd.repository.PuntoVenditaRepository;

import java.util.List;

@RestController
@CrossOrigin  
public class ControllerPuntoVendita {

    @Autowired
    PuntoVenditaRepository puntoVenditaRepository;

    @GetMapping("/getPuntiVendita")
    public List<PuntoVendita> vediPuntiVendita() {
        return (List<PuntoVendita>) puntoVenditaRepository.findAll();
    }

    @PostMapping("/insertPuntoVendita")
    public String addPuntoVendita(@RequestBody PuntoVendita negozio){
        puntoVenditaRepository.save(negozio);
        return "Punto vendita aggiunto con successo!";
    }

    @DeleteMapping("/deletePuntoVendita/{id}")
    public boolean deletePuntoVendita(@PathVariable int id){
        if(puntoVenditaRepository.existsById(id))
        {
            puntoVenditaRepository.deleteById(id);
        return true;
        } 
        return false;
    }

    @PutMapping("/modifyPuntoVendita ")
    public boolean modifyPuntoVendita(@RequestBody PuntoVendita negozio)
    {
        puntoVenditaRepository.save(negozio);
        return true;
    }

    
}
