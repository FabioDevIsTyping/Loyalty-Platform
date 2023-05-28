package projectIDS.dmd.model.puntovenditautilities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tipi comunicazioni promozionali")
public class TipoComunicazionePromozionale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeComunicazione;


/**
 * Restituisce l'ID di questa comunicazione.
 *
 * @return l'ID di questa comunicazione
 */
public int getId() {
    return id;
}

/**
 * Restituisce il nome della comunicazione.
 *
 * @return il nome della comunicazione
 */
public String getNomeComunicazione() {
    return nomeComunicazione;
}

/**
 * Imposta il nome della comunicazione.
 *
 * @param nomeComunicazione il nuovo nome della comunicazione
 */
public void setNomeComunicazione(String nomeComunicazione) {
    this.nomeComunicazione = nomeComunicazione;
}


   
    
}
