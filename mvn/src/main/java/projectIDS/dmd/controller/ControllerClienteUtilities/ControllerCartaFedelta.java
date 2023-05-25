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

import projectIDS.dmd.model.clienteutilities.CartaFedelta;
import projectIDS.dmd.model.clienteutilities.PortafoglioCliente;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.CartaFedeltaRepository;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.PortafoglioClienteRepository;
import projectIDS.dmd.repository.PersoneRepository.ClientRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin
public class ControllerCartaFedelta {
    @Autowired
    CartaFedeltaRepository cartaFedeltaRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    PortafoglioClienteRepository portafoglioClienteRepository;

    @GetMapping("/getCarteFedelta")
    public List<CartaFedelta> vediCarte(){
        return StreamSupport.stream(cartaFedeltaRepository.findAll().spliterator(), false)
                            .collect(Collectors.toList());
    }
    

    @PostMapping("/insertCartaFedelta/{id}")
    public String addCartaFedelta(@RequestBody CartaFedelta carta,@PathVariable int id){
        if(portafoglioClienteRepository.findByClient(clientRepository.findById(id).get())!=null)
        {
            PortafoglioCliente portafoglio = portafoglioClienteRepository.findByClient(clientRepository.findById(id).get());

            int numeroCarte = cartaFedeltaRepository.findByClient(clientRepository.findById(id).get()).size();
            numeroCarte=numeroCarte+1;
            portafoglio.setNumeroCarte(numeroCarte);
            LocalDateTime now = LocalDateTime.now();
            portafoglio.setUltimoAggiornamento(now);

            portafoglioClienteRepository.save(portafoglio);
            carta.setPortafoglioCliente(portafoglio);
            cartaFedeltaRepository.save(carta);
        return "Carta Fedelta aggiunta con successo!";
        } 
        else
        {
            PortafoglioCliente portafoglio = new PortafoglioCliente();
            List <CartaFedelta> listaCarteFedelta = new ArrayList<CartaFedelta>();
            listaCarteFedelta.add(carta);
            portafoglio.setCarteFedelta(listaCarteFedelta);
            portafoglio.setClient(clientRepository.findById(id).get());
            portafoglio.setNumeroCarte(1);
            LocalDateTime now = LocalDateTime.now();
            portafoglio.setUltimoAggiornamento(now);
            portafoglioClienteRepository.save(portafoglio);
            carta.setPortafoglioCliente(portafoglio);
            cartaFedeltaRepository.save(carta);
            return "Portafoglio creato e carta aggiunta con successo!";
        }
    }

    @DeleteMapping("/deleteCartaFedelta/{id}/{idUser}")
    public boolean deleteCarta(@PathVariable int id,@PathVariable int idUser)
    {
        if(cartaFedeltaRepository.existsById(id))
        {
            cartaFedeltaRepository.deleteById(id);
            PortafoglioCliente portafoglio = portafoglioClienteRepository.findByClient(clientRepository.findById(idUser).get());

            int numeroCarte = cartaFedeltaRepository.findByClient(clientRepository.findById(idUser).get()).size();
            portafoglio.setNumeroCarte(numeroCarte);
            LocalDateTime now = LocalDateTime.now();
            portafoglio.setUltimoAggiornamento(now);

            portafoglioClienteRepository.save(portafoglio);
            return true;
        }
        return false;
    }
    
    @PutMapping("/modifyCartaFedelta")
    public boolean modifyCarta(@RequestBody CartaFedelta carta)
    {
        cartaFedeltaRepository.save(carta);
        return true;
    }


}
