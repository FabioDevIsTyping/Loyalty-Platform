package projectIDS.dmd.model;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "portafoglio_id")
    private PortafoglioCliente portafoglioCliente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ProgrammaFedelta_id")
    private ProgrammaFedelta programmaFedelta;

    private int punti;

    private Date dataScadenza;
    

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

    public Date getDataScadenza()
    {
        return this.dataScadenza;
    }

    public void setDataScadenza(Date newDate)
    {
        this.dataScadenza=newDate;
    }

}
