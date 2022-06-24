package co.unicauca.electionvotermanagement.service;

import co.unicauca.electionvotermanagement.acces.RepositoryMySql;
import co.unicauca.electionvotermanagement.domain.VotingPlace;
import co.unicauca.electionvotermanagement.domain.VotingTable;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mfcaicedo, danieleraso 
 */
public class ServiceVotingPlace {
    
    RepositoryMySql objRepo;
    ArrayList<VotingPlace> lstVotingPlace;
    
    /**
     * Constructor 
     */
    public ServiceVotingPlace(){
        this.objRepo = new RepositoryMySql();
        lstVotingPlace = new ArrayList<>();
    }
    /**
    * Fachada del método -> Agrega un lugar de votación 
    * @param place objeto tipo VotingPlace que tiene todos los parámetros de el lugar 
    * @return 1 si es correcto o 0 si es incorrecta la inserción 
    */
    public int addVotingPlace(VotingPlace place) throws SQLException{
        return objRepo.addVotingPlace(place);
    }
    /**
    * fachada del método -> Agrega una mesa de votación. 
    * @param table objeto con los valores de la mesa. 
    * @param idVotingPlace id del lugar al cual se le asociará la mesa (FOREIGN KEY)
    * @return 1 si la inserción es correcta 0 en caso contrario. 
    * @throws SQLException Manejo de errores de SQL 
    */
    public int addVotingTable(VotingTable table) throws SQLException{
        int nitPlace = objRepo.getNitLastVotingPlace();
        return objRepo.addVotingTable(table, nitPlace);
    }
    /**
    * carga el lugar de votación 
    * @return arreglo de lugares de votación 
    * @throws SQLException manejo de excepciones 
    */
    public ArrayList<VotingPlace> loadVotingPlace() throws SQLException{
        RepositoryMySql objRepo = new RepositoryMySql();
        lstVotingPlace = objRepo.getVotingPlace();
        return lstVotingPlace;
    }
}
