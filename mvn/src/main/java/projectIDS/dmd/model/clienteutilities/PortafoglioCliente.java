package projectIDS.dmd.model.clienteutilities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import projectIDS.dmd.model.persone.Client;

/**
 * Rappresenta il portafoglio di un cliente nel sistema.
 *
 * La classe rappresenta il portafoglio di un cliente e contiene informazioni come l'ID (chiave primaria), il cliente associato,
 * le carte fedeltà associate, il numero di carte, e l'ultima data e ora di aggiornamento del portafoglio.
 * 
 * L'identificatore unico per un portafoglio è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "Portafogli" e viene specificato utilizzando 
 * l'annotazione @Table.
 */
@Entity
@Table(name = "Portafogli")
public class PortafoglioCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Il cliente associato al portafoglio.
     */
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    /**
     * Le carte fedeltà associate al portafoglio.
     */
    @OneToMany(mappedBy = "portafoglioCliente", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<CartaFedelta> carteFedelta;

    /**
     * Il numero di carte fedeltà associate al portafoglio.
     */
    private int numeroCarte;

    /**
     * L'ultima data e ora di aggiornamento del portafoglio.
     */
    private LocalDateTime ultimoAggiornamento;

    /**
     * Restituisce l'identificatore unico di questo portafoglio.
     *
     * @return l'identificatore di questo portafoglio
     */
    public int getId()
    {
        return this.id;
    }

    /**
     * Restituisce il cliente associato a questo portafoglio.
     *
     * @return il cliente associato a questo portafoglio
     */
    public Client getClient()
    {
        return this.client;
    }

    /**
     * Imposta il cliente associato a questo portafoglio.
     *
     * @param newClient il nuovo cliente da associare a questo portafoglio
     */
    public void setClient(Client newClient)
    {
        this.client = newClient;
    }

    /**
     * Restituisce la lista delle carte fedeltà associate a questo portafoglio.
     *
     * @return la lista delle carte fedeltà associate a questo portafoglio
     */
    public List<CartaFedelta> getCarteFedelta()
    {
        return this.carteFedelta;
    }

    /**
     * Imposta la lista delle carte fedeltà associate a questo portafoglio.
     *
     * @param newListaCarte la nuova lista delle carte fedeltà da associare a questo portafoglio
     */
    public void setCarteFedelta(List<CartaFedelta> newListaCarte){
        this.carteFedelta = newListaCarte;
    }

    /**
     * Restituisce il numero di carte fedeltà associate a questo portafoglio.
     *
     * @return il numero di carte fedeltà associate a questo portafoglio
     */
    public int getNumeroCarte()
    {
        return this.numeroCarte;
    }

    /**
     * Imposta il numero di carte fedeltà associate a questo portafoglio.
     *
     * @param newNumeroCarte il nuovo numero di carte fedeltà da associare a questo portafoglio
     */
    public void setNumeroCarte(int newNumeroCarte)
    {
        this.numeroCarte=newNumeroCarte;
    }

    /**
     * Restituisce la data e ora dell'ultimo aggiornamento effettuato su questo portafoglio.
     *
     * @return la data e ora dell'ultimo aggiornamento effettuato su questo portafoglio
     */
    public LocalDateTime getUltimoAggiornamento()
    {
        return this.ultimoAggiornamento;
    }

    /**
     * Imposta la data e ora dell'ultimo aggiornamento effettuato su questo portafoglio.
     *
     * @param newUltimoAggiornamento la nuova data e ora dell'ultimo aggiornamento da associare a questo portafoglio
     */
    public void setUltimoAggiornamento(LocalDateTime newUltimoAggiornamento)
    {
        this.ultimoAggiornamento=newUltimoAggiornamento;
    }
}

