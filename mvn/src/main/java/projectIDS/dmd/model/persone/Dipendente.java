package projectIDS.dmd.model.persone;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import projectIDS.dmd.model.puntovenditautilities.PuntoVendita;

@Entity
@Table (name ="Dipendenti")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;
    private LocalDate dataInizioContratto;
    private LocalDate dataFineContratto;
    private String numeroTelefonico;
    private String username;
    private String password;
    private String email;

    @ManyToOne
    @JoinColumn(name="puntoVendita_id")
    private PuntoVendita puntoVendita;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin admin;



    public int getId() {
        return id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }
    

    
}

