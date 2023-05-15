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
@Table (name = "Titolari azienda")
public class TitolareAzienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "azienda_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Azienda azienda;

    public int getId()
    {
        return this.id;
    }

    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String newNome)
    {
        this.nome = newNome;
    }

    public String getCognome()
    {
        return this.cognome;
    }

    public void setCognome(String newCognome)
    {
        this.cognome = newCognome;
    }

    public Azienda getAzienda()
    {
        return this.azienda;
    }

    public void setAzienda(Azienda newAzienda)
    {
        this.azienda = newAzienda;
    }

}
