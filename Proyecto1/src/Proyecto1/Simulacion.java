/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 *
 * @author Windows Pro
 */
public class Simulacion {
    Graph grafoSim = new SingleGraph("Proyecto 1");             // El grafo en el que se va a correr la simulacion
    Nodo inicio;                // El nodo donde se va a arrancar
    Nodo destino;               // El nodo destino a donde se quiere llegar
    float alfa;                 // La importancia que se le quiere dar a las feromonas
    float beta;                 // La importancia qu se le quiere dar a la visibilidad
    int iteraciones;               // La cantidad de iteraciones que van a participar en la silumacion (Cantidad de iteraciones)
    float disipacion;           // La cantidad de feromonas disipadas con cada iteracion (El recorrido de cada hormiga)
    float ultimaDistancia;      // Ultimo recorrido de la hormiga (Para calcular las nuevas feromonas en todos los nodos)
    Nodo primerNodoVisitado;    // El inicio de la lista de nodos visitados para cada simulacion
    Nodo ultimoNodoVisitado;    // El ultimo nodo visitado para cada simulacion
    float feromIniciales;
    Nodo nodoActual;
    
    public Simulacion(){
        this.grafoSim = null;
        this.inicio = null;
        this.destino = null;
        this.alfa = 1F;
        this.beta = 1F;
        this.iteraciones = 0;
        this.disipacion = 0.01F;
        this.primerNodoVisitado = null;
        this.ultimoNodoVisitado = null;
        this.feromIniciales = 0.1F;
        this.nodoActual = null;
    }
    
    public Simulacion(Graph miGrafo){
        this.grafoSim = miGrafo;
        this.inicio = null;
        this.destino = null;
        this.alfa = 1F;
        this.beta = 1F;
        this.iteraciones = 0;
        this.disipacion = 0.01F;
        this.primerNodoVisitado = null;
        this.ultimoNodoVisitado = null;
        this.feromIniciales = 0.1F;
        this.nodoActual = null;
    }

    public Graph getGrafoSim() {
        return grafoSim;
        
    }

    public void setGrafoSim(Graph grafoSim) {
        this.grafoSim = grafoSim;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getDestino() {
        return destino;
    }

    public void setDestino(Nodo destino) {
        this.destino = destino;
    }

    public float getAlfa() {
        return alfa;
    }

    public void setAlfa(float alfa) {
        this.alfa = alfa;
    }

    public float getBeta() {
        return beta;
    }

    public void setBeta(float beta) {
        this.beta = beta;
    }

    public int getIteraciones() {
        return iteraciones;
    }

    public void setIteraciones(int iteraciones) {
        this.iteraciones = iteraciones;
    }

    public float getDisipacion() {
        return disipacion;
    }

    public void setDisipacion(float disipacion) {
        this.disipacion = disipacion;
    }

    public float getUltimaDistancia() {
        return ultimaDistancia;
    }

    public void setUltimaDistancia(float ultimaDistancia) {
        this.ultimaDistancia = ultimaDistancia;
    }

    public Nodo getPrimerNodoVisitado() {
        return primerNodoVisitado;
    }

    public void setPrimerNodoVisitado(Nodo primerNodoVisitado) {
        this.primerNodoVisitado = primerNodoVisitado;
    }

    public Nodo getUltimoNodoVisitado() {
        return ultimoNodoVisitado;
    }

    public void setUltimoNodoVisitado(Nodo ultimoNodoVisitado) {
        this.ultimoNodoVisitado = ultimoNodoVisitado;
    }
    
    public float getferomIniciales() {
        return feromIniciales;
    }

    public void setferomIniciales(float feromIniciales) {
        this.feromIniciales = feromIniciales;
    }
    
    //Metodo para arrancar la simulacion
    public void iniciarSimulacion(){
        //Primero validamos que todos los valores esten llenos y sean correctos
        
        if(this.inicio == null){
            JOptionPane.showMessageDialog(null,"Por favor escoja un nodo de inicio antes de comenzar la simulacion!");
        }
        else if(this.destino == null){
            JOptionPane.showMessageDialog(null,"Por favor escoja un nodo destino antes de comenzar la simulacion!");
        }
        else if(this.iteraciones < 1 ){
            JOptionPane.showMessageDialog(null, "Introduzca un numero valida de iteraciones");
        }
        else if(this.disipacion <= 0 || this.disipacion >=1){
            JOptionPane.showMessageDialog(null, "Introduzca un numero valido de disipacion de feromonas");
        }
        else if(this.feromIniciales <= 0 || this.feromIniciales >= 1){
            JOptionPane.showMessageDialog(null, "Introduzca un numero valido de feromonas iniciales");
        }
        else{
            //Logica principal de la simulacion
            for (int i = 1; i <= this.iteraciones; i++) {
                
                //Inicializo mi lista de nodos visitados
                this.primerNodoVisitado = this.inicio;
                this.primerNodoVisitado.setSiguienteNodo(null);
                this.ultimoNodoVisitado = null;
                
                //Comienzo buscando la adyacencia de los nodos al que estoy actualmente
                this.nodoActual = this.inicio;
                
                
            }
        }
        
        
    }
    
    public void cargaFeromonas(){
        
    }

    boolean esvacia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Arista getPrimero() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void insertar(Arista aristaFilt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setPrimero(Arista aristaAux) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    }
