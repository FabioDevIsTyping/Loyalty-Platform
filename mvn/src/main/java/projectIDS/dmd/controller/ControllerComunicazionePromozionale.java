package projectIDS.dmd.controller;

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
import projectIDS.dmd.model.ComunicazionePromozionale;
import projectIDS.dmd.repository.ComunicazionePromozionaleRepository;

@RestController
@CrossOrigin
public class ControllerComunicazionePromozionale {
    @Autowired
    ComunicazionePromozionaleRepository comunicazioniPromozionaliRepository;

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
}
