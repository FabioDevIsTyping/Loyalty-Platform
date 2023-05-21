package projectIDS.dmd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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

