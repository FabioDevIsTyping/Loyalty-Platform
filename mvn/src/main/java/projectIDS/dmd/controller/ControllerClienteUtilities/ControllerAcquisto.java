package projectIDS.dmd.controller.ControllerClienteUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projectIDS.dmd.model.clienteutilities.Acquisto;
import projectIDS.dmd.model.clienteutilities.CartaFedelta;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.AcquistoRepository;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.CartaFedeltaRepository;
import projectIDS.dmd.repository.PersoneRepository.ClientRepository;

import java.util.Collections;
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
        switch (carta.getProgrammaFedelta().getId()) {
            case 1:
                carta.setPunti(carta.getPunti() + acquisto.getImportoAcquisto());
                break;
            case 2:
                if (carta.getTotaleAcquisti() > 0) {
                    carta.setLivello(1);
                }
                if (carta.getTotaleAcquisti() > 100) {
                    carta.setLivello(2);
                }
                if (carta.getTotaleAcquisti() > 200) {
                    carta.setLivello(3);
                }
                if (carta.getTotaleAcquisti() > 500) {
                    carta.setLivello(4);
                }
                if (carta.getTotaleAcquisti() > 1000) {
                    carta.setLivello(5);
                }
                break;
            case 4:
                carta.setPercentualeCashback(carta.getTotaleAcquisti() / 5);
                break;
            default:
                // Gestione di eventuali altri casi
                break;
        }
        
        acquistoRepository.save(acquisto);
        cartaFedeltaRepository.save(carta);
        return "Acquisto aggiunto con successo!";
    }

    @DeleteMapping("/deletePurchase/{id}/{idCarta}")
    public boolean deleteAcquisto(@PathVariable int id, @PathVariable int idCarta) {
    if (acquistoRepository.existsById(id)) {
        Acquisto acquisto = acquistoRepository.findById(id).get();
        CartaFedelta carta = cartaFedeltaRepository.findById(idCarta).get();

        // Sottrarre l'importo dell'acquisto dai punti attuali della carta fedeltà
        carta.setPunti(carta.getPunti() - acquisto.getImportoAcquisto());

        // Aggiornare la carta fedeltà nel repository
        cartaFedeltaRepository.save(carta);

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

     @GetMapping("/getAcquistiByClient/{id}")
     public List<Acquisto> getAcquistiByClient(@PathVariable int id)
     {
         Client client = clientRepository.findById(id).get();
         if(client == null)
         return Collections.emptyList();
        List<Acquisto> listaAcquisti = acquistoRepository.findByClient(client);
         return listaAcquisti;
   }

    
}
