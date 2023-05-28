package projectIDS.dmd.model.clienteutilities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

@Entity 
@Table (name="Acquisti")
public class Acquisto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double importoAcquisto;
    private Date dataAcquisto;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name = "puntoVendita_id" , nullable = false)
    @JsonIgnore
    private PuntoVendita puntoVendita;

    /**
     * Returns the ID of this purchase.
     *
     * @return the ID of this purchase.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Returns the purchase amount.
     *
     * @return the purchase amount.
     */
    public double getImportoAcquisto() {
        return this.importoAcquisto;
    }

    /**
     * Sets the purchase amount.
     *
     * @param newImporto the new purchase amount.
     */
    public void setImportoAcquisto(double newImporto) {
        this.importoAcquisto = newImporto;
    }

    /**
     * Returns the date of the purchase.
     *
     * @return the date of the purchase.
     */
    public Date getDataAcquisto() {
        return this.dataAcquisto;
    }

    /**
     * Sets the date of the purchase.
     *
     * @param newDate the new date of the purchase.
     */
    public void setDataAcquisto(Date newDate) {
        this.dataAcquisto = newDate;
    }

   
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Returns the store where the purchase was made.
     *
     * @return the store where the purchase was made.
     */
    public PuntoVendita getPuntoVendita() {
        return this.puntoVendita;
    }

    /**
     * Sets the store where the purchase was made.
     *
     * @param newPuntoVendita the new store where the purchase was made.
     */
    public void setPuntoVendita(PuntoVendita newPuntoVendita) {
        this.puntoVendita = newPuntoVendita;
    }

}

