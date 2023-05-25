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

import projectIDS.dmd.model.puntovenditautilities.TipoComunicazionePromozionale;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.TipoComunicazionePromozionaleRepository;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerTipoComunicazionePromozionale {
    @Autowired
    TipoComunicazionePromozionaleRepository tipoComunicazionePromozionaleRepository;

    @GetMapping("/getTipoComunicazionePromozionale")
    public List<TipoComunicazionePromozionale> vediTipiComunicazione()
    {
        return(List<TipoComunicazionePromozionale>)tipoComunicazionePromozionaleRepository.findAll();
    }

    @PostMapping("/insertTipoComunicazionePromozionale")
    public String addTipoComunicazione(@RequestBody TipoComunicazionePromozionale tipoComunicazione){
        tipoComunicazionePromozionaleRepository.save(tipoComunicazione);
        return "Tipo Comunicazione Promozionale aggiunto con successo!";
    }

    @DeleteMapping("/deleteTipoComunicazionePromozionale/{id}")
    public boolean deleteTipoComunicazionePromozionale(@PathVariable int id){
        if(tipoComunicazionePromozionaleRepository.existsById(id))
        {
            tipoComunicazionePromozionaleRepository.deleteById(id);
        return true;
        } 
        return false;
    }

    @PutMapping("/modifyTipoComunicazionePromo")
    public boolean modifyProgramma(@RequestBody TipoComunicazionePromozionale tipoComunicazione)
    {
        tipoComunicazionePromozionaleRepository.save(tipoComunicazione);
        return true;
    }
    



}
