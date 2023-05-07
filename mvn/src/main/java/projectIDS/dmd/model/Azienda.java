package projectIDS.dmd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "azienda")
public class Azienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nomeAzienda;
    private String localitaAzienda;

    public int getId()
    {
        return this.id;
    }

    public String getNomeAzienda()
    {
        return this.nomeAzienda;
    }

    public void setNomeAzienda(String newNomeAzienda)
    {
        this.nomeAzienda = newNomeAzienda;
    }

    public String getLocalitaAzienda()
    {
        return this.localitaAzienda;
    }

    public void setLocalitaAzienda(String newLocalita)
    {
        this.localitaAzienda = newLocalita;
    }


    
}
