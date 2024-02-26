/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 *
 * @author Windows Pro
 */
public class Arista {
    Nodo origen;
    Nodo destino;
    double distancia;
    Arista siguienteArista;
    
    public Arista(Nodo orig, Nodo dest, double dist){
        this.origen = orig;
        this.destino = dest;
        this.distancia = dist;
        this.siguienteArista = null;
        
    }
    
    public Arista(){
        this.origen = null;
        this.destino = null;
        this.distancia = 0F;
        this.siguienteArista = null;
    }

    public Nodo getOrigen() {
        return origen;
    }

    public void setOrigen(Nodo origen) {
        this.origen = origen;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Arista getSiguienteArista() {
        return siguienteArista;
    }

    public void setSiguienteArista(Arista siguienteArista) {
        this.siguienteArista = siguienteArista;
    }

    double getFeromonas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Arista getSiguiente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    double getVisibilidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setSiguiente(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Arista clone() {
        try {
            return (Arista) super.clone();
        } catch (CloneNotSupportedException e) {
            // Manejo de excepción si la clase no es clonable
            return null;
        }
    }

    void setFeromonas(double d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
