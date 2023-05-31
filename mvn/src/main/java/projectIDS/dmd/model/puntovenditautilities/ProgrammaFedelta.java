package projectIDS.dmd.model.puntovenditautilities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Rappresenta un programma fedeltà nel sistema.
 *
 * La classe rappresenta un programma fedeltà con le sue informazioni di base, come l'ID (chiave primaria)
 * e il nome del programma.
 * 
 * L'identificatore unico per un programma fedeltà è l'id, che viene generato
 * automaticamente attraverso una strategia di generazione.
 * 
 * La classe è annotata con @Entity per indicare che è una classe persistente e
 * può essere salvata nel database. La tabella associata a questa classe nel 
 * database è denominata "programmaFedelta" e viene specificato utilizzando 
 * l'annotazione @Table.
 */
@Entity
@Table(name = "programmaFedelta")
public class ProgrammaFedelta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nomeProgramma;

    


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


}

