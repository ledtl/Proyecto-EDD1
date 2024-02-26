/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 *
 * @author Windows Pro
 */
public class Nodo {
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

    public Nodo getpNext() {
        return pNext;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   public void setpNext(Nodo pNext) {
        this.pNext = pNext;
    }

    public double getFeromonas() {
        return tau;
    }

    public void setFeromonas(double tau) {
        this.tau = tau;
    }

    public Nodo getNodosAdyacentes() {
        return nodosAdyacentes;
    }

    public void setNodosAdyacentes(Nodo nodosAdyacentes) {
        this.nodosAdyacentes = nodosAdyacentes;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
     
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
    
}


    
    
    

