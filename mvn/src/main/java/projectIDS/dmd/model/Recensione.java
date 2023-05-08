package projectIDS.dmd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Entity
@Table(name = "recensioni",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"puntoVendita_id", "cliente_id"})
    })
public class Recensione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Min(0)
    @Max(10)
    private int voto;

    @Column(nullable=false)
    private String descrizione;

    @ManyToOne
    @JoinColumn(name = "puntoVendita_id", nullable = false)
    private PuntoVendita puntoVendita;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Client cliente;

    public int getId(){
        return this.id;
    }

    public int getVoto()
    {
        return this.voto;
    }

    public void setVoto(@Min(0) @Max(10) int newVoto)
    {
        this.voto = newVoto;
    }

    public String getDescrizione()
    {
        return this.descrizione;
    }

    public void setDescrizione(String newDescrizione)
    {
        this.descrizione = newDescrizione;
    }

    public PuntoVendita getPuntoVendita()
    {
        return this.puntoVendita;
    }

    public void setPuntoVendita(PuntoVendita newPuntoVendita)
    {
        newPuntoVendita = this.puntoVendita;
    }

    public Client getCliente()
    {
        return this.cliente;
    }

    public void setCliente(Client newCliente)
    {
        this.cliente=newCliente;

    }


}
