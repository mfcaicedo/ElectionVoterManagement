package co.unicauca.electionvotermanagement.presentation;

import co.unicauca.electionvotermanagement.acces.ConnectDB;
import java.sql.Connection;

/**
 *
 * @author mfcaicedo, danielerazo
 */
public class ElectionApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("empezamos ");
        
        //Probando la conexion de la base de datos 
        ConnectDB connect = new ConnectDB();
        
        try {
            Connection con = connect.getConexion();
            System.out.println("Conection version 4");
        } catch (Exception e) {
            System.out.println("Error: "+ e);
        }   
        
       
        
        
    }
    
}
