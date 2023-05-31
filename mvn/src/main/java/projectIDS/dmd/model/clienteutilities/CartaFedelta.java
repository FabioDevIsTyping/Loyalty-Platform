package projectIDS.dmd.model.clienteutilities;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.Azienda;
import projectIDS.dmd.model.puntovenditautilities.ProgrammaFedelta;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

/**
 * Rappresenta una carta fedeltà nel sistema.
 *
 * La classe rappresenta una carta fedeltà e contiene informazioni come l'ID (chiave primaria), il cliente proprietario,
 * il portafoglio cliente associato, il programma fedeltà associato, il punto vendita associato, il numero di punti,
 * il livello, il nome del servizio, la percentuale di cashback, il totale degli acquisti, le aziende associate e la data di scadenza.
 * 
 * L'identificatore unico per una carta fedeltà è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "CartaFedelta" e viene specificato utilizzando 
 * l'annotazione @Table. 
 * 
 */
@Entity
@Table(name = "CartaFedelta")
public class CartaFedelta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Il cliente proprietario della carta fedeltà.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Client client;

    /**
     * Il portafoglio cliente associato alla carta fedeltà.
     */
    @ManyToOne
    @JoinColumn(name = "portafoglio_id")
    private PortafoglioCliente portafoglioCliente;

    /**
     * Il programma fedeltà associato alla carta.
     */
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ProgrammaFedelta_id")
    private ProgrammaFedelta programmaFedelta;

    /**
     * Il punto vendita associato alla carta fedeltà.
     */
    @ManyToOne
    @JoinColumn(name = "puntoVendita_id")
    private PuntoVendita puntoVendita;

    /**
     * Il numero di punti associati alla carta fedeltà.
     */
    private double punti;

    /**
     * Il livello della carta fedeltà.
     */
    @Nullable
    private int livello;

    /**
     * Il nome del servizio della carta fedeltà.
     */
    @Nullable
    private String nomeServizio;

    /**
     * La percentuale di cashback della carta fedeltà.
     */
    @Nullable
    private double percentualeCashback;

    /**
     * Il totale degli acquisti effettuati con la carta fedeltà.
     */
    private double totaleAcquisti;

    /**
     * Le aziende associate alla carta fedeltà.
     */
    @Nullable
    @ElementCollection
    private List<Azienda> aziendeAssociate;

    /**
     * La data di scadenza della carta fedeltà.
     */
    private Date dataScadenza;

    /**
     * Restituisce l'identificatore della carta fedeltà.
     *
     * @return l'identificatore della carta fedeltà
     */
    public int getId() {
        return this.id;
    }

    /**
     * Restituisce il cliente proprietario di questa carta fedeltà.
     *
     * @return il cliente proprietario di questa carta fedeltà
     */
    public Client getClient() {
        return this.client;
    }

    /**
     * Imposta il cliente proprietario di questa carta fedeltà.
     *
     * @param newClient il nuovo cliente proprietario di questa carta fedeltà
     */
    public void setClient(Client newClient) {
        this.client = newClient;
    }

    /**
     * Restituisce il programma fedeltà associato a questa carta.
     *
     * @return il programma fedeltà associato a questa carta
     */
    public ProgrammaFedelta getProgrammaFedelta() {
        return this.programmaFedelta;
    }

    /**
     * Imposta il programma fedeltà associato a questa carta.
     *
     * @param newProgram il nuovo programma fedeltà associato a questa carta
     */
    public void setProgrammaFedelta(ProgrammaFedelta newProgram) {
        this.programmaFedelta = newProgram;
    }

    /**
     * Restituisce il numero di punti associati a questa carta fedeltà.
     *
     * @return il numero di punti associati a questa carta fedeltà
     */
    public double getPunti() {
        return this.punti;
    }

    /**
     * Imposta il numero di punti associati a questa carta fedeltà.
     *
     * @param newAmount il nuovo numero di punti associati a questa carta fedeltà
     */
    public void setPunti(double newAmount) {
        this.punti = newAmount;
    }

    /**
     * Restituisce la data di scadenza di questa carta fedeltà.
     *
     * @return la data di scadenza di questa carta fedeltà
     */
    public Date getDataScadenza() {
        return this.dataScadenza;
    }

    /**
     * Imposta la data di scadenza di questa carta fedeltà.
     *
     * @param newDate la nuova data di scadenza di questa carta fedeltà
     */
    public void setDataScadenza(Date newDate) {
        this.dataScadenza = newDate;
    }

    /**
     * Restituisce il portafoglio cliente associato a questa carta fedeltà.
     *
     * @return il portafoglio cliente associato a questa carta fedeltà
     */
    public PortafoglioCliente getPortafoglioCliente() {
        return portafoglioCliente;
    }

    /**
     * Imposta il portafoglio cliente associato a questa carta fedeltà.
     *
     * @param portafoglioCliente il nuovo portafoglio cliente da associare a questa carta fedeltà
     */
    public void setPortafoglioCliente(PortafoglioCliente portafoglioCliente) {
        this.portafoglioCliente = portafoglioCliente;
    }

    /**
     * Restituisce il punto vendita associato a questa carta fedeltà.
     *
     * @return il punto vendita associato a questa carta fedeltà
     */
    public PuntoVendita getPuntoVendita() {
        return puntoVendita;
    }

    /**
     * Imposta il punto vendita associato a questa carta fedeltà.
     *
     * @param puntoVendita il nuovo punto vendita da associare a questa carta fedeltà
     */
    public void setPuntoVendita(PuntoVendita puntoVendita) {
        this.puntoVendita = puntoVendita;
    }

    /**
     * Restituisce il livello di questa carta fedeltà.
     *
     * @return il livello di questa carta fedeltà
     */
    public int getLivello() {
        return livello;
    }

    /**
     * Imposta il livello di questa carta fedeltà.
     *
     * @param livello il nuovo livello da associare a questa carta fedeltà
     */
    public void setLivello(int livello) {
        this.livello = livello;
    }

    /**
     * Restituisce il nome del servizio di questa carta fedeltà.
     *
     * @return il nome del servizio di questa carta fedeltà
     */
    public String getNomeServizio() {
        return nomeServizio;
    }

    /**
     * Imposta il nome del servizio di questa carta fedeltà.
     *
     * @param nomeServizio il nuovo nome del servizio da associare a questa carta fedeltà
     */
    public void setNomeServizio(String nomeServizio) {
        this.nomeServizio = nomeServizio;
    }

    /**
     * Restituisce la percentuale di cashback di questa carta fedeltà.
     *
     * @return la percentuale di cashback di questa carta fedeltà
     */
    public double getPercentualeCashback() {
        return percentualeCashback;
    }

    /**
     * Imposta la percentuale di cashback di questa carta fedeltà.
     *
     * @param percentualeCashback la nuova percentuale di cashback da associare a questa carta fedeltà
     */
    public void setPercentualeCashback(double percentualeCashback) {
        this.percentualeCashback = percentualeCashback;
    }

    /**
     * Restituisce la lista delle aziende associate a questa carta fedeltà.
     *
     * @return la lista delle aziende associate a questa carta fedeltà
     */
    public List<Azienda> getAziendeAssociate() {
        return aziendeAssociate;
    }

    /**
     * Imposta la lista delle aziende associate a questa carta fedeltà.
     *
     * @param aziendeAssociate la nuova lista delle aziende da associare a questa carta fedeltà
     */
    public void setAziendeAssociate(List<Azienda> aziendeAssociate) {
        this.aziendeAssociate = aziendeAssociate;
    }

    /**
     * Restituisce il totale degli acquisti effettuati con questa carta fedeltà.
     *
     * @return il totale degli acquisti effettuati con questa carta fedeltà
     */
    public double getTotaleAcquisti() {
        return totaleAcquisti;
    }

    /**
     * Imposta il totale degli acquisti effettuati con questa carta fedeltà.
     *
     * @param totaleAcquisti il nuovo totale degli acquisti da associare a questa carta fedeltà
     */
    public void setTotaleAcquisti(double totaleAcquisti) {
        this.totaleAcquisti = totaleAcquisti;
    }
}

