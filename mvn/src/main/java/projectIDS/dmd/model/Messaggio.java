package projectIDS.dmd.model;



import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "messaggio")
public class Messaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(nullable=false)
    private String messaggio;

    @ManyToOne
    @JoinColumn(name="admin_id", nullable = false)
    private Admin adminMittente;

    @ElementCollection
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


    public List<Client> getClientiDestinatari() {
        return clientiDestinatari;
    }

    public void setClientiDestinatari(List<Client> clientiDestinatari) {
        this.clientiDestinatari = clientiDestinatari;
    }

    

    
}
