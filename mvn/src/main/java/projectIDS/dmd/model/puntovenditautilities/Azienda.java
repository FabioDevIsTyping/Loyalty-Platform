package projectIDS.dmd.model.puntovenditautilities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import projectIDS.dmd.model.persone.TitolareAzienda;

/**
 * Rappresenta un'azienda nel sistema.
 *
 * La classe rappresenta un'azienda con le sue informazioni di base, come l'ID (chiave primaria),
 * il nome dell'azienda e la località dell'azienda.
 * 
 * L'identificatore unico per un azienda è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "azienda" e viene specificato utilizzando 
 * l'annotazione @Table.
 */
@Entity
@Table(name = "azienda")
public class Azienda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nomeAzienda;
    
    private String localitaAzienda;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "titolare_azienda_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public TitolareAzienda titolareAzienda;

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

