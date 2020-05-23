/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 *
 * @author Sergio
 */
public class impCart extends UnicastRemoteObject implements cartRemote {
    
    public String usuario;
    public ArrayList<producto> cart; 

    public impCart() throws RemoteException{
        super(); 
        this.cart = new ArrayList<producto>();
    }
    
    public String usuario(String user){
        this.usuario = user;
        return usuario; 
    }
    
    @Override
    public void agregar(producto p) throws RemoteException {
        cart.add(p);  
    }
    @Override
    public boolean remover(String nombre) throws RemoteException {
      return cart.remove(nombre);
       
    }

    @Override
    public String detallesCarro() throws RemoteException {
        String valor =null; 
        for(producto p:cart){
            valor +=("ID: "+p.id+" Nombre_Articulo "
                    +p.nombre
                    +" Cantidad: "+String.valueOf(p.cantidad) 
                    +"Precio unitario: "
                    +String.valueOf(p.precio)+" MX");
        }
         return valor;
        
    }

    @Override
    public int nummeroProductos() throws RemoteException {
        return cart.size(); 
    }

    @Override
    public double obtenerPrecio() throws RemoteException {
      double precio=0.0; 
      for(producto p:cart){
          precio+=p.getPrecio();
      }
      return precio; 
    }

    
    
    
}
