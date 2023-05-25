package projectIDS.dmd.repository.PersoneRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.persone.TitolareAzienda;

public interface TitolareAziendaRepository extends JpaRepository<TitolareAzienda,Integer>{
    
}
