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
import projectIDS.dmd.repository.PersoneRepository.ClientRepository;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerClient {

    @Autowired
    ClientRepository clientRepository;

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


}
