/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartrmi;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
/**
 *
 * @author Sergio
 */
public class serrvidorCartRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String ip = JOptionPane.showInputDialog("Ingrese su IP");
        int puerto = Integer.parseInt(JOptionPane.showInputDialog("Abra el puerto"));
        try  {
            System.setProperty("java.rmi.server.hostname", ip);
            Registry miRegistro = java.rmi.registry.LocateRegistry.createRegistry(puerto);
            miRegistro.rebind("Carrito",new impCart());
            System.out.println("Servidor listo");
        } catch (Exception e) {
             System.out.println("Exception: " + e.getMessage());
            }
      }
    
}
