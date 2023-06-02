package projectIDS.dmd.model.puntovenditautilities;


import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import projectIDS.dmd.model.clienteutilities.CartaFedelta;
import projectIDS.dmd.model.persone.Admin;
import projectIDS.dmd.model.persone.Client;
import projectIDS.dmd.model.persone.Dipendente;

/**
 * Rappresenta un punto vendita nel sistema.
 *
 * 
 * 
 * La classe rappresenta un punto vendita con le sue informazioni di base, come l'ID (chiave primaria),
 * la località e il nome del punto vendita. Un punto vendita può essere associato a un'azienda tramite
 * una relazione many-to-one, a un programma fedeltà tramite una relazione many-to-one e a una lista di
 * carte fedeltà tramite una relazione one-to-many. Inoltre, è possibile avere una relazione many-to-many
 * con la classe `Client`, rappresentando i clienti associati al punto vendita.
 * 
 * L'identificatore unico per un punto vendita è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "puntovendita" e viene specificato utilizzando 
 * l'annotazione @Table.
 */
@Entity
@Table (name="puntovendita")
public class PuntoVendita {
    
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String localita;
private String nomePuntoVendita;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "azienda_id")
@OnDelete(action = OnDeleteAction.CASCADE)
public Azienda azienda;

@ManyToMany
private List<ProgrammaFedelta> programmaFedelta;

@OneToMany(mappedBy = "puntoVendita")
@JsonIgnore
private List<CartaFedelta> carteFedelta;


@ManyToMany(mappedBy = "puntiVendita")
@JsonIgnore
private List<Client> clienti;

@OneToOne(mappedBy = "puntoVendita", cascade = CascadeType.MERGE)
@JsonIgnore
private Admin admin;

@OneToMany
@JsonIgnore
private List<Dipendente> listaDipendenti;


/**
 * Restituisce l'identificatore univoco di questo PuntoVendita.
 *
 * @return l'identificatore di questo PuntoVendita
 */
public int getId() {
    return this.id;
}

/**
 * Restituisce il nome di questo PuntoVendita.
 *
 * @return il nome di questo PuntoVendita
 */
public String getNomePuntoVendita() {
    return this.nomePuntoVendita;
}

/**
 * Imposta il nome di questo PuntoVendita con la stringa fornita.
 *
 * @param nome il nuovo nome di questo PuntoVendita
 */
public void setNomePuntoVendita(String nome) {
    this.nomePuntoVendita = nome;
}

/**
 * Restituisce la località di questo PuntoVendita.
 *
 * @return la località di questo PuntoVendita
 */
public String getLocalita() {
    return this.localita;
}

/**
 * Imposta la località di questo PuntoVendita con la stringa fornita.
 *
 * @param newLocalita la nuova località di questo PuntoVendita
 */
public void setLocalita(String newLocalita) {
    this.localita = newLocalita;
}

/**
 * Restituisce l'Azienda associata a questo PuntoVendita.
 *
 * @return l'Azienda associata a questo PuntoVendita
 */
public Azienda getAzienda() {
    return this.azienda;
}

/**
 * Imposta l'Azienda associata a questo PuntoVendita con l'oggetto Azienda fornito.
 *
 * @param azienda la nuova Azienda associata a questo PuntoVendita
 */
public void setAzienda(Azienda azienda) {
    this.azienda = azienda;
}

/**
 * Restituisce la lista dei clienti associati a questo PuntoVendita.
 *
 * @return la lista dei clienti associati a questo PuntoVendita
 */
public List<Client> getClienti() {
    return clienti;
}

/**
 * Imposta la lista dei clienti associati a questo PuntoVendita.
 *
 * @param clienti la nuova lista dei clienti associati a questo PuntoVendita
 */
public void setClienti(List<Client> clienti) {
    this.clienti = clienti;
}

/**
 * Restituisce la lista delle CarteFedelta associate a questo PuntoVendita.
 *
 * @return la lista delle CarteFedelta associate a questo PuntoVendita
 */
public List<CartaFedelta> getCarteFedelta() {
    return carteFedelta;
}

/**
 * Imposta la lista delle CarteFedelta associate a questo PuntoVendita.
 *
 * @param carteFedelta la nuova lista delle CarteFedelta associate a questo PuntoVendita
 */
public void setCarteFedelta(List<CartaFedelta> carteFedelta) {
    this.carteFedelta = carteFedelta;
}

/**
 * Restituisce il ProgrammaFedelta associato a questo PuntoVendita.
 *
 * @return il ProgrammaFedelta associato a questo PuntoVendita
 */
public List<ProgrammaFedelta> getProgrammaFedelta() {
    return programmaFedelta;
}

/**
 * Imposta il ProgrammaFedelta associato a questo PuntoVendita.
 *
 * @param programmaFedelta il nuovo ProgrammaFedelta associato a questo PuntoVendita
 */
public void setProgrammaFedelta(List<ProgrammaFedelta> programmaFedelta) {
    this.programmaFedelta = programmaFedelta;
}

public Admin getAdmin() {
    return admin;
}

public void setAdmin(Admin admin) {
    this.admin = admin;
}

public List<Dipendente> getListaDipendenti() {
    return listaDipendenti;
}

public void setListaDipendenti(List<Dipendente> listaDipendenti) {
    this.listaDipendenti = listaDipendenti;
}


    
}
