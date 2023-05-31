package projectIDS.dmd.model.clienteutilities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

/**
 * Rappresenta una recensione nel sistema.
 *
 * La classe rappresenta una recensione con le sue informazioni, come l'ID (chiave primaria), il voto, la descrizione,
 * il punto vendita associato e il cliente che ha scritto la recensione.
 * 
 * 
 * L'identificatore unico per una recensione è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "recensioni" e viene specificato utilizzando 
 * l'annotazione @Table.
 */
@Entity
@Table(name = "recensioni",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"puntoVendita_id", "cliente_id"})
    })
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Il voto (rating) della recensione, deve essere compreso tra 0 e 10.
     */
    @Min(0)
    @Max(10)
    private int voto;

    /**
     * La descrizione della recensione.
     */
    @Column(nullable=false)
    private String descrizione;

    /**
     * Il punto vendita associato alla recensione.
     */
    @ManyToOne
    @JoinColumn(name = "puntoVendita_id", nullable = false)
    private PuntoVendita puntoVendita;

    /**
     * Il cliente che ha scritto la recensione.
     */
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client cliente;

    /**
     * Restituisce l'ID della recensione.
     *
     * @return l'ID della recensione.
     */
    public int getId(){
        return this.id;
    }

    /**
     * Restituisce il voto della recensione.
     *
     * @return il voto della recensione.
     */
    public int getVoto()
    {
        return this.voto;
    }

    /**
     * Imposta il voto della recensione al valore specificato.
     *
     * @param newVoto il nuovo voto della recensione.
     */
    public void setVoto(@Min(0) @Max(10) int newVoto)
    {
        this.voto = newVoto;
    }

    /**
     * Restituisce la descrizione della recensione.
     *
     * @return la descrizione della recensione.
     */
    public String getDescrizione()
    {
        return this.descrizione;
    }

    /**
     * Imposta la descrizione della recensione al valore specificato.
     *
     * @param newDescrizione la nuova descrizione della recensione.
     */
    public void setDescrizione(String newDescrizione)
    {
        this.descrizione = newDescrizione;
    }

    /**
     * Restituisce il punto vendita associato alla recensione.
     *
     * @return il punto vendita associato alla recensione.
     */
    public PuntoVendita getPuntoVendita()
    {
        return this.puntoVendita;
    }

    /**
     * Imposta il punto vendita associato alla recensione al valore specificato.
     *
     * @param newPuntoVendita il nuovo punto vendita associato alla recensione.
     */
    public void setPuntoVendita(PuntoVendita newPuntoVendita)
    {
        this.puntoVendita = newPuntoVendita;
    }

    /**
     * Restituisce il cliente associato alla recensione.
     *
     * @return il cliente associato alla recensione.
     */
    public Client getCliente()
    {
        return this.cliente;
    }

    /**
     * Imposta il cliente associato alla recensione al valore specificato.
     *
     * @param newCliente il nuovo cliente associato alla recensione.
     */
    public void setCliente(Client newCliente)
    {
        this.cliente=newCliente;
    }
}

