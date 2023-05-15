package projectIDS.dmd.model;
import java.time.LocalDate;


public class Person {

    
    private LocalDate birthdate;
    private String taxIdCode;
    private String residence;


    // Getters and Setters for all properties

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getTaxIdCode() {
        return taxIdCode;
    }

    public void setTaxIdCode(String taxIdCode) {
        this.taxIdCode = taxIdCode;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    
}
