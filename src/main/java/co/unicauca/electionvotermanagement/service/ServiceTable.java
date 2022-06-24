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
    /**
    * Fachada de la función para agregar un votante.
    * @param objVoter objeto que tiene los valores del votante 
    * @return 1 si la inserción es correcta 0 en caso contrario 
    * @throws SQLException manejo de excepciones 
    */
    public int addVoter(Voter objVoter) throws SQLException{
        return objRepo.addVoter(objVoter);
    } 
    /**
     * Fachada de la función -> Agrega a la tabla auxiliar llamada VotingTableVoter (Mesa_votacion_Votante)
     * @param identifierVoter identificación del votante
     * @param idTable id de la mesa 
     * @return 1 si es correcta la inserción 0 en caso contrario. 
     * @throws SQLException manejo de excepciones 
     */
    public int addVotingTableVoter(int identifierVoter, int idTable) throws SQLException{
        return objRepo.addVotingTableVoter(identifierVoter, idTable);
    }
    /**
    * Fchada de la función -> obtener el id de la mesa 
    * @param nameTable nombre de la mesa 
    * @return id de la mesa correspondiente al nombre.
    * @throws SQLException manejo de excepciones 
    */
    public int getIdTable(String nameTable) throws SQLException{
        return objRepo.getIdTable(nameTable);
    }
}
