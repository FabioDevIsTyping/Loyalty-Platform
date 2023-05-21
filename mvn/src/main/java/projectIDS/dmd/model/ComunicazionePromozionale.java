package projectIDS.dmd.model;



import java.time.LocalDateTime;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comunicazioni Promozionali")
public class ComunicazionePromozionale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(nullable=false)
    private String messaggio;

    @ManyToOne
    @JoinColumn(name="puntoVendita_id", nullable = false)
    private PuntoVendita puntoVenditaMittente;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "TipoComunicazionePromozionale_id")
    private TipoComunicazionePromozionale tipoComunicazionePromozionale;

    @ElementCollection
    private List<Client> clientiDestinatari;

    private LocalDateTime orarioDiInvio;

    public int getId() {
        return id;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public void setMessaggio(String messaggio) {
        this.messaggio = messaggio;
    }

    public List<Client> getClientiDestinatari() {
        return clientiDestinatari;
    }

    public void setClientiDestinatari(List<Client> clientiDestinatari) {
        this.clientiDestinatari = clientiDestinatari;
    }

    public PuntoVendita getPuntoVendita() {
        return puntoVenditaMittente;
    }

    public void setPuntoVendita(PuntoVendita puntoVendita) {
        this.puntoVenditaMittente = puntoVendita;
    }

    public TipoComunicazionePromozionale getTipoComunicazionePromozionale() {
        return tipoComunicazionePromozionale;
    }

    public void setTipoComunicazionePromozionale(TipoComunicazionePromozionale tipoComunicazionePromozionale) {
        this.tipoComunicazionePromozionale = tipoComunicazionePromozionale;
    }

    public LocalDateTime getOrarioDiInvio() {
        return orarioDiInvio;
    }

    public void setOrarioDiInvio(LocalDateTime orarioDiInvio) {
        this.orarioDiInvio = orarioDiInvio;
    }

    

    
}
