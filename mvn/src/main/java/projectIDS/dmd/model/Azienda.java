package projectIDS.dmd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * A class representing a company.
 */
@Entity
@Table(name = "azienda")
public class Azienda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nomeAzienda;
    
    private String localitaAzienda;

    /**
     * Returns the ID of the company.
     * 
     * @return the ID of the company
     */
    public int getId() {
        return this.id;
    }

    /**
     * Returns the name of the company.
     * 
     * @return the name of the company
     */
    public String getNomeAzienda() {
        return this.nomeAzienda;
    }

    /**
     * Sets the name of the company.
     * 
     * @param newNomeAzienda the new name of the company
     */
    public void setNomeAzienda(String newNomeAzienda) {
        this.nomeAzienda = newNomeAzienda;
    }

    /**
     * Returns the location of the company.
     * 
     * @return the location of the company
     */
    public String getLocalitaAzienda() {
        return this.localitaAzienda;
    }

    /**
     * Sets the location of the company.
     * 
     * @param newLocalita the new location of the company
     */
    public void setLocalitaAzienda(String newLocalita) {
        this.localitaAzienda = newLocalita;
    }
} 

