package projectIDS.dmd.model.persone;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

/**
 * Questa classe rappresenta un dipendente.
 * 
 * Un oggetto Dipendente viene utilizzato per memorizzare le informazioni 
 * di un dipendente, inclusi il suo nome, cognome, data di inizio e fine contratto,
 * numero telefonico, username, password, email, punto vendita di appartenenza e 
 * l'admin associato.
 * 
 * L'identificatore unico per un dipendente è l'id, che viene generato automaticamente
 * attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "Dipendenti" e viene specificato utilizzando 
 * l'annotazione @Table.
 * 
 * Infine l'annotazione @JsonIgnore è stata introdotta per indicare che la relazione con l'attributo puntoVendita
 * deve essere ignorata durante la serializzazione in formato Json, in questo modo non si vanno a creare loop infiniti
 * dovuti alla relazione many to many quando si cercherà di effettuare una get
 */
@Entity
@Table(name ="Dipendenti")
public class Dipendente {
    
    /**
     * L'identificatore unico per un dipendente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;
    private LocalDate dataInizioContratto;
    private LocalDate dataFineContratto;
    private String numeroTelefonico;
    private String username;
    private String password;
    private String email;

    /**
     * Il punto vendita di appartenenza del dipendente.
     */
    @ManyToOne
    @JoinColumn(name="puntoVendita_id")
    @JsonIgnore
    private PuntoVendita puntoVendita;

    /**
     * L'admin associato al dipendente.
     */
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;

    /**
     * Restituisce l'identificatore del dipendente.
     * 
     * @return l'identificatore del dipendente
     */
    public int getId() {
        return id;
    }

    /**
     * Restituisce il nome del dipendente.
     * 
     * @return il nome del dipendente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del dipendente.
     * 
     * @param nome il nome del dipendente da impostare
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome del dipendente.
     * 
     * @return il cognome del dipendente
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome del dipendente.
     * 
     * @param cognome il cognome del dipendente da impostare
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce la data di inizio contratto del dipendente.
     * 
     * @return la data di inizio contratto del dipendente
     */
    public LocalDate getDataInizioContratto() {
        return dataInizioContratto;
    }

    /**
     * Imposta la data di inizio contratto del dipendente.
     * 
     * @param dataInizioContratto la data di inizio contratto del dipendente da impostare
     */
    public void setDataInizioContratto(LocalDate dataInizioContratto) {
        this.dataInizioContratto = dataInizioContratto;
    }

    /**
     * Restituisce la data di fine contratto del dipendente.
     * 
     * @return la data di fine contratto del dipendente
     */
    public LocalDate getDataFineContratto() {
        return dataFineContratto;
    }

    /**
     * Imposta la data di fine contratto del dipendente.
     * 
     * @param dataFineContratto la data di fine contratto del dipendente da impostare
     */
    public void setDataFineContratto(LocalDate dataFineContratto) {
        this.dataFineContratto = dataFineContratto;
    }

    /**
     * Restituisce il punto vendita di appartenenza del dipendente.
     * 
     * @return il punto vendita di appartenenza del dipendente
     */
    public PuntoVendita getPuntoVendita() {
        return puntoVendita;
    }

    /**
     * Imposta il punto vendita di appartenenza del dipendente.
     * 
     * @param puntoVendita il punto vendita di appartenenza del dipendente da impostare
     */
    public void setPuntoVendita(PuntoVendita puntoVendita) {
        this.puntoVendita = puntoVendita;
    }

    /**
     * Restituisce lo username del dipendente.
     * 
     * @return lo username del dipendente
     */
    public String getUsername() {
        return username;
    }

    /**
     * Imposta lo username del dipendente.
     * 
     * @param username lo username del dipendente da impostare
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Restituisce la password del dipendente.
     * 
     * @return la password del dipendente
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta la password del dipendente.
     * 
     * @param password la password del dipendente da impostare
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Restituisce l'email del dipendente.
     * 
     * @return l'email del dipendente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta l'email del dipendente.
     * 
     * @param email l'email del dipendente da impostare
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce il numero telefonico del dipendente.
     * 
     * @return il numero telefonico del dipendente
     */
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    /**
     * Imposta il numero telefonico del dipendente.
     * 
     * @param numeroTelefonico il numero telefonico del dipendente da impostare
     */
    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    /**
     * Restituisce l'admin associato al dipendente.
     * 
     * @return l'admin associato al dipendente
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * Imposta l'admin associato al dipendente.
     * 
     * @param admin l'admin associato al dipendente da impostare
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}


