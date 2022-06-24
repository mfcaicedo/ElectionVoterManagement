package co.unicauca.electionvotermanagement.domain;

/**
 *
 * @author mfcaicedo, danielerazo
 */
public abstract class Person {
    /**
     * Atributos 
     */
    private int identifier; 
    private String name; 
    private String lastName; 
    
    /**
     * Constructor 
     */
    public Person(int identifier, String name, String lastName) {
        this.identifier = identifier;
        this.name = name;
        this.lastName = lastName;
    }
    /**
     * Constructor vacío 
     */
    public Person(){
        
    }
    /**
    * Getters and setters 
    */
    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
  
}
