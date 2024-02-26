/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 * Esta clase define la arista
 * @author Edgar Torres
 * @version 25/02/2024
 */
public class Arista {
    
    //campos de la clase
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

    /**
     * @return the origen
     */
    public Nodo getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(Nodo origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public Nodo getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    /**
     * @return the distancia
     */
    public double getDistancia() {
        return distancia;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    /**
     * @return the siguienteArista
     */
    public Arista getSiguienteArista() {
        return siguienteArista;
    }

    /**
     * @param siguienteArista the siguienteArista to set
     */
    public void setSiguienteArista(Arista siguienteArista) {
        this.siguienteArista = siguienteArista;
    }

    /**
     * @return the exception
     */
    double getFeromonas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the exception
     */
    Arista getSiguiente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the exception
     */
    double getVisibilidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the exception
     */
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

    /**
     * @return the exception
     */
    void setFeromonas(double d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}//cierre de la clase
