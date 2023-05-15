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
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ProgrammaFedelta_id")
    private ProgrammaFedelta programmaFedelta;
    
    private int punti;
    
    private Date dataScadenza;
    
    /**
     * Returns the id of this loyalty card.
     *
     * @return the id of this loyalty card
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Returns the client that owns this loyalty card.
     *
     * @return the client that owns this loyalty card
     */
    public Client getClient() {
        return this.client;
    }
    
    /**
     * Sets the client that owns this loyalty card.
     *
     * @param newClient the new client that owns this loyalty card
     */
    public void setClient(Client newClient) {
        this.client = newClient;
    }
    
    /**
     * Returns the loyalty program associated to this card.
     *
     * @return the loyalty program associated to this card
     */
    public ProgrammaFedelta getProgrammaFedelta() {
        return this.programmaFedelta;
    }
    
    /**
     * Sets the loyalty program associated to this card.
     *
     * @param newProgram the new loyalty program associated to this card
     */
    public void setProgrammaFedelta(ProgrammaFedelta newProgram) {
        this.programmaFedelta = newProgram;
    }
    
    /**
     * Returns the number of points associated to this loyalty card.
     *
     * @return the number of points associated to this loyalty card
     */
    public int getPunti() {
        return this.punti;
    }
    
    /**
     * Sets the number of points associated to this loyalty card.
     *
     * @param newAmount the new number of points associated to this loyalty card
     */
    public void setPunti(int newAmount) {
        this.punti = newAmount;
    }
    
    /**
     * Returns the expiration date of this loyalty card.
     *
     * @return the expiration date of this loyalty card
     */
    public Date getDataScadenza() {
        return this.dataScadenza;
    }
    
    /**
     * Sets the expiration date of this loyalty card.
     *
     * @param newDate the new expiration date of this loyalty card
     */
    public void setDataScadenza(Date newDate) {
        this.dataScadenza = newDate;
    }

    public PortafoglioCliente getPortafoglioCliente() {
        return portafoglioCliente;
    }

    public void setPortafoglioCliente(PortafoglioCliente portafoglioCliente) {
        this.portafoglioCliente = portafoglioCliente;
    }
    
    
}
