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
import projectIDS.dmd.model.PortafoglioCliente;
import projectIDS.dmd.repository.PortafoglioClienteRepository;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerPortafoglioCliente {

    @Autowired
    PortafoglioClienteRepository portafoglioClienteRepository;

    @GetMapping("/getPortafoglio")
    public List<PortafoglioCliente> vediPortafogli(){
        return(List<PortafoglioCliente>) portafoglioClienteRepository.findAll();
    }

    @PostMapping("/insertPortafoglio")
    public String addPortafoglio(@RequestBody PortafoglioCliente portafoglio){
        portafoglioClienteRepository.save(portafoglio);
        return "Portafoglio aggiunto con successo!";
    }

    @DeleteMapping("/deletePortafoglio/{id}")
    public boolean deletePortafoglio(@PathVariable int id){
        if(portafoglioClienteRepository.existsById(id))
        {
            portafoglioClienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/modifyPortafoglio")
    public boolean modifyPortafoglio(@RequestBody PortafoglioCliente portafoglio)
    {
        portafoglioClienteRepository.save(portafoglio);
        return true;
    }



    
}
