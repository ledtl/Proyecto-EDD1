/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 * Esta es la clase donde se encuentra el nodo
 * @author Edgar Torres
 * @version 25/02/2024
 */
public class Nodo {
    
    //campos de la clase
    
    private Nodo pNext; 
    private Object info;
    String nombre;
    double tau;
    Nodo nodosAdyacentes;
    Nodo siguienteNodo;
    
    public Nodo(String nombreNodo, double ferom){
        this.nombre = nombreNodo;
        this.tau = ferom;
        this.siguienteNodo = null;
        this.nodosAdyacentes = null;
    }
        
   public Nodo(Nodo pNext, Object info, Simulacion Arcos ) {
        this.pNext = pNext;
        this.info = info;
        
    }
    
    public Nodo(){
        this.nombre = "";
        this.tau = 0.0f;
        this.siguienteNodo = null;
        this.nodosAdyacentes = null;
    }
    
    public Nodo(String nuevoNombre){
        this.nombre = nuevoNombre;
        this.tau = 0.0f;
        this.siguienteNodo = null;
        this.nodosAdyacentes = null;
    }
    
    
    public Nodo(Object info) {
        this.pNext = null;
        this.info = info;
    }

    /**
     * @return the pNext
     */
    public Nodo getpNext() {
        return pNext;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * @param pNext the pNext to set
     */
    public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    /**
     * @return the tau
     */
    public double getFeromonas() {
        return tau;
    }

    /**
     * @param tau the tau to set
     */
    public void setFeromonas(double tau) {
        this.tau = tau;
    }

    /**
     * @return the nodosAdyacentes
     */
    public Nodo getNodosAdyacentes() {
        return nodosAdyacentes;
    }

    /**
     * @param nodosAdyacentes the nodosAdyacentes to set
     */
    public void setNodosAdyacentes(Nodo nodosAdyacentes) {
        this.nodosAdyacentes = nodosAdyacentes;
    }

    /**
    * @return the siguienteNodo
    */
    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    /**
     * @param siguienteNodo the siguienteNodo to set
     */
    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
     
    }

    /**
    * @return the info
    */
    public Object getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(Object info) {
        this.info = info;
    }
    
}//cierre de la clase


    
    
    

