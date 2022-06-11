
package co.unicauca.electionvotermanagement.domain;

import java.util.ArrayList;

/**
 *
 * @author mfcaicedo, danielerazo 
 */
public class VotingPlace {
    /**
     * Atriubtos
     */
    private String namePlace; 
    private String addressPlace; 
    private int numTables; 
    private ArrayList<VotingTable> lstTables; 

    /**
    * Constructor 
    */
    public VotingPlace(String namePlace, String addressPlace, int numTables) {
        this.namePlace = namePlace;
        this.addressPlace = addressPlace;
        this.numTables = numTables;
        this.lstTables = new ArrayList<>();
    }

    /**
    * Getters and setters 
    */
    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public String getAddressPlace() {
        return addressPlace;
    }

    public void setAddressPlace(String addressPlace) {
        this.addressPlace = addressPlace;
    }

    public int getNumTables() {
        return numTables;
    }

    public void setNumTables(int numTables) {
        this.numTables = numTables;
    }
    
    public void addVotingTable(int idTable, int voterCapacity){
        VotingTable table = new VotingTable(idTable, voterCapacity);
        if (table != null) {
            lstTables.add(table);
        }else{
            System.out.println("Error");
        }
       
        
    }
 
    
}

