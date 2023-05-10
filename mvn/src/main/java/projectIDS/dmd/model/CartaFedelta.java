package projectIDS.dmd.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CartaFedelta")
public class CartaFedelta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name ="client_id")
    private Client client;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProgrammaFedelta_id")
    private ProgrammaFedelta programmaFedelta;
    private int punti;

    public int getId()
    {
        return this.id;
    }

    public Client getClient()
    {
        return this.client;
    }

    public void setClient(Client newClient)
    {
        this.client=newClient;
    }
    
    public ProgrammaFedelta getProgrogrammaFedelta()
    {
        return this.programmaFedelta;
    }

    public void setProgrogrammaFedelta(ProgrammaFedelta newProgram)
    {
        this.programmaFedelta=newProgram;
    }

    public int getPunti()
    {
        return this.punti;

    }

    public void setPunti(int newAmount)
    {
        this.punti = newAmount;
    }

}
