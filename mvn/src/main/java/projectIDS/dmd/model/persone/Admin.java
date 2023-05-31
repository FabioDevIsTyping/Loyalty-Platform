package projectIDS.dmd.model.persone;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

/**
 * Rappresenta un amministratore nel sistema.
 *
 * La classe rappresenta un amministratore con le sue informazioni di base, come nome, cognome,
 * username, email, password e numero telefonico. Ogni amministratore può essere associato a
 * un singolo punto vendita tramite una relazione one-to-one.
 * 
 * L'identificatore unico per un amministratore è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "admin" e viene specificato utilizzando 
 * l'annotazione @Table.
 */
@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;
    private String username;
    private String password;
    private String email;
    private String numeroTelefonico;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "puntoVendita_id", referencedColumnName = "id")
    private PuntoVendita puntoVendita;

    /**
     * Restituisce l'ID di questo amministratore.
     *
     * @return l'ID di questo amministratore.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Restituisce il nome di questo amministratore.
     *
     * @return il nome di questo amministratore.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Imposta il nome di questo amministratore.
     *
     * @param newName il nuovo nome di questo amministratore.
     */
    public void setNome(String newName) {
        this.nome = newName;
    }

    /**
     * Restituisce il cognome di questo amministratore.
     *
     * @return il cognome di questo amministratore.
     */
    public String getCognome() {
        return this.cognome;
    }

    /**
     * Imposta il cognome di questo amministratore.
     *
     * @param newCognome il nuovo cognome di questo amministratore.
     */
    public void setCognome(String newCognome) {
        this.cognome = newCognome;
    }

    /**
     * Restituisce il punto vendita associato a questo amministratore.
     *
     * @return il punto vendita associato a questo amministratore.
     */
    public PuntoVendita getPuntoVendita() {
        return this.puntoVendita;
    }

    /**
     * Imposta il punto vendita associato a questo amministratore.
     *
     * @param newPuntoVendita il nuovo punto vendita associato a questo amministratore.
     */
    public void setPuntoVendita(PuntoVendita newPuntoVendita) {
        this.puntoVendita = newPuntoVendita;
    }

    /**
     * Restituisce lo username di questo amministratore.
     *
     * @return lo username di questo amministratore.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Imposta lo username di questo amministratore.
     *
     * @param username il nuovo username di questo amministratore.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Restituisce la password di questo amministratore.
     *
     * @return la password di questo amministratore.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta la password di questo amministratore.
     *
     * @param password la nuova password di questo amministratore.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Restituisce l'email di questo amministratore.
     *
     * @return l'email di questo amministratore.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta l'email di questo amministratore.
     *
     * @param email la nuova email di questo amministratore.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce il numero telefonico di questo amministratore.
     *
     * @return il numero telefonico di questo amministratore.
     */
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    /**
     * Imposta il numero telefonico di questo amministratore.
     *
     * @param numeroTelefonico il nuovo numero telefonico di questo amministratore.
     */
    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
}

