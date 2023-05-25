package projectIDS.dmd.model.clienteutilities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

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

/**
 * Returns the ID of the recensione
 * 
 * @return the ID of the recensione
 */
public int getId(){
    return this.id;
}

/**
 * Returns the voto (rating) of the recensione
 * 
 * @return the voto of the recensione
 */
public int getVoto()
{
    return this.voto;
}

/**
 * Sets the voto (rating) of the recensione to the specified value
 * 
 * @param newVoto the new voto of the recensione
 */
public void setVoto(@Min(0) @Max(10) int newVoto)
{
    this.voto = newVoto;
}

/**
 * Returns the descrizione (description) of the recensione
 * 
 * @return the descrizione of the recensione
 */
public String getDescrizione()
{
    return this.descrizione;
}

/**
 * Sets the descrizione (description) of the recensione to the specified value
 * 
 * @param newDescrizione the new descrizione of the recensione
 */
public void setDescrizione(String newDescrizione)
{
    this.descrizione = newDescrizione;
}

/**
 * Returns the punto vendita (store) associated with the recensione
 * 
 * @return the punto vendita associated with the recensione
 */
public PuntoVendita getPuntoVendita()
{
    return this.puntoVendita;
}

/**
 * Sets the punto vendita (store) associated with the recensione to the specified value
 * 
 * @param newPuntoVendita the new punto vendita associated with the recensione
 */
public void setPuntoVendita(PuntoVendita newPuntoVendita)
{
    this.puntoVendita = newPuntoVendita;
}

/**
 * Returns the client associated with the recensione
 * 
 * @return the client associated with the recensione
 */
public Client getCliente()
{
    return this.cliente;
}

/**
 * Sets the client associated with the recensione to the specified value
 * 
 * @param newCliente the new client associated with the recensione
 */
public void setCliente(Client newCliente)
{
    this.cliente=newCliente;
}



}
