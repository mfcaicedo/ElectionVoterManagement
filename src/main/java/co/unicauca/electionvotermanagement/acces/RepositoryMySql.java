package co.unicauca.electionvotermanagement.acces;

import co.unicauca.electionvotermanagement.domain.Voter;
import co.unicauca.electionvotermanagement.domain.VotingPlace;
import co.unicauca.electionvotermanagement.domain.VotingTable;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mfcaicedo, danieleraso 
 */
public class RepositoryMySql {
    
    ConnectDB connect = new ConnectDB();
    
     
    public RepositoryMySql(){
        
    } 
    
    public Connection conexion(){
        Connection con  = null;
        try {
            con = connect.getConexion();
            //System.out.println("Conection version 6");
        } catch (Exception e) {
            System.out.println("Error: "+ e);
        }
        return con;
    }
    public int addVotingPlace(VotingPlace place){
        
        Connection con  = null;
        PreparedStatement stmt;
        String sql;
        
        try {
            con = connect.getConexion();
            sql = "INSERT INTO VotingPlace (namePlace, directionPlace, numTables) VALUES (?,?,?);";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, place.getNamePlace());
            stmt.setString(2, place.getAddressPlace());
            stmt.setInt(3, place.getNumTables());
            int i = stmt.executeUpdate();
            if (i == 1) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error en la inserción ");
            System.out.println(e);
        }
        return 0; 
        
    }
    public int addVotingTable(VotingTable table, int idVotingPlace) throws SQLException{
        
        Connection con  = null;
        PreparedStatement stmt;
        String sql;
        
        try {
            con = connect.getConexion();
            sql = "INSERT INTO VotingTable (nameTable, voterCapacity, votingPlace_nitPlace) VALUES (?,?,?);";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, table.getIdTable());
            stmt.setInt(2, table.getVotingCapacity());
            stmt.setInt(3, idVotingPlace);
            int i = stmt.executeUpdate();
            if (i == 1) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error en la inserción ");
            System.out.println(e);
        }finally{
            con.close();
        }
        
        return 0; 
        
    }
    public int addVoter(Voter voter) throws SQLException{
        
        Connection con  = null;
        PreparedStatement stmt;
        String sql;
        
        try {
            con = connect.getConexion();
            sql = "INSERT INTO Voter (identifierVoter, nameVoter, lastNameVoter, addressVoter) VALUES (?,?,?,?);";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, voter.getIdentifier());
            stmt.setString(2, voter.getName());
            stmt.setString(3, voter.getLastName());
            stmt.setString(4, voter.getAddress());
            int i = stmt.executeUpdate();
            if (i == 1) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error en la inserción ");
            System.out.println(e);
        }finally{
            con.close();
        }
        
        return 0; 
        
    }
    public int addVotingTableVoter(int identifierVoter, int  idTable) throws SQLException{
        Connection con  = null;
        PreparedStatement stmt;
        String sql;
        
        try {
            con = connect.getConexion();
            sql = "INSERT INTO VotingTableVoter (Voter_identifier,TableVoting_idTable) VALUES (?,?);";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, identifierVoter);
            stmt.setInt(2, idTable);
            int i = stmt.executeUpdate();
            if (i == 1) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error en la inserción ");
            System.out.println(e);
        }finally{
            con.close();
        }
        return 0; 
    }
    
    public int getNitLastVotingPlace() throws SQLException{
        Connection con  = null;
        PreparedStatement stmt;
        String sql;
        ResultSet result;
        int nitPlace = 0;
        
        try {
            con = connect.getConexion();
            sql = "SELECT nitPlace FROM VotingPlace ORDER BY nitPlace DESC LIMIT 1;";
            stmt = con.prepareStatement(sql);
            result = stmt.executeQuery(sql);
            
            if(result.next()) { 
                nitPlace = result.getInt("nitPlace"); 
            }
            System.out.println("nitPlace: "+ nitPlace);
            return nitPlace;
           
        } catch (SQLException e) {
            System.out.println("Error en la consulta ");
            System.out.println(e);
        }finally{
            con.close();
        }
        return nitPlace;
    }
    public ArrayList<VotingPlace> getVotingPlace() throws SQLException{
        Connection con  = null;
        PreparedStatement stmt;
        String sql;
        ResultSet result;
        ArrayList<VotingPlace> auxListVotingPlaces = new ArrayList<>();
        VotingPlace objVotinPlace = null;
        try {
            con = connect.getConexion();
            sql = "SELECT * FROM VotingPlace ORDER BY namePlace ASC;";
            stmt = con.prepareStatement(sql);
            result = stmt.executeQuery(sql);
            
            if(result.next()) { 
                do{
                    objVotinPlace = new VotingPlace(result.getInt("nitPlace"), result.getString("namePlace"),
                            result.getString("directionPlace"), result.getInt("numTables"));         
                    auxListVotingPlaces.add(objVotinPlace);
                }while(result.next());
            }
            return auxListVotingPlaces;
           
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            System.out.println(e);
        }finally{
            con.close();
        }
        return auxListVotingPlaces;
    }
    /**
     * Consulta del lugar de votación de una persona
     * @param identifier
     * @return
     * @throws SQLException 
     */
    public String searchVotingPlace(int identifier) throws SQLException{
        
        Connection con  = null;
        PreparedStatement stmt;
        String sql;
        ResultSet result;
        String respuesta = "";
        try {
            con = connect.getConexion();
            sql = "SELECT identifierVoter, nameVoter, directionPlace, idTable FROM Voter \n" +
                    "INNER JOIN votingtablevoter ON voter.identifierVoter = votingtablevoter.Voter_identifier\n" +
                    "INNER JOIN VotingTable ON VotingTable.idTable = votingtablevoter.TableVoting_idTable\n" +
                    "INNER JOIN votingPlace ON votingplace.nitPlace = votingtable.VotingPlace_nitPlace\n" +
                    "WHERE Voter.identifierVoter ="+ String.valueOf(identifier);
            stmt = con.prepareStatement(sql);
            
            result = stmt.executeQuery(sql);
            
            if(result.next()) { 
                respuesta = result.getInt("identifierVoter") + "/" + result.getString("nameVoter") + 
                        "/" + result.getString("directionPlace") + "/" + result.getInt("idTable");
            }         
            return respuesta;
           
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            System.out.println(e);
        }finally{
            con.close();
        }
        
        
        return respuesta;
    }
    
}
