
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
    private int nitPlace;
    private String namePlace; 
    private String addressPlace; 
    private int numTables; 
    private ArrayList<VotingTable> lstTables; 

    /**
    * Constructor vacío 
    */
    public VotingPlace(){
        
    }
    /**
     *Constructor parametrizado 
     */
    public VotingPlace(String namePlace, String addressPlace, int numTables) {
        this.namePlace = namePlace;
        this.addressPlace = addressPlace;
        this.numTables = numTables;
        this.lstTables = new ArrayList<>();
    }
    /**
     *Constructor parametrizado pasando tambien el nit (necesario para algunas consultas)
     */
    public VotingPlace(int nitPlace, String namePlace, String addressPlace, int numTables) {
        this.nitPlace = nitPlace;
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
        public ArrayList<VotingTable> getLstTables() {
        return lstTables;
    }

    public void setLstTables(ArrayList<VotingTable> lstTables) {
        this.lstTables = lstTables;
    }

    public int getNitPlace() {
        return nitPlace;
    }

    public void setNitPlace(int nitPlace) {
        this.nitPlace = nitPlace;
    }
    
    /**
     * Agrega las mesas de un lugar de votación 
     * @param idTable id de la mesa
     * @param voterCapacity  capacidad de la mesa   
     */
    public void addVotingTable(String idTable, int voterCapacity){
        VotingTable table = new VotingTable(idTable, voterCapacity);
        if (table != null) {
            lstTables.add(table);
        }else{
            System.out.println("Error");
        }   
    }
}

