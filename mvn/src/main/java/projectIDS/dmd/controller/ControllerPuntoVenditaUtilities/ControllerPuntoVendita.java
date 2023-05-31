package projectIDS.dmd.controller.ControllerPuntoVenditaUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projectIDS.dmd.controller.ControllerClienteUtilities.ControllerCartaFedelta;
import projectIDS.dmd.controller.ControllerPersone.ControllerClient;
import projectIDS.dmd.model.clienteutilities.CartaFedelta;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.ComunicazionePromozionale;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;
import projectIDS.dmd.model.puntovenditautilities.TipoComunicazionePromozionale;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.PuntoVenditaRepository;

import java.util.List;

@RestController
@CrossOrigin  
public class ControllerPuntoVendita {

    @Autowired
    PuntoVenditaRepository puntoVenditaRepository;
    @Autowired
    private ControllerTipoComunicazionePromozionale controllerTipoComunicazionePromozionale;
    @Autowired
    private ControllerComunicazionePromozionale controllerComunicazionePromozionale;
    @Autowired
    private ControllerClient controllerClient;
    @Autowired
    private ControllerCartaFedelta controllerCartaFedelta;

    @GetMapping("/getPuntiVendita")
    public List<PuntoVendita> vediPuntiVendita() {
        return (List<PuntoVendita>) puntoVenditaRepository.findAll();
    }

    @PostMapping("/insertPuntoVendita")
    public String addPuntoVendita(@RequestBody PuntoVendita negozio){
        puntoVenditaRepository.save(negozio);
        return "Punto vendita aggiunto con successo!";
    }

    @DeleteMapping("/deletePuntoVendita/{id}")
    public boolean deletePuntoVendita(@PathVariable int id){
        if(puntoVenditaRepository.existsById(id))
        {
            puntoVenditaRepository.deleteById(id);
        return true;
        } 
        return false;
    }

    @PutMapping("/modifyPuntoVendita ")
    public boolean modifyPuntoVendita(@RequestBody PuntoVendita negozio)
    {
        puntoVenditaRepository.save(negozio);
        return true;
    }

    @GetMapping("/sceltaTipoComunicazione")
    public List<TipoComunicazionePromozionale> sceltTipoComunicazionePromozionale()
    {
        return controllerTipoComunicazionePromozionale.vediTipiComunicazione();
    }

    @GetMapping("/richiestaListaClienti/{id}")
    public List<Client> richiestaListaClienti(@PathVariable int id)
    {
        return controllerClient.vediClientiPuntoVendita(id);
    }

    @PostMapping("/invioComunicazione")
    public String invioComunicazione(@RequestBody ComunicazionePromozionale comunicazione)
    {
        return controllerComunicazionePromozionale.addMessaggio(comunicazione);

    }

    @PostMapping("/creazioneCartaFedelta/{id}")
    public String creazioneCartaFedelta(@RequestBody CartaFedelta carta,@PathVariable int id)
    {
        return controllerCartaFedelta.addCartaFedelta(carta, id);
    }



    
}
