package projectIDS.dmd.model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="Dipendente")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;

    private String cognome;

    private LocalDate dataInizioContratto;

    private LocalDate dataFineContratto;

    @ManyToOne
    @JoinColumn(name = "puntoVendita_id")
    private PuntoVendita puntoVendita;

    public int getId() {
        return this.id;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataInizioContratto() {
        return dataInizioContratto;
    }

    public void setDataInizioContratto(LocalDate dataInizioContratto) {
        this.dataInizioContratto = dataInizioContratto;
    }

    public LocalDate getDataFineContratto() {
        return dataFineContratto;
    }

    public void setDataFineContratto(LocalDate dataFineContratto) {
        this.dataFineContratto = dataFineContratto;
    }

    public PuntoVendita getPuntoVendita() {
        return puntoVendita;
    }

    public void setPuntoVendita(PuntoVendita puntoVendita) {
        this.puntoVendita = puntoVendita;
    }

    

    
}
