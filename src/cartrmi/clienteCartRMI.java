package cartrmi;

import java.io.IOException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author Sergio
 */
public class clienteCartRMI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String respuesta; 
               
        try{
             //String ip = "192.168.0.4"; 
             String ip = JOptionPane.showInputDialog("Ingrese su IP");
             int puerto = Integer.parseInt(JOptionPane.showInputDialog("Abra el puerto"));
             Registry miRegistro = LocateRegistry.getRegistry(ip,puerto); 
             cartRemote orden = (cartRemote)miRegistro.lookup("Carrito");
             
             
             System.out.println("Bienvenido al carrito de compras");
             
             String nombre = JOptionPane.showInputDialog("Ingrese su nombre para comenzar: "); 
             impCart implement = new impCart();
             implement.usuario(nombre);
             
             if (implement.usuario != null){
                 
                 do{
                    int opcion = Integer.parseInt( JOptionPane.showInputDialog("Ingrese su opcion: "
                             + "\n 1- Agregar al carrito "
                             + "\n 2- Remover "
                             + "\n 3- Detalles del carro  "
                             + "\n 4- Numero de productos "
                             + "\n 5 - Precio total"));
                     switch(opcion){
                         case 1:            
                                String idItem = JOptionPane.showInputDialog("Ingrese el Id del articulo: ");
                                String nombreItem = JOptionPane.showInputDialog("Ingrese el nombre del articulo: ");
                                int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad: "));
                                double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese precio: ")); 
                                orden.agregar(new producto(idItem,nombreItem,cantidad,precio));
                            break; 
                         case 2:
                                String id = JOptionPane.showInputDialog("Ingrese el Id del articulo a retirar : ");
                                orden.remover(id);
                            break;
                         case 3: 
                             String detalles =  orden.detallesCarro();
                             System.out.println(detalles); 
                             break; 
                         
                         case 4:
                             int numero = orden.nummeroProductos();
                             System.out.println("El numero de productos es:" + numero);
                            break;
                         case 5:
                             double preciototal = orden.obtenerPrecio();
                             System.out.println("El precio total es: $"+preciototal+" MX ");
                             break; 
                         default: System.out.println("Metodo no encontrado");
                        }
                     respuesta = JOptionPane.showInputDialog("Continuar S/N");
                    }                
                 while(respuesta.equals("S")); 
            }
             
        }catch(IOException e){
           System.out.println("Error"+e);  
        }
    }

   
    
}
