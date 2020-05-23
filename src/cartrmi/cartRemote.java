/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;


/**
 *
 * @author Sergio
 */
public interface cartRemote extends Remote {
    
  void agregar (producto p) throws RemoteException;
  boolean remover(String id) throws RemoteException;
  String detallesCarro()throws RemoteException;
  int nummeroProductos()throws RemoteException;
  double obtenerPrecio()throws RemoteException;
            

}
