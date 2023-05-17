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
import projectIDS.dmd.model.Messaggio;
import projectIDS.dmd.repository.MessaggioRepository;

@RestController
@CrossOrigin
public class ControllerMessaggio {
    @Autowired
    MessaggioRepository messaggioRepository;

    @GetMapping("/getMessaggi")
    public List<Messaggio> vediMessaggi()
    {
        return (List<Messaggio>) messaggioRepository.findAll();
    }
    
    @PostMapping("/insertMessaggio")
    public String addMessaggio(@RequestBody Messaggio messaggio)
    {
        messaggioRepository.save(messaggio);
        return "Messaggio inviato con successo!";
    }

    @DeleteMapping("/deleteMessaggio/{id}")
    public boolean deleteMessaggio(@PathVariable int id)
    {
        if(messaggioRepository.existsById(id))
        {
            messaggioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/modifyMessaggio")
    public boolean modifyMessaggio(@RequestBody Messaggio messaggio)
    {
        messaggioRepository.save(messaggio);
        return true;
    }
}
