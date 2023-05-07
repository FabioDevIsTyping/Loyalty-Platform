package projectIDS.dmd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projectIDS.dmd.model.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {
}
