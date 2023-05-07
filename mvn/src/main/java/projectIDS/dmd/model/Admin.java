package projectIDS.dmd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;

    private String nome;

    private String cognome;

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

    // public PuntoVendita getPuntoVendita()
    // {
    //     return this.puntoVendita;
    // }

    // public void setPuntoVendita(PuntoVendita newPuntoVendita)
    // {
    //     this.puntoVendita=newPuntoVendita;
    // }


    
}
