package projectIDS.dmd.repository.PuntoVenditaUtilitiesRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.puntovenditautilities.Azienda;

public interface AziendaRepository extends JpaRepository<Azienda,Integer> {
    
}
