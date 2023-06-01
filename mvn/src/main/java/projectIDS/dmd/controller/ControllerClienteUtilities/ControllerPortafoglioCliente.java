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

import projectIDS.dmd.model.clienteutilities.PortafoglioCliente;
import projectIDS.dmd.repository.ClienteUtilitiesRepository.PortafoglioClienteRepository;

import java.util.List;

/**
 * Questa classe rappresenta il controller per le operazioni relative ai portafogli cliente.
 *
 * @RestController è un'annotazione in Spring che viene utilizzata per indicare che la classe è un controller,
 * che gestisce le richieste HTTP e restituisce i risultati come risposte HTTP.
 * In sostanza, definisce un endpoint REST che può essere chiamato per eseguire operazioni specifiche.
 *
 * @CrossOrigin è un'annotazione che viene utilizzata per consentire le richieste provenienti da domini diversi.
 * Abilitando questa annotazione, il controller accetta richieste provenienti da un dominio diverso da quello in cui è
 * ospitato il server.
 *
 * @Autowired è un'annotazione di Spring che viene utilizzata per eseguire l'iniezione delle dipendenze. In questo caso,
 * viene utilizzata per iniettare un'istanza di PortafoglioClienteRepository nella classe ControllerPortafoglioCliente.
 * L'iniezione delle dipendenze permette di utilizzare facilmente i metodi e le funzionalità offerte dalla repository senza
 * doverne gestire manualmente l'istanziazione.
 */
@RestController
@CrossOrigin
public class ControllerPortafoglioCliente {

    @Autowired
    PortafoglioClienteRepository portafoglioClienteRepository;

    /**
     * Restituisce una lista di tutti i portafogli cliente presenti nel sistema.
     *
     * @return una lista di oggetti PortafoglioCliente
     */
    @GetMapping("/getPortafoglio")
    public List<PortafoglioCliente> vediPortafogli(){
        return (List<PortafoglioCliente>) portafoglioClienteRepository.findAll();
    }

    /**
     * Aggiunge un nuovo portafoglio cliente al sistema.
     *
     * @param portafoglio l'oggetto PortafoglioCliente da aggiungere
     * @return un messaggio di conferma
     */
    @PostMapping("/insertPortafoglio")
    public String addPortafoglio(@RequestBody PortafoglioCliente portafoglio){
        portafoglioClienteRepository.save(portafoglio);
        return "Portafoglio aggiunto con successo!";
    }

    /**
     * Elimina un portafoglio cliente dal sistema.
     *
     * @param id l'ID del portafoglio da eliminare
     * @return true se l'eliminazione è avvenuta con successo, false altrimenti
     */
    @DeleteMapping("/deletePortafoglio/{id}")
    public boolean deletePortafoglio(@PathVariable int id){
        if(portafoglioClienteRepository.existsById(id))
        {
            portafoglioClienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Modifica un portafoglio cliente esistente nel sistema.
     *
     * @param portafoglio l'oggetto PortafoglioCliente modificato
     * @return true se la modifica è avvenuta con successo, false altrimenti
     */
    @PutMapping("/modifyPortafoglio")
    public boolean modifyPortafoglio(@RequestBody PortafoglioCliente portafoglio)
    {
        portafoglioClienteRepository.save(portafoglio);
        return true;
    }
}

