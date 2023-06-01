package projectIDS.dmd.controller.ControllerPersone;

import java.util.Collections;
import java.util.List;


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
import projectIDS.dmd.model.persone.Dipendente;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;
import projectIDS.dmd.repository.PersoneRepository.AdminRepository;
import projectIDS.dmd.repository.PersoneRepository.DipendenteRepository;
import projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository.PuntoVenditaRepository;

/**
 * Questa classe rappresenta il controller per le operazioni relative ai dipendenti.
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
 * viene utilizzata per iniettare un'istanza di Admin Repository, dipendenteRepository e puntoVenditaRepository nella classe ControllerDipendente. 
 * L'iniezione delle dipendenze, permette di utilizzare facilmente i metodi e le funzionalità offerte da AdminRepository, 
 * dipendenteRepository e PuntoVenditaRepository senza doverne gestire manualmente l'istanziazione.
 * 
 */
@RestController
@CrossOrigin
public class ControllerDipendente {
    @Autowired
    DipendenteRepository dipendenteRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    private PuntoVenditaRepository puntoVenditaRepository;

    /**
     * Restituisce una lista di tutti i dipendenti.
     *
     * @return una lista di tutti i dipendenti.
     */
    @GetMapping("/getDipendenti")
    public List<Dipendente> vediDipendenti()
    {
        return (List<Dipendente>) dipendenteRepository.findAll();
    }

    /**
     * Restituisce una lista di dipendenti appartenenti a un determinato punto vendita.
     *
     * @param id l'ID del punto vendita.
     * @return una lista di dipendenti appartenenti al punto vendita.
     */
    @GetMapping("/getDipendentiByPuntoVenditaId/{id}")
    public List<Dipendente> getDipendentiByPuntoVenditaId(@PathVariable int id) {
        PuntoVendita puntoVendita = puntoVenditaRepository.findById(id).get();
        if (puntoVendita == null) {
            // Punto vendita non trovato, restituisco una lista vuota
            return Collections.emptyList();
        }
        List<Dipendente> dipendentiPuntoVendita = dipendenteRepository.findByPuntoVendita(puntoVendita);
        return dipendentiPuntoVendita;
    }

    /**
     * Aggiunge un nuovo dipendente.
     *
     * @param dipendente il dipendente da aggiungere.
     * @return un messaggio di conferma dell'aggiunta.
     */
    @PostMapping("/insertDipendente")
    public String addDipendente(@RequestBody Dipendente dipendente)
    {
        dipendenteRepository.save(dipendente);
        return "Dipendente aggiunto con successo";
    }

    /**
     * Elimina un dipendente dato l'ID.
     *
     * @param id l'ID del dipendente da eliminare.
     * @return true se il dipendente è stato eliminato con successo, false altrimenti.
     */
    @DeleteMapping("/deleteDipendente/{id}")
    public boolean deleteDipendente(@PathVariable int id)
    {
        if(dipendenteRepository.existsById(id))
        {
            dipendenteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Modifica un dipendente esistente.
     *
     * @param dipendente il dipendente da modificare.
     * @return true se il dipendente è stato modificato con successo, false altrimenti.
     */
    @PutMapping("/modifyDipendente")
    public boolean modifyDipendente(@RequestBody Dipendente dipendente)
    {
        dipendenteRepository.save(dipendente);
        return true;
    }

    /**
     * Trasforma un dipendente in un amministratore.
     *
     * @param dipendente il dipendente da trasformare.
     * @return un messaggio di conferma dell'aggiunta dell'amministratore.
     */
    @PostMapping("/changeDipendenteToAdmin")
    public String changeDipendenteToAdmin(@RequestBody Dipendente dipendente){
        Admin newAdmin = new Admin();
        Dipendente newDipendente = dipendenteRepository.findById(dipendente.getId()).get();
        
        newAdmin.setNome(newDipendente.getNome());
        newAdmin.setCognome(newDipendente.getCognome());
        newAdmin.setEmail(newDipendente.getEmail());
        newAdmin.setNumeroTelefonico(newDipendente.getNumeroTelefonico());
        newAdmin.setPassword(newDipendente.getPassword());
        newAdmin.setUsername(newDipendente.getUsername());
        newAdmin.setPuntoVendita(newDipendente.getPuntoVendita());
        adminRepository.save(newAdmin);
        dipendenteRepository.delete(dipendente);

        return "Admin aggiunto con successo!";
    }
}

