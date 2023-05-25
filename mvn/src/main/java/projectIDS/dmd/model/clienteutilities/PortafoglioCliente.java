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

@Entity
@Table(name = "Portafogli")
public class PortafoglioCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @OneToMany(mappedBy = "portafoglioCliente", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<CartaFedelta> carteFedelta;
    
    private int numeroCarte;
    private LocalDateTime ultimoAggiornamento;
    
    /**
     * Returns the unique identifier of this wallet.
     *
     * @return the identifier of this wallet
     */
    public int getId()
    {
        return this.id;
    }
    
    /**
     * Returns the client associated with this wallet.
     *
     * @return the client associated with this wallet
     */
    public Client getClient()
    {
        return this.client;
    }
    
    /**
     * Sets the client associated with this wallet.
     *
     * @param newClient the new client to associate with this wallet
     */
    public void setClient(Client newClient)
    {
        this.client = newClient;
    }
    
    /**
     * Returns the list of loyalty cards associated with this wallet.
     *
     * @return the list of loyalty cards associated with this wallet
     */
    public List<CartaFedelta> getCarteFedelta()
    {
        return this.carteFedelta;
    }
    
    /**
     * Sets the list of loyalty cards associated with this wallet.
     *
     * @param newListaCarte the new list of loyalty cards to associate with this wallet
     */
    public void setCarteFedelta(List<CartaFedelta> newListaCarte){
        this.carteFedelta = newListaCarte;
    }
    
    /**
     * Returns the number of loyalty cards associated with this wallet.
     *
     * @return the number of loyalty cards associated with this wallet
     */
    public int getNumeroCarte()
    {
        return this.numeroCarte;
    }
    
    /**
     * Sets the number of loyalty cards associated with this wallet.
     *
     * @param newNumeroCarte the new number of loyalty cards to associate with this wallet
     */
    public void setNumeroCarte(int newNumeroCarte)
    {
        this.numeroCarte=newNumeroCarte;
    }
    
    /**
     * Returns the date and time of the last update made to this wallet.
     *
     * @return the date and time of the last update made to this wallet
     */
    public LocalDateTime getUltimoAggiornamento()
    {
        return this.ultimoAggiornamento;
    }
    
    /**
     * Sets the date and time of the last update made to this wallet.
     *
     * @param newUltimoAggiornamento the new date and time of the last update to associate with this wallet
     */
    public void setUltimoAggiornamento(LocalDateTime newUltimoAggiornamento)
    {
        this.ultimoAggiornamento=newUltimoAggiornamento;
    }
    
}
