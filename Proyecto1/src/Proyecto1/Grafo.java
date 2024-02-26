/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

/**
 * Esta clase define las funciones que tiene el Graph Stream para poder insertar las ciudades, eliminarlas y conectar
 * los caminos entre si.
 * @author Diego Goncalves
 * @version 25/02/2024
 */
public class Grafo {

    /**
     * @param trim, string del nodo
     */
    public static void nuevoNodo(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the exception
     */
    public static float contarVertices() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @param origen objeto de origen
     * @param destino objeto de destino
     * @param distancia la distancia de la arista
     * @param feromonas la cantidad de feromonas
     */
    public static void NuevaArista(Object origen, Object destino, float distancia, float feromonas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //campos de la clase
    
    // Método que elimina las ciudades del graph stream
    // @param graph el grafo del sistema, ciudad el número de la ciudad escogida
    public void EliminarCiudad(Graph graph, int ciudad){
        
        char letra = (char) (64 + ciudad);
        String str = String.valueOf(letra);
        graph.removeNode(str);
        JOptionPane.showMessageDialog(null,"Ciudad eliminada con éxito.");
        
    }//cierre del método

    // Método que conecta los nodos del graph stream
    // @param graph el grafo del sistema, nodo 1 el primer nodo escogido, nodo el segundo nodo escogido
    // distancia, la distancia que se escoge entre las ciudades
    public void ConectarNodos(Graph graph, int nodo1, int nodo2, int distancia){
        char letra1 = (char) (64 + nodo1);
        char letra2 = (char) (64 + nodo2);
        
        String str1 = String.valueOf(letra1);
        String str2 = String.valueOf(letra2);
        
        Node test = graph.getNode(str1);
        
        if (test.hasEdgeToward(str2) == true) {
            JOptionPane.showMessageDialog(null,"Esta ciudad ya está conectada a otra.");
        }
        else{
                int i = 1;
                String s = Integer.toString(i);
                
                graph.addEdge(s, str1, str2).setAttribute("length", distancia);
                i++;
                JOptionPane.showMessageDialog(null,"Nodo añadido con exito.");
            }
    }//cierre del método
    
    // Método que agrega los nodos al graph stream
    // @param graph el grafo del sistema, ciudades el número de ciudades que si quiere añadir
    public Graph AgregarCiudad(Graph grafoproyecto, int ciudades){
        
        for (char letra = 65; letra < 65+ciudades; letra++){
            String str = String.valueOf(letra);
            grafoproyecto.addNode(str);
        }
        
        Graph grafo = grafoproyecto;
        JOptionPane.showMessageDialog(null,"Ciudades añadidas con exito.");
        return grafo;
    }//cierre del método

    /**
     * @return the exception
     */
    NodoArista getUltimo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the exception
     */
    NodoArista getPrimero() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the exception
     */
    NodoArista obtenerNodo(String siguienteNodo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the exception
     */
    Arista obtenerAristaEntreNodos(Object origen, Object destino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}//cierre de la clase
