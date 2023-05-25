package projectIDS.dmd.repository.PersoneRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.persone.Dipendente;

public interface DipendenteRepository extends JpaRepository<Dipendente,Integer>{
    
}
