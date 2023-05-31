package projectIDS.dmd.model.persone;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;



/**
 * Rappresenta un cliente nel sistema.
 * 
 * La classe rappresenta un cliente con le sue informazioni di base, come nome, cognome,
 * username, email, password e numero telefonico. Ogni cliente può essere associato a
 * uno o più punti vendita tramite una relazione many-to-many.
 * 
 * L'identificatore unico per un cliente è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "cliente" e viene specificato utilizzando 
 * l'annotazione @Table.
 * 
 * Infine l'annotazione @JsonIgnore è stata introdotta per indicare che la relazione con l'attributo puntoVendita
 * deve essere ignorata durante la serializzazione in formato Json, in questo modo non si vanno a creare loop infiniti
 * dovuti alla relazione many to many quando si cercherà di effettuare una get
 */

@Entity
@Table(name = "cliente")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;
    private String username;
    private String email;
    private String password;
    private String numeroTelefonico;

    @ManyToMany
    @JsonIgnore
    private List<PuntoVendita> puntiVendita;

    /**
     * Restituisce l'ID di questo cliente.
     * 
     * @return l'ID di questo cliente
     */
    public int getId() {
        return this.id;
    }

    /**
     * Restituisce il nome di questo cliente.
     * 
     * @return il nome di questo cliente
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Imposta il nome di questo cliente.
     * 
     * @param nome il nuovo nome di questo cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome di questo cliente.
     * 
     * @return il cognome di questo cliente
     */
    public String getCognome() {
        return this.cognome;
    }

    /**
     * Imposta il cognome di questo cliente.
     * 
     * @param newCognome il nuovo cognome di questo cliente
     */
    public void setCognome(String newCognome) {
        this.cognome = newCognome;
    }

    /**
     * Restituisce lo username di questo cliente.
     * 
     * @return lo username di questo cliente
     */
    public String getUsername() {
        return username;
    }

    /**
     * Imposta lo username di questo cliente.
     * 
     * @param username il nuovo username di questo cliente
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Restituisce l'email di questo cliente.
     * 
     * @return l'email di questo cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta l'email di questo cliente.
     * 
     * @param email la nuova email di questo cliente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce la password di questo cliente.
     * 
     * @return la password di questo cliente
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta la password di questo cliente.
     * 
     * @param password la nuova password di questo cliente
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Restituisce il numero telefonico di questo cliente.
     * 
     * @return il numero telefonico di questo cliente
     */
    public String getNumeroTelefonico() {
        return this.numeroTelefonico;
    }

    /**
     * Imposta il numero telefonico di questo cliente.
     * 
     * @param newNumero il nuovo numero telefonico di questo cliente
     */
    public void setNumeroTelefonico(String newNumero) {
        this.numeroTelefonico = newNumero;
    }

    /**
     * Restituisce la lista dei punti vendita associati a questo cliente.
     * 
     * @return la lista dei punti vendita associati a questo cliente
     */
    public List<PuntoVendita> getPuntiVendita() {
        return puntiVendita;
    }

    /**
     * Imposta la lista dei punti vendita associati a questo cliente.
     * 
     * @param puntiVendita la nuova lista dei punti vendita associati a questo cliente
     */
    public void setPuntiVendita(List<PuntoVendita> puntiVendita) {
        this.puntiVendita = puntiVendita;
    }
}

