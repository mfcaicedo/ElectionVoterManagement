
package co.unicauca.electionvotermanagement.domain;

/**
 *
 * @author mfcaicedo,danielerazo 
 */
public class Voter extends Person {
    /**
     * Atributos 
     */
    private String address;

    /**
     * Contructor 
     */
    public Voter(int identifier, String name, String lastName,String address) {
        super(identifier, name, lastName);
        this.address = address;
    }
    /**
    * Gtters and sertters 
    */
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
  
}
