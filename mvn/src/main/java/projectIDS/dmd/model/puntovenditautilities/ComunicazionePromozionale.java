package projectIDS.dmd.model.puntovenditautilities;



import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import projectIDS.dmd.model.persone.Client;

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

    @ManyToMany
    private List<Client> clientiDestinatari;

    private LocalDateTime orarioDiInvio;

/**
 * Restituisce l'ID di questa comunicazione promozionale.
 *
 * @return l'ID di questa comunicazione promozionale.
 */
public int getId() {
    return this.id;
}

/**
 * Restituisce il messaggio della comunicazione promozionale.
 *
 * @return il messaggio della comunicazione promozionale.
 */
public String getMessaggio() {
    return this.messaggio;
}

/**
 * Imposta il messaggio della comunicazione promozionale.
 *
 * @param messaggio il nuovo messaggio della comunicazione promozionale.
 */
public void setMessaggio(String messaggio) {
    this.messaggio = messaggio;
}

/**
 * Restituisce la lista dei clienti destinatari della comunicazione promozionale.
 *
 * @return la lista dei clienti destinatari della comunicazione promozionale.
 */
public List<Client> getClientiDestinatari() {
    return this.clientiDestinatari;
}

/**
 * Imposta la lista dei clienti destinatari della comunicazione promozionale.
 *
 * @param clientiDestinatari la nuova lista dei clienti destinatari della comunicazione promozionale.
 */
public void setClientiDestinatari(List<Client> clientiDestinatari) {
    this.clientiDestinatari = clientiDestinatari;
}

/**
 * Restituisce il punto vendita mittente della comunicazione promozionale.
 *
 * @return il punto vendita mittente della comunicazione promozionale.
 */
public PuntoVendita getPuntoVendita() {
    return this.puntoVenditaMittente;
}

/**
 * Imposta il punto vendita mittente della comunicazione promozionale.
 *
 * @param puntoVendita il nuovo punto vendita mittente della comunicazione promozionale.
 */
public void setPuntoVendita(PuntoVendita puntoVendita) {
    this.puntoVenditaMittente = puntoVendita;
}

/**
 * Restituisce il tipo di comunicazione promozionale.
 *
 * @return il tipo di comunicazione promozionale.
 */
public TipoComunicazionePromozionale getTipoComunicazionePromozionale() {
    return this.tipoComunicazionePromozionale;
}

/**
 * Imposta il tipo di comunicazione promozionale.
 *
 * @param tipoComunicazionePromozionale il nuovo tipo di comunicazione promozionale.
 */
public void setTipoComunicazionePromozionale(TipoComunicazionePromozionale tipoComunicazionePromozionale) {
    this.tipoComunicazionePromozionale = tipoComunicazionePromozionale;
}

/**
 * Restituisce l'orario di invio della comunicazione promozionale.
 *
 * @return l'orario di invio della comunicazione promozionale.
 */
public LocalDateTime getOrarioDiInvio() {
    return this.orarioDiInvio;
}

/**
 * Imposta l'orario di invio della comunicazione promozionale.
 *
 * @param orarioDiInvio il nuovo orario di invio della comunicazione promozionale.
 */
public void setOrarioDiInvio(LocalDateTime orarioDiInvio) {
    this.orarioDiInvio = orarioDiInvio;
}


    

    
}
