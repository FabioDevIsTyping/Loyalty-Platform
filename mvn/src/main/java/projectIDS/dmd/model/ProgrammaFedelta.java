package projectIDS.dmd.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "programmaFedelta")
public class ProgrammaFedelta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeProgramma;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "puntoVendita_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    public PuntoVendita puntoVendita;

    /**
     * Returns the unique identifier of this ProgrammaFedelta object.
     *
     * @return the identifier of this ProgrammaFedelta object
     */
    public int getId() {
        return this.id;
    }

    /**
     * Returns the name of this ProgrammaFedelta object.
     *
     * @return the name of this ProgrammaFedelta object
     */
    public String getNomeProgramma() {
        return this.nomeProgramma;
    }

    /**
     * Sets the name of this ProgrammaFedelta object to the given String.
     *
     * @param newNome the new name to be set
     */
    public void setNomeProgramma(String newNome) {
        this.nomeProgramma = newNome;
    }

    /**
     * Returns the PuntoVendita associated with this ProgrammaFedelta object.
     *
     * @return the PuntoVendita associated with this ProgrammaFedelta object
     */
    public PuntoVendita getPuntoVendita() {
        return this.puntoVendita;
    }

    /**
     * Sets the PuntoVendita associated with this ProgrammaFedelta object to the given PuntoVendita object.
     *
     * @param newPuntoVendita the new PuntoVendita to be associated with this ProgrammaFedelta object
     */
    public void setPuntoVendita(PuntoVendita newPuntoVendita) {
        this.puntoVendita = newPuntoVendita;
    }
}

