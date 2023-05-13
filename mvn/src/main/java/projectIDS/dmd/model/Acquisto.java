package projectIDS.dmd.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name="Acquisti")
public class Acquisto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dataAcquisto;
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client cliente;
    @ManyToOne
    @JoinColumn(name = "puntoVendita_id" , nullable = false)
    private PuntoVendita puntoVendita;

    public int getId()
    {
        return this.id;
    }

    public Date getDataAcquisto()
    {
        return this.dataAcquisto;
    }

    public void setDataAcquisto(Date newDate)
    {
        this.dataAcquisto = newDate;
    }

    public Client getCliente()
    {
        return this.cliente;
    }

    public void setCliente(Client newCliente)
    {
        this.cliente=newCliente;
    }

    public PuntoVendita getPuntoVendita()
    {
        return this.puntoVendita;
    }

    public void setPuntoVendita(PuntoVendita newPuntoVendita)
    {
        this.puntoVendita = newPuntoVendita;
    }

    
}
