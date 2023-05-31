package projectIDS.dmd.model.puntovenditautilities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * Rappresenta un tipo di comunicazione promozionale nel sistema.
 *
 * La classe rappresenta un tipo di comunicazione promozionale con le sue informazioni di base, come l'ID (chiave primaria)
 * e il nome della comunicazione.
 * 
 * L'identificatore unico per un tipo comunicazione promozionale è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "Tipi comunicazioni promozionali" e viene specificato utilizzando 
 * l'annotazione @Table.
 */

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
