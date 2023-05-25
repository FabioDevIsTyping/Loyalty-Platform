package projectIDS.dmd.repository.PersoneRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectIDS.dmd.model.persone.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
    
}
