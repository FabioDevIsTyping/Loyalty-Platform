package projectIDS.dmd.model.puntovenditautilities;

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
 * Restituisce l'ID dell'azienda.
 *
 * @return l'ID dell'azienda
 */
public int getId() {
    return this.id;
}

/**
 * Restituisce il nome dell'azienda.
 *
 * @return il nome dell'azienda
 */
public String getNomeAzienda() {
    return this.nomeAzienda;
}

/**
 * Imposta il nome dell'azienda.
 *
 * @param newNomeAzienda il nuovo nome dell'azienda
 */
public void setNomeAzienda(String newNomeAzienda) {
    this.nomeAzienda = newNomeAzienda;
}

/**
 * Restituisce la località dell'azienda.
 *
 * @return la località dell'azienda
 */
public String getLocalitaAzienda() {
    return this.localitaAzienda;
}

/**
 * Imposta la località dell'azienda.
 *
 * @param newLocalita la nuova località dell'azienda
 */
public void setLocalitaAzienda(String newLocalita) {
    this.localitaAzienda = newLocalita;
}



} 

