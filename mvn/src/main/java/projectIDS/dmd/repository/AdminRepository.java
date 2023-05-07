package projectIDS.dmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectIDS.dmd.model.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer>{
    
}
