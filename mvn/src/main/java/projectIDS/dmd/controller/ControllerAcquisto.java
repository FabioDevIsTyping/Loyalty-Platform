package projectIDS.dmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import projectIDS.dmd.model.Acquisto;
import projectIDS.dmd.model.CartaFedelta;
import projectIDS.dmd.model.Client;
import projectIDS.dmd.repository.AcquistoRepository;
import projectIDS.dmd.repository.CartaFedeltaRepository;
import projectIDS.dmd.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ControllerAcquisto {
    @Autowired
    AcquistoRepository acquistoRepository;
    @Autowired
    CartaFedeltaRepository cartaFedeltaRepository;
    @Autowired
    ClientRepository clientRepository;
    // @Autowired 
    // ClientRepository clientRepository;

    @GetMapping("/getPurchases")
    public List<Acquisto> vediAcquisto(){
        return(List<Acquisto>) acquistoRepository.findAll();
    }

    @PostMapping("/insertPurchase/{id}")
    public String addAcquisto(@RequestBody Acquisto acquisto,@PathVariable int id){

        // List<CartaFedelta> listaCarteFedelta = new ArrayList<CartaFedelta>();
        // listaCarteFedelta = cartaFedeltaRepository.findByClient(client);
        CartaFedelta carta = cartaFedeltaRepository.findById(id).get();
        carta.setTotaleAcquisti(carta.getTotaleAcquisti()+acquisto.getImportoAcquisto());
        if(carta.getProgrammaFedelta().getId()==1)
        {
            carta.setPunti(carta.getPunti()+acquisto.getImportoAcquisto());
        }
        if(carta.getProgrammaFedelta().getId()==2)
        {
            if(carta.getTotaleAcquisti()>100)
            {
                carta.setLivello(2);
            }
            if(carta.getTotaleAcquisti()>200)
            {
                carta.setLivello(3);
            }
        }
        if(carta.getProgrammaFedelta().getId()==4)
        {
            carta.setPercentualeCashback(carta.getTotaleAcquisti()/5);
        }


        acquistoRepository.save(acquisto);
        cartaFedeltaRepository.save(carta);
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
