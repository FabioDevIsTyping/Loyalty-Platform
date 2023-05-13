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
import projectIDS.dmd.model.Admin;
import projectIDS.dmd.repository.AdminRepository;


import java.util.List;

@RestController
@CrossOrigin
public class ControllerAdmin {
    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/getAdmins")
    public List<Admin> vediAdmin(){
        return (List<Admin>) adminRepository.findAll();
    }
    
    @PostMapping("/insertAdmin")
    public String addAdmin(@RequestBody Admin admin){
        adminRepository.save(admin);
        return "Admin aggiunto con successo!";
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public boolean deleteClient(@PathVariable int id) {
        if(adminRepository.existsById(id))
        {
            adminRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/modifyAdmin")
    public boolean modifyAdmin(@RequestBody Admin admin){
        adminRepository.save(admin);
        return true;
    }

    
}
