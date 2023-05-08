package projectIDS.dmd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="programmaFedelta")
public class ProgrammaFedelta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);

    private int id;
    private String 
    
}
