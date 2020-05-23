/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartrmi;

/**
 *
 * @author Sergio
 */
public class producto implements java.io.Serializable {
    
    public String id; 
    public String nombre; 
    public int cantidad; 
    public double precio; 
    
    public producto(){
        
    }
    public producto(String id, String nombre, int cantidad, double precio){
        this.id = id; 
        this.nombre = nombre;
        this.cantidad = cantidad; 
        this.precio = precio; 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

 
    
}
