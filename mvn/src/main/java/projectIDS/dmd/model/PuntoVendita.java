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

    public int getId(){
        return this.id;
    }

    public String getNomePuntoVendita()
    {
        return this.nomePuntoVendita;
    }

    public void setNomePuntoVendita(String nome)
    {
        this.nomePuntoVendita = nome;
    }

    public String getLocalita()
    {
        return this.localita;
    }

    public void setLocalita(String newLocalita)
    {
        this.localita = newLocalita;
    }

    public Azienda getAzienda() {
        return this.azienda;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }


    
}
