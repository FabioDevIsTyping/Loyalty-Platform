package projectIDS.dmd.model;


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


@Entity
@Table (name="puntovendita")
public class PuntoVendita {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String localita;
private String nomePuntoVendita;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "azienda_id")
@OnDelete(action = OnDeleteAction.CASCADE)
public Azienda azienda;

/**
 * Returns the unique identifier of this PuntoVendita.
 *
 * @return the identifier of this PuntoVendita
 */
public int getId(){
    return this.id;
}

/**
 * Returns the name of this PuntoVendita.
 *
 * @return the name of this PuntoVendita
 */
public String getNomePuntoVendita()
{
    return this.nomePuntoVendita;
}

/**
 * Sets the name of this PuntoVendita to the given String.
 *
 * @param nome the new name of this PuntoVendita
 */
public void setNomePuntoVendita(String nome)
{
    this.nomePuntoVendita = nome;
}

/**
 * Returns the location of this PuntoVendita.
 *
 * @return the location of this PuntoVendita
 */
public String getLocalita()
{
    return this.localita;
}

/**
 * Sets the location of this PuntoVendita to the given String.
 *
 * @param newLocalita the new location of this PuntoVendita
 */
public void setLocalita(String newLocalita)
{
    this.localita = newLocalita;
}

/**
 * Returns the Azienda associated with this PuntoVendita.
 *
 * @return the Azienda associated with this PuntoVendita
 */
public Azienda getAzienda() {
    return this.azienda;
}

/**
 * Sets the Azienda associated with this PuntoVendita to the given Azienda object.
 *
 * @param azienda the new Azienda associated with this PuntoVendita
 */
public void setAzienda(Azienda azienda) {
    this.azienda = azienda;
}



    
}
