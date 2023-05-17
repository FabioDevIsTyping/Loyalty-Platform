package projectIDS.dmd.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "messaggio")
public class Messaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    private String messaggio;

    private Admin adminMittente;

    private PuntoVendita puntoVenditaMittente;

    private List<Client> clientiDestinatari;

    public int getId() {
        return id;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public Admin getAdminMittente() {
        return adminMittente;
    }

    public void setAdminMittente(Admin adminMittente) {
        this.adminMittente = adminMittente;
    }

    public PuntoVendita getPuntoVenditaMittente() {
        return puntoVenditaMittente;
    }

    public void setPuntoVenditaMittente(PuntoVendita puntoVenditaMittente) {
        this.puntoVenditaMittente = puntoVenditaMittente;
    }

    public List<Client> getClientiDestinatari() {
        return clientiDestinatari;
    }

    public void setClientiDestinatari(List<Client> clientiDestinatari) {
        this.clientiDestinatari = clientiDestinatari;
    }

    

    
}
