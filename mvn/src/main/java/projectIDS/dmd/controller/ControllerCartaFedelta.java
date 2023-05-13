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
import projectIDS.dmd.model.CartaFedelta;
import projectIDS.dmd.repository.CartaFedeltaRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@CrossOrigin
public class ControllerCartaFedelta {
    @Autowired
    CartaFedeltaRepository cartaFedeltaRepository;

    @GetMapping("/getCarteFedelta")
    public List<CartaFedelta> vediCarte(){
        return StreamSupport.stream(cartaFedeltaRepository.findAll().spliterator(), false)
                            .collect(Collectors.toList());
    }
    

    @PostMapping("/insertCartaFedelta")
    public String addCartaFedelta(@RequestBody CartaFedelta carta){
        cartaFedeltaRepository.save(carta);
        return "Carta Fedelta aggiunta con successo!";
    }

    @DeleteMapping("/deleteCartaFedelta/{id}")
    public boolean deleteCarta(@PathVariable int id)
    {
        if(cartaFedeltaRepository.existsById(id))
        {
            cartaFedeltaRepository.deleteById(id);
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
