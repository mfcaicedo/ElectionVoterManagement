/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
