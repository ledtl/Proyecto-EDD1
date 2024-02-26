/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 * Esta clase define la lista simple
 * @author Edgar Torres
 * @version 25/02/2024
 */
public class ListaSimple {
    
    //campos de la clase
    private Nodo pFirst; 
    private Nodo pLast; 
    private int size; 

    public ListaSimple(Nodo pFirst, Nodo pLast, int size) {
        this.pFirst = pFirst;
        this.pLast = pLast;
        this.size = size;
        
    }
    
    public ListaSimple() {
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }
    
    // Método que revisa si la lista está vacia o no
    // @return true o false
    public boolean EsVacia(){ 
        return (getpFirst() == null);               
    }//cierre del método
    
    // Método que revisa si la lista contiene un elemento
    // @param elemento el elemento que se está revisando
    // @return true o false    
    public boolean contains(Object elemento) {
        Nodo actual = pFirst;
        while (actual != null) {
            if (actual.getInfo().equals(elemento)) {
                return true;
            }
            actual = actual.getpNext();
        }
        return false;
    }//cierre del método

    // Método que inserta el elemento al final de la lista
    // @param x el objeto que se va insertar al final    
    public void InsertAtTheEnd(Object x){ 
        Nodo nuevo = new Nodo(x);
        if (this.EsVacia()){ 
            setpFirst(pLast = nuevo); 
        }else { 
            Nodo aux = pLast; 
            aux.setpNext(nuevo);
            pLast = nuevo;    
        }
        size++; 
    }//cierre del método

    // Método que elimina un elemento de la lista
    // @param elemento el objeto que se va eliminar
    public void RemoveElement(Object elemento) {
        // Verificar si la lista está vacía
        if (EsVacia()) {
            return;
        }
        
        // Caso especial: si el primer nodo contiene el elemento
        if (pFirst.getInfo().equals(elemento)) {
            pFirst = pFirst.getpNext();
            size--;
            if (pFirst == null) {
                pLast = null; // Si el primer nodo es el único nodo en la lista, pLast también debe ser null
            }
            return;
        }
        
        // Buscar el nodo que contiene el elemento y el nodo anterior
        Nodo prev = pFirst;
        Nodo current = pFirst.getpNext();
        while (current != null) {
            if (current.getInfo().equals(elemento)) {
                prev.setpNext(current.getpNext());
                size--;
                if (current == pLast) {
                    pLast = prev; // Si el nodo eliminado era el último, actualizamos pLast
                }
                return;
            }
            prev = current;
            current = current.getpNext();
        }
        
        // Si no se encontró el elemento, no se hace nada
    }//cierre del método
    
    // Método que imprime la lista de hormigas
    // @return String
    public String ImprimirListadeHormigas(){ 
        StringBuilder cadena = new StringBuilder();
        int contador = 1;
        Nodo aux = this.getpFirst();
        while (aux != null) {
            Hormiga hormiga = (Hormiga) aux.getInfo();
            Nodo aux1 = hormiga.getCamino().getpFirst();
            cadena.append("Hormiga ").append(contador).append(": ");
            while (aux1 != null) {
                cadena.append(aux1.getInfo());
                if(aux1.getpNext() != null)
                    cadena.append(", ");
                aux1 = aux1.getpNext();
            }
            cadena.append("\n");
            aux = aux.getpNext();
            contador ++;
        }
        return cadena.toString();
    }//cierre del método
    
    // Método que vacia la lista    
    public void vaciar(){
        this.pFirst = null;
        this.pLast = null;
        this.size = 0;
    }//cierre del método

     /**
     * @return the pFirst
     */
    public Nodo getpFirst() {
        return pFirst;
    }

    /**
     * @param pFirst the pFirst to set
     */
    public void setpFirst(Nodo pFirst) {
        this.pFirst = pFirst;
    }

    /**
     * @return the pLast
     */
    public Nodo getpLast() {
        return pLast;
    }

    /**
     * @param pLast the pLast to set
     */
    public void setpLast(Nodo pLast) {
        this.pLast = pLast;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }

    
}//cierre de la clase
    

