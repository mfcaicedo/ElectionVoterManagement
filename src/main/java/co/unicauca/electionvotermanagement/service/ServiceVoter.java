package co.unicauca.electionvotermanagement.service;

import co.unicauca.electionvotermanagement.acces.RepositoryMySql;
import java.sql.SQLException;

/**
 *
 * @author mfcaicedo, danieleraso 
 */
public class ServiceVoter {
    RepositoryMySql objRepo;
    /**
     * Constructor 
     */
    public ServiceVoter(){
        this.objRepo = new RepositoryMySql();
    }
    /**
     * Busqudda de lugar de votación 
     * @param identifier 
     */
    public String searchVotingPlace(int identifier) throws SQLException{
        return objRepo.searchVotingPlace(identifier);
    }
    
}
