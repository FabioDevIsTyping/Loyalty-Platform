package projectIDS.dmd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tipi comunicazioni promozionali")
public class TipoComunicazionePromozionale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeComunicazione;


    public int getId() {
        return id;
    }
    
    public String getNomeComunicazione() {
        return nomeComunicazione;
    }

    public void setNomeComunicazione(String nomeComunicazione) {
        this.nomeComunicazione = nomeComunicazione;
    }


   
    
}
