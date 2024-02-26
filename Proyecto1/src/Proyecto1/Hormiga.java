/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

/**
 * Esta clase define los datos de la hormiga
 * @author Edgar Torres
 * @version 25/02/2024
 */
public class Hormiga {
    
    //campos de la clase
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

    // Método que revisa si el nodo se ha visitado o no
    // @param NodoArista el nodo recibido
    // @return true o false
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
    }//cierre del método
    
    // Método que busca el camino más corto
    // @param grafo el grafo recibido
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
    }//cierre del método
    
    // Método que deposita las feromonas
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
    }//cierre del método
    
    // Método que permite filtrar las aristas disponibles
    // @param aristas las aristas de la simulación
    // @return Simulacion
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
    }//cierre del método
    
    // Método que permite marcar el nodo como visitado
    // @param nodo el nodo que se va a revisar
    // @return true or false
    public boolean NodoVisitado(Object nodo) {
        Nodo aux = camino.getpFirst();
        while (aux != null) {
            if (nodo.equals(aux.getInfo())) {
                return true;
            }
            aux = aux.getpNext();
        }
        return false;
    }//cierre del método

    /**
     * @return the camino
     */
    public ListaSimple getCamino() {
        return camino;
    }

    /**
     * @param camino the camino to set
     */
    public void setCamino(ListaSimple camino) {
        this.camino = camino;
    }
    
    /**
     * @return the alpha
     */
    public float getAlpha() {
        return alpha;
    }

    /**
     * @param alpha the alpha to set
     */
    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    /**
     * @return the beta
     */
    public float getBeta() {
        return beta;
    }

    /**
     * @param beta the beta to set
     */
    public void setBeta(float beta) {
        this.beta = beta;
    }

    /**
     * @return the grafo
     */
    public Grafo getGrafo() {
        return grafo;
    }

    /**
     * @param grafo the grafo to set
     */
    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }
    
}//cierre de la clase
