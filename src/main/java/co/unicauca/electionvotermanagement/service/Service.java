package co.unicauca.electionvotermanagement.service;

import co.unicauca.electionvotermanagement.acces.RepositoryMySql;
import co.unicauca.electionvotermanagement.domain.VotingPlace;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mfcaicedo, daniel eraso
 */
public class Service {
    
    ArrayList<VotingPlace> lstVotingPlace;
    /**
     * Constructor 
     */
    public Service(){
        lstVotingPlace = new ArrayList<>();
    }
    
    public ArrayList<VotingPlace> loadVotingPlace() throws SQLException{
        
        RepositoryMySql objRepo = new RepositoryMySql();
        lstVotingPlace = objRepo.getVotingPlace();
        return lstVotingPlace;
    }
}
