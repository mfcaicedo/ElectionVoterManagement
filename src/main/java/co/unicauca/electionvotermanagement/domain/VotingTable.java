package co.unicauca.electionvotermanagement.domain;

/**
 *
 * @author mfcaicedo, danielerazo
 */
public class VotingTable {
    /**
     * Atributos
     */
    private String idTable;
    private int VotingCapacity;
    /**
    * Constructor 
    */
    public VotingTable(String idTable, int VotingCapacity) {
        this.idTable = idTable;
        this.VotingCapacity = VotingCapacity;
    }
    /**
    * Getters and setters 
    */
    public String getIdTable() {
        return idTable;
    }

    public void setIdTable(String idTable) {
        this.idTable = idTable;
    }

    public int getVotingCapacity() {
        return VotingCapacity;
    }

    public void setVotingCapacity(int VotingCapacity) {
        this.VotingCapacity = VotingCapacity;
    }

}
