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
import projectIDS.dmd.model.Acquisto;
import projectIDS.dmd.repository.AcquistoRepository;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerAcquisto {
    @Autowired
    AcquistoRepository acquistoRepository;
    // @Autowired 
    // ClientRepository clientRepository;

    @GetMapping("/getPurchases")
    public List<Acquisto> vediAcquisto(){
        return(List<Acquisto>) acquistoRepository.findAll();
    }

    @PostMapping("/insertPurchase")
    public String addAcquisto(@RequestBody Acquisto acquisto){
        acquistoRepository.save(acquisto);
        return "Acquisto aggiunto con successo!";
    }

    @DeleteMapping("/deletePurchase/{id}")
    public boolean deleteAcquisto(@PathVariable int id){
        if(acquistoRepository.existsById(id))
        {
            acquistoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/modifyPurchase")
    public boolean modifyAcquisto(@RequestBody Acquisto acquisto)
    {
        acquistoRepository.save(acquisto);
        return true;
    }

    // @GetMapping("/getAcquistiByClient({id})")
    // public List<Acquisto> getAcquistiByClient(@PathVariable int id)
    // {
    //     Client client = clientRepository.findById(id).get();
    //     List<Acquisto> listaAcquisti = acquistoRepository.findByClient(client);
    //     return listaAcquisti;
    // }

    
}
