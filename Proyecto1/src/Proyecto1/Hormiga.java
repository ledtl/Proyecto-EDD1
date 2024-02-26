/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 *
 * @author Edgar Torres
 */
public class Hormiga {
    private ListaSimple camino;
    private float alpha;
    private float beta;
    private Grafo grafo;

    public Hormiga(Grafo grafo, float alpha, float beta) {
        this.camino = new ListaSimple();
        this.alpha = alpha;
        this.beta = beta;
        this.grafo = grafo;
    }
    
    public Hormiga() {
        this.camino = null;
        this.alpha = 1f;
        this.beta = 1f;
        this.grafo = null;
    }

    public boolean NodoVisitado(NodoArista nodo) { 
        boolean visitado = false;
        Nodo aux = camino.getpFirst();
        for (int i = 0; i < camino.getSize(); i++){ 
            if (nodo.getDato() == aux.getInfo()){
                visitado = true;
        }else{ 
            aux = aux.getpNext(); 
            }
        }
        return visitado;
    } 
 
    public void buscarCamino(Grafo grafo) {
        camino.vaciar();
        NodoArista nodoActual = this.grafo.getPrimero();
        // nodoActual.setSiguiente(null);
        camino.InsertAtTheEnd(nodoActual.getDato());
        while (nodoActual != this.grafo.getUltimo()) {
            Arista aristaAux = nodoActual.getLista().getPrimero();
            Simulacion aristasDisponibles = new Simulacion();
            aristasDisponibles.setPrimero(aristaAux);
            aristasDisponibles = filtrarAristasDisponibles(aristasDisponibles);
            if (aristasDisponibles.esvacia()) { // verificar si el nodo actual es una calle ciega (sin aristas disponibles)
                break;
            }
            float sumaProbabilidades = 0.0f;
            ListaSimple probabilidades = new ListaSimple();
            Arista arista = aristasDisponibles.getPrimero();
            while (arista != null) {
                sumaProbabilidades += Math.pow(arista.getFeromonas(), alpha) * Math.pow(arista.getVisibilidad(), beta);
                arista = arista.getSiguiente();
            }
            arista = aristasDisponibles.getPrimero();
            while (arista != null) {
                float probabilidad = (float) (Math.pow(arista.getFeromonas(), alpha) * Math.pow(arista.getVisibilidad(), beta) / sumaProbabilidades);
                probabilidades.InsertAtTheEnd(probabilidad);
                arista = arista.getSiguiente();
            }
            arista = aristasDisponibles.getPrimero();
            float probabilidadAcumulada = 0.0f;
            float valorAleatorio = (float) Math.random();
            Arista aristaElegida = null;
            Nodo aux = probabilidades.getpFirst();
            while (arista != null) {
                probabilidadAcumulada += (float) aux.getInfo();
                if (valorAleatorio <= probabilidadAcumulada) {
                    aristaElegida = arista;
                    break;
                }
                arista = arista.getSiguiente();
                aux = aux.getpNext();
            }      
            
            if (aristaElegida != null) {
                String siguienteNodo = null;
                camino.InsertAtTheEnd(siguienteNodo);
                nodoActual = grafo.obtenerNodo((String) siguienteNodo);
            } else {
                // Si no se eligió ninguna arista, salir del bucle
                break;
            }
        }
    }
    
    public void depositarFeromonas() {
        Nodo aux = camino.getpFirst();
        while (aux.getpNext() != null) {
            Object origen = aux.getInfo();
            Object destino = aux.getpNext().getInfo();
            Arista arista = grafo.obtenerAristaEntreNodos(origen, destino);
            float cantidadFeromonas = (float) (1.0f / arista.getDistancia());
            arista.setFeromonas(arista.getFeromonas() + cantidadFeromonas);
            aux = aux.getpNext();
        }
    }
    
    private Simulacion filtrarAristasDisponibles(Simulacion aristas) {
        Simulacion aristasFiltradas = new Simulacion();
        Arista arista = aristas.getPrimero();
        int cont = 0;
        while (arista != null) {
            cont++;
            arista = arista.getSiguiente();
        }
        arista = aristas.getPrimero();
        for (int i = 0; i < cont; i++ ) {
            if (!NodoVisitado(arista.getDestino())) {
                Arista aristaFilt = (Arista) arista.clone();
                aristaFilt.setSiguiente(null);
                aristasFiltradas.insertar(aristaFilt);
            }
            arista = arista.getSiguiente();
        }
        
        return aristasFiltradas;
    }
    
    public boolean NodoVisitado(Object nodo) {
        Nodo aux = camino.getpFirst();
        while (aux != null) {
            if (nodo.equals(aux.getInfo())) {
                return true;
            }
            aux = aux.getpNext();
        }
        return false;
    }    


    public ListaSimple getCamino() {
        return camino;
    }

    public void setCamino(ListaSimple camino) {
        this.camino = camino;
    }
    

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public float getBeta() {
        return beta;
    }

    public void setBeta(float beta) {
        this.beta = beta;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
}
