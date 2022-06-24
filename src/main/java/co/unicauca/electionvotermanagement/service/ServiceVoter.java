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
     * Fchada del método -> Busqudda de lugar de votación 
     * @param identifier identificación de la persona (votante). 
     * @return  cadena con el resultado de la consulta. 
     */
    public String searchVotingPlace(int identifier) throws SQLException{
        return objRepo.searchVotingPlace(identifier);
    }
    
}
