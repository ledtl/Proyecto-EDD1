/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 * Esta es la clase donde se conecta el nodo con la arista
 * @author Edgar Torres
 * @version 25/02/2024
 */
public class NodoArista {
    
    //campos de la clase

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

    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the lista
     */
    public Simulacion getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Simulacion lista) {
        this.lista = lista;
    }

    /**
     * @return the siguiente
     */
    public NodoArista getSiguiente() {
        return siguiente;
    }

     /**
     * @param siguiente the lista to set
     */
    public void setSiguiente(NodoArista siguiente) {
        this.siguiente = siguiente;
    }

}//cierre de la clase
