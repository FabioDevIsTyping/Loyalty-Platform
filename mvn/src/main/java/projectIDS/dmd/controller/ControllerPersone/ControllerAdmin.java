package projectIDS.dmd.controller.ControllerPersone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import projectIDS.dmd.model.persone.Admin;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;
import projectIDS.dmd.repository.PersoneRepository.AdminRepository;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.PuntoVenditaRepository;

import java.util.Collections;
import java.util.List;

/**
 * Questa classe rappresenta il controller per le operazioni relative agli amministratori.
 * 
 *
 * @RestController è un'annotazione in Spring che viene utilizzata per indicare che la classe è un controller,
 * che gestisce le richieste HTTP e restituisce i risultati come risposte HTTP.
 * In sostanza, definisce un endpoint REST che può essere chiamato per eseguire operazioni specifiche.
 * 
 * @CrossOrigin è un'annotazione che viene utilizzata per consentire le richieste provenienti da domini diversi.
 * Abilitando questa annotazione il controller accetta richieste provenienti da un dominio diverso da quello in cui è 
 * ospitato il server.
 * 
 * @AutoWired è un'annotazione di Spring che viene utilizzata per eseguire l'iniezione delle dipendenze. In questo caso,
 * viene utilizzata per iniettare un'istanza di Admin Repository nella classe ControllerAdmin. L'iniezione delle dipendenze,
 * permette di utilizzare facilmente i metodi e le funzionalità offerte da AdminRepository senza doverne gestire manualmente
 * l'istanziazione.
 */
@RestController
@CrossOrigin
public class ControllerAdmin {
    @Autowired
    AdminRepository adminRepository;
    @Autowired 
    PuntoVenditaRepository puntoVenditaRepository;

    /**
     * Restituisce una lista di tutti gli amministratori.
     *
     * @return una lista di tutti gli amministratori.
     */
    @GetMapping("/getAdmins")
    public List<Admin> vediAdmin(){
        return (List<Admin>) adminRepository.findAll();
    }

/**
 * Recupera una lista di amministratori associati a un punto vendita specifico mediante l'ID.
 *
 * @param id L'ID del punto vendita.
 * @return Una lista di amministratori associati al punto vendita specificato.
 */
@GetMapping("/getAdminByPuntoVendita/{id}")
public List<Admin> getAdminByPuntoVendita(@PathVariable int id) {
    // Ottieni il punto vendita dal repository dei punti vendita utilizzando l'ID fornito
    PuntoVendita puntoVendita = puntoVenditaRepository.findById(id).get();

    if (puntoVendita == null) {
        // Punto vendita non trovato, ritorno lista vuota
        return Collections.emptyList();
    }

    // Ottieni la lista di amministratori appartenenti al punto vendita
    List<Admin> adminPuntiVendita = adminRepository.findByPuntoVendita(puntoVendita);
    return adminPuntiVendita;
}


    /**
     * Aggiunge un nuovo amministratore.
     *
     * @param admin l'amministratore da aggiungere.
     * @return un messaggio di conferma dell'aggiunta.
     */
    @PostMapping("/insertAdmin")
    public String addAdmin(@RequestBody Admin admin){
        adminRepository.save(admin);
        return "Admin aggiunto con successo!";
    }

    /**
     * Elimina un amministratore dato l'ID.
     *
     * @param id l'ID dell'amministratore da eliminare.
     * @return true se l'amministratore è stato eliminato con successo, false altrimenti.
     */
    @DeleteMapping("/deleteAdmin/{id}")
    public boolean deleteClient(@PathVariable int id) {
        if(adminRepository.existsById(id))
        {
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Modifica un amministratore esistente.
     *
     * @param admin l'amministratore da modificare.
     * @return true se l'amministratore è stato modificato con successo, false altrimenti.
     */
    @PutMapping("/modifyAdmin")
    public boolean modifyAdmin(@RequestBody Admin admin){
        adminRepository.save(admin);
        return true;
    }

}

