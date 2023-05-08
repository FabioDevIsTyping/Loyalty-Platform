package projectIDS.dmd.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cognome;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "puntoVendita_id", referencedColumnName = "id")
    private PuntoVendita puntoVendita;


    //private PuntoVendita puntoVendita;


    public int getId()
    {
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String name){
        this.nome=name;

    }

    public String getCognome(){
        return this.cognome;
    }

    public void setCognome(String newCognome){
        this.cognome=newCognome;
    }

     public PuntoVendita getPuntoVendita()
     {
        return this.puntoVendita;
    }

    public void setPuntoVendita(PuntoVendita newPuntoVendita)
    {
        this.puntoVendita=newPuntoVendita;
    }


    
}
