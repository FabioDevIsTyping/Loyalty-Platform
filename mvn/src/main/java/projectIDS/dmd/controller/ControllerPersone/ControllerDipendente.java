package projectIDS.dmd.controller.ControllerPersone;

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
import projectIDS.dmd.repository.PersoneRepository.AdminRepository;
import projectIDS.dmd.repository.PersoneRepository.DipendenteRepository;

@RestController
@CrossOrigin
public class ControllerDipendente {
    @Autowired
    DipendenteRepository dipendenteRepository;
    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/getDipendenti")
    public List<Dipendente> vediDipendenti()
    {
        return (List<Dipendente>) dipendenteRepository.findAll();
    }

    @PostMapping("/insertDipendente")
    public String addDipendente(@RequestBody Dipendente dipendente)
    {
        dipendenteRepository.save(dipendente);
        return "Dipendente aggiunto con successo";
    }

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

    @PutMapping("/modifyDipendente")
    public boolean modifyDipendente(@RequestBody Dipendente dipendente)
    {
        dipendenteRepository.save(dipendente);
        return true;
    }

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
