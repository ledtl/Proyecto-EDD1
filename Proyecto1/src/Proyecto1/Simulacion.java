/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

/**
 * Esta es la clase donde se va a realizar la simulación
 * @author Edgar Torres
 * @version 25/02/2024
 */
public class Simulacion {
    
    //campos de la clase
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
    }

    /**
    * @return the grafoSim
    */
    public Graph getGrafoSim() {
        return grafoSim; 
    }

     /**
     * @param grafoSim the grafoSim to set
     */
    public void setGrafoSim(Graph grafoSim) {
        this.grafoSim = grafoSim;
    }

    /**
    * @return the inicio
    */
    public Nodo getInicio() {
        return inicio;
    }

     /**
     * @param inicio the inicio to set
     */
    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
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
    * @return the alfa
    */
    public float getAlfa() {
        return alfa;
    }

     /**
     * @param alfa the alfa to set
     */
    public void setAlfa(float alfa) {
        this.alfa = alfa;
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
    * @return the iteraciones
    */
    public int getIteraciones() {
        return iteraciones;
    }

     /**
     * @param iteraciones the iteraciones to set
     */
    public void setIteraciones(int iteraciones) {
        this.iteraciones = iteraciones;
    }

    /**
    * @return the disipacion
    */
    public float getDisipacion() {
        return disipacion;
    }

     /**
     * @param disipacion the disipacion to set
     */
    public void setDisipacion(float disipacion) {
        this.disipacion = disipacion;
    }

    /**
    * @return the ultimaDistancia
    */
    public float getUltimaDistancia() {
        return ultimaDistancia;
    }

     /**
     * @param ultimaDistancia the ultimaDistancia to set
     */
    public void setUltimaDistancia(float ultimaDistancia) {
        this.ultimaDistancia = ultimaDistancia;
    }

    /**
    * @return the primerNodoVisitado
    */
    public Nodo getPrimerNodoVisitado() {
        return primerNodoVisitado;
    }

     /**
     * @param primerNodoVisitado the primerNodoVisitado to set
     */
    public void setPrimerNodoVisitado(Nodo primerNodoVisitado) {
        this.primerNodoVisitado = primerNodoVisitado;
    }

    /**
    * @return the ultimoNodoVisitado
    */
    public Nodo getUltimoNodoVisitado() {
        return ultimoNodoVisitado;
    }

     /**
     * @param ultimoNodoVisitado the ultimoNodoVisitado to set
     */
    public void setUltimoNodoVisitado(Nodo ultimoNodoVisitado) {
        this.ultimoNodoVisitado = ultimoNodoVisitado;
    }
    
    /**
    * @return the feromIniciales
    */
    public float getferomIniciales() {
        return feromIniciales;
    }

     /**
     * @param feromIniciales the feromIniciales to set
     */
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
                
                
                
            }
        }
        
        
    }//cierre del método

    /**
    * @return the exception
    */
    boolean esvacia() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
    * @return the exception
    */
    Arista getPrimero() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
    * @return the exception
    */
    void insertar(Arista aristaFilt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
    * @return the exception
    */
    void setPrimero(Arista aristaAux) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}//cierre de la clase
