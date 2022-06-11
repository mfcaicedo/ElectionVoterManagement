package co.unicauca.electionvotermanagement.domain;

/**
 *
 * @author mfcaicedo, danielerazo
 */
public class VotingTable {
    /**
     * Atributos
     */
    private int idTable;
    private int VotingCapacity;
    /**
    * Constructor 
    */
    public VotingTable(int idTable, int VotingCapacity) {
        this.idTable = idTable;
        this.VotingCapacity = VotingCapacity;
    }
    /**
    * Getters and setters 
    */
    public int getIdTable() {
        return idTable;
    }

    public void setIdTable(int idTable) {
        this.idTable = idTable;
    }

    public int getVotingCapacity() {
        return VotingCapacity;
    }

    public void setVotingCapacity(int VotingCapacity) {
        this.VotingCapacity = VotingCapacity;
    }

}
