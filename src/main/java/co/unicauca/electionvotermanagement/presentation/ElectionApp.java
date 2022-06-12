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
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>   

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMenu().setVisible(true);
            }
        });
        
        //Pruebas 
        System.out.println("empezamos ");
        
        //Probando la conexion de la base de datos 
        ConnectDB connect = new ConnectDB();
        
        try {
            Connection con = connect.getConexion();
            System.out.println("Conection version 6");
        } catch (Exception e) {
            System.out.println("Error: "+ e);
        }   
        
       
        
        
    }
    
}
