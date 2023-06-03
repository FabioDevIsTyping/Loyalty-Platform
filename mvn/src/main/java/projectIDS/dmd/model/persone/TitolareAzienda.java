package projectIDS.dmd.model.persone;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import projectIDS.dmd.model.puntovenditautilities.Azienda;

/**
 * Questa classe rappresenta un titolare di azienda.
 * 
 * Un oggetto TitolareAzienda viene utilizzato per memorizzare le informazioni 
 * di un titolare di azienda, inclusi il suo nome, cognome, username, password,
 * email, numero telefonico e le aziende di cui è titolare.
 * 
 * L'identificatore unico per un titolare di azienda è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "Titolari Azienda" e viene specificato utilizzando 
 * l'annotazione @Table.
 */
@Entity
@Table(name="Titolari Azienda")
public class TitolareAzienda {

    /**
     * L'identificatore unico per un titolare di azienda.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;
    private String username;
    private String password;
    private String email;
    private String numeroTelefonico;
    
    /**
     * Le aziende di cui è titolare il titolare di azienda.
     */
    @OneToMany(mappedBy = "titolareAzienda")
    @JsonIgnore
    private List<Azienda> aziende;

    /**
     * Restituisce l'identificatore del titolare di azienda.
     * 
     * @return l'identificatore del titolare di azienda
     */
    public int getId() {
        return id;
    }
    
    /**
     * Restituisce il nome del titolare di azienda.
     * 
     * @return il nome del titolare di azienda
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome del titolare di azienda.
     * 
     * @param nome il nome del titolare di azienda da impostare
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome del titolare di azienda.
     * 
     * @return il cognome del titolare di azienda
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome del titolare di azienda.
     * 
     * @param cognome il cognome del titolare di azienda da impostare
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce lo username del titolare di azienda.
     * 
     * @return lo username del titolare di azienda
     */
    public String getUsername() {
        return username;
    }

    /**
     * Imposta lo username del titolare di azienda.
     * 
     * @param username lo username del titolare di azienda da impostare
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Restituisce la password del titolare di azienda.
     * 
     * @return la password del titolare di azienda
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta la password del titolare di azienda.
     * 
     * @param password la password del titolare di azienda da impostare
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Restituisce l'email del titolare di azienda.
     * 
     * @return l'email del titolare di azienda
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta l'email del titolare di azienda.
     * 
     * @param email l'email del titolare di azienda da impostare
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce il numero telefonico del titolare di azienda.
     * 
     * @return il numero telefonico del titolare di azienda
     */
    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    /**
     * Imposta il numero telefonico del titolare di azienda.
     * 
     * @param numeroTelefonico il numero telefonico del titolare di azienda da impostare
     */
    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    /**
     * Restituisce la lista delle aziende di cui è titolare il titolare di azienda.
     * 
     * @return la lista delle aziende di cui è titolare il titolare di azienda
     */
    public List<Azienda> getAziende() {
        return aziende;
    }

    /**
     * Imposta la lista delle aziende di cui è titolare il titolare di azienda.
     * 
     * @param aziende la lista delle aziende di cui è titolare il titolare di azienda da impostare
     */
    public void setAziende(List<Azienda> aziende) {
        this.aziende = aziende;
    }

}


