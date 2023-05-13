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
import projectIDS.dmd.model.ProgrammaFedelta;
import projectIDS.dmd.repository.ProgrammaFedeltaRepository;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerProgrammaFedelta {
    @Autowired
    ProgrammaFedeltaRepository programmaFedeltaRepository;

    @GetMapping("/getProgrammiFedelta")
    public List<ProgrammaFedelta> vediProgramma(){
        return(List<ProgrammaFedelta>) programmaFedeltaRepository.findAll();
    }

    @PostMapping("/insertProgrammaFedelta")
    public String addProgramma(@RequestBody ProgrammaFedelta programma){
        programmaFedeltaRepository.save(programma);
        return "Programma Fedelta aggiunto con successo!";
    }

    @DeleteMapping("/deleteProgrammaFedelta/{id}")
    public boolean deleteProgrammaFedelta(@PathVariable int id){
        if(programmaFedeltaRepository.existsById(id))
        {
            programmaFedeltaRepository.deleteById(id);
        return true;
        } 
        return false;
    }
    

    @PutMapping("/modifyProgrammaFedelta")
    public boolean modifyProgramma(@RequestBody ProgrammaFedelta programma)
    {
        programmaFedeltaRepository.save(programma);
        return true;
    }
    
}
