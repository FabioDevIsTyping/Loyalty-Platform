package projectIDS.dmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import projectIDS.dmd.model.Client;
import projectIDS.dmd.repository.ClientRepository;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/getClients")
    public List<Client> vediUtenti() {
        return (List<Client>) clientRepository.findAll();
    }



}
