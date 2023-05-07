package projectIDS.dmd.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table (name="punti vendita")
public class PuntoVendita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String localita;
    private String nomePuntoVendita;
    private Azienda aziendaDiAppartenenza;

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

    public Azienda getAziendaDiAppartenenza()
    {
        return this.aziendaDiAppartenenza;
    }

    public void setAziendaDiAppartenenza(Azienda newAzienda)
    {
        this.aziendaDiAppartenenza = newAzienda;

    }

    
}
