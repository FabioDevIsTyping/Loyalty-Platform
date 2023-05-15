package projectIDS.dmd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

    /**
     * Returns the ID of this client.
     * 
     * @return the ID of this client
     */
    public int getId(){     
        return this.id;
    }

    /**
     * Returns the name of this client.
     * 
     * @return the name of this client
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Sets the name of this client.
     * 
     * @param nome the new name of this client
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Returns the surname of this client.
     * 
     * @return the surname of this client
     */
    public String getCognome() {
        return this.cognome;
    }

    /**
     * Sets the surname of this client.
     * 
     * @param newCognome the new surname of this client
     */
    public void setCognome(String newCognome) {
        this.cognome = newCognome;
    }

    /**
     * Returns the username of this client.
     * 
     * @return the username of this client
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of this client.
     * 
     * @param username the new username of this client
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the email of this client.
     * 
     * @return the email of this client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of this client.
     * 
     * @param email the new email of this client
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the password of this client.
     * 
     * @return the password of this client
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of this client.
     * 
     * @param password the new password of this client
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the phone number of this client.
     * 
     * @return the phone number of this client
     */
    public String getNumeroTelefonico()
    {
        return this.numeroTelefonico;
    }

    /**
     * Sets the phone number of this client.
     * 
     * @param newNumero the new phone number of this client
     */
    public void setNumeroTelefonico(String newNumero)
    {
        this.numeroTelefonico=newNumero;
    }
}
