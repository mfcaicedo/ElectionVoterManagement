package co.unicauca.electionvotermanagement.service;

import co.unicauca.electionvotermanagement.acces.RepositoryMySql;
import co.unicauca.electionvotermanagement.domain.VotingPlace;
import co.unicauca.electionvotermanagement.domain.VotingTable;
import java.sql.SQLException;

/**
 *
 * @author mfcaicedo, danieleraso 
 */
public class ServiceVotingPlace {
    
    RepositoryMySql objRepo;
    
    /**
     * Constructor 
     */
    public ServiceVotingPlace(){
        this.objRepo = new RepositoryMySql();
    }
    public int addVotingPlace(VotingPlace place){
        //llamamos al meotod para que guarda en la base de datos 
        return objRepo.addVotingPlace(place);
        
    }
    public int addVotingTable(VotingTable table) throws SQLException{
        int nitPlace = objRepo.getNitLastVotingPlace();
        return objRepo.addVotingTable(table, nitPlace);
    }
}
