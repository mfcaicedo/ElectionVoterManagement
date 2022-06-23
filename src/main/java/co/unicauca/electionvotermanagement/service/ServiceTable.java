/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.electionvotermanagement.service;

import co.unicauca.electionvotermanagement.acces.RepositoryMySql;
import co.unicauca.electionvotermanagement.domain.Voter;
import java.sql.SQLException;

/**
 *
 * @author mfcaicedo, danieleraso 
 */
public class ServiceTable {
    RepositoryMySql objRepo;
    /**
    * Constructor
    */
    public ServiceTable(){
        this.objRepo = new RepositoryMySql();
    }
    
    public int addVoter(Voter objVoter) throws SQLException{
        return objRepo.addVoter(objVoter);
    }   
    public int addVotingTableVoter(int identifierVoter, int idTable) throws SQLException{
        return objRepo.addVotingTableVoter(identifierVoter, idTable);
    }
}
