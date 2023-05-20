package projectIDS.dmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.Dipendente;

public interface DipendenteRepository extends JpaRepository<Dipendente,Integer>{
    
}
