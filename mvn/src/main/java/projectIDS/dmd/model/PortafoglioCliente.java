package projectIDS.dmd.model;

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

@Entity
@Table(name = "Portafogli")
public class PortafoglioCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "portafoglioCliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartaFedelta> carteFedelta;

    private int numeroCarte;
    private LocalDateTime ultimoAggiornamento;

    public int getId()
    {
        return this.id;
    }

    public Client getClient()
    {
        return this.client;
    }

    public void setClient(Client newClient)
    {
        this.client = newClient;
    }
    
    public List<CartaFedelta> getCarteFedelta()
    {
        return this.carteFedelta;
    }

    public void setCarteFedelta(List<CartaFedelta> newListaCarte){
        this.carteFedelta = newListaCarte;
    }

    public int getNumeroCarte()
    {
        return this.numeroCarte;
    }

    public void setNumeroCarte(int newNumeroCarte)
    {
        this.numeroCarte=newNumeroCarte;
    }

    public LocalDateTime getUltimoAggiornamento()
    {
        return this.ultimoAggiornamento;
    }

    public void setUltimoAggiornamento(LocalDateTime newUltimoAggiornamento)
    {
        this.ultimoAggiornamento=newUltimoAggiornamento;
    }
}
