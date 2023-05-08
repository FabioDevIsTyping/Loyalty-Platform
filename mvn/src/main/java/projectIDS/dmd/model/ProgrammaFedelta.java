package projectIDS.dmd.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="programmaFedelta")
public class ProgrammaFedelta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nomeProgramma;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "puntovendita_id")
    @OnDelete(action = OnDeleteAction.CASCADE)

    public int getId()
    {
        return this.id;
    }

    public String getNomeProgramma()
    {
        return this.nomeProgramma;
    }

    public void setNomeProgramma(String newNome)
    {
        this.nomeProgramma=newNome;
    }

    

    
    
}
