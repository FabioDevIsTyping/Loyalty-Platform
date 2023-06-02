package projectIDS.dmd.model.clienteutilities;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

/**
 * Rappresenta un acquisto nel sistema.
 *
 * La classe rappresenta un acquisto e contiene informazioni come l'ID (chiave
 * primaria), l'importo dell'acquisto
 * e la data dell'acquisto.
 * 
 * L'identificatore unico per un acquisto è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel
 * database è denominata "Acquisti" e viene specificato utilizzando
 * l'annotazione @Table.
 * 
 * Infine l'annotazione @JsonIgnore è stata introdotta per indicare che la
 * relazione con l'attributo puntoVendita
 * deve essere ignorata durante la serializzazione in formato Json, in questo
 * modo non si vanno a creare loop infiniti
 * dovuti alla relazione many to many quando si cercherà di effettuare una get.
 * 
 */
@Entity
@Table(name = "Acquisti")
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
    @JoinColumn(name = "puntoVendita_id", nullable = false)
    private PuntoVendita puntoVendita;

    /**
     * Restituisce l'ID di questo acquisto.
     *
     * @return l'ID di questo acquisto.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Restituisce l'importo dell'acquisto.
     *
     * @return l'importo dell'acquisto.
     */
    public double getImportoAcquisto() {
        return this.importoAcquisto;
    }

    /**
     * Imposta l'importo dell'acquisto.
     *
     * @param newImporto il nuovo importo dell'acquisto.
     */
    public void setImportoAcquisto(double newImporto) {
        this.importoAcquisto = newImporto;
    }

    /**
     * Restituisce la data dell'acquisto.
     *
     * @return la data dell'acquisto.
     */
    public Date getDataAcquisto() {
        return this.dataAcquisto;
    }

    /**
     * Imposta la data dell'acquisto.
     *
     * @param newDate la nuova data dell'acquisto.
     */
    public void setDataAcquisto(Date newDate) {
        this.dataAcquisto = newDate;
    }

    /**
     * Restituisce il cliente che ha effettuato l'acquisto.
     *
     * @return il cliente che ha effettuato l'acquisto.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Imposta il cliente che ha effettuato l'acquisto.
     *
     * @param client il nuovo cliente che ha effettuato l'acquisto.
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Restituisce il punto vendita in cui è stato effettuato l'acquisto.
     *
     * @return il punto vendita in cui è stato effettuato l'acquisto.
     */
    public PuntoVendita getPuntoVendita() {
        return this.puntoVendita;
    }

    /**
     * Imposta il punto vendita in cui è stato effettuato l'acquisto.
     *
     * @param newPuntoVendita il nuovo punto vendita in cui è stato effettuato
     *                        l'acquisto.
     */
    public void setPuntoVendita(PuntoVendita newPuntoVendita) {
        this.puntoVendita = newPuntoVendita;
    }

}
