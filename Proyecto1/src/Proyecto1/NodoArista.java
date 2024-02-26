/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 *
 * @author Edgar Torres
 */
public class NodoArista {
    private Object dato;
    private Simulacion lista;
    private NodoArista siguiente;
    
    public NodoArista(Object x){
        this.dato = x;
        this.lista = new Simulacion(); 
        this.siguiente = null;

    }

    public NodoArista(Object dato, Simulacion lista, NodoArista siguiente) {
        this.dato = dato;
        this.lista = lista;
        this.siguiente = siguiente;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Simulacion getLista() {
        return lista;
    }

    public void setLista(Simulacion lista) {
        this.lista = lista;
    }

    public NodoArista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoArista siguiente) {
        this.siguiente = siguiente;
    }

    
}
