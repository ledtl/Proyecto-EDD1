/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import ventanas.Newmenu;

/**
 * Esta es la clase main donde se muestra la interfaz
 * @author Diego Goncalves
 * @version 25/02/2024
 */
public class MostrarInterfaz {
    
    //campos de la clase
    
    // Método que agarra el grafo realizado
    // @return Graph
    public Graph Grafo(){
        
        System.setProperty("org.graphstream.ui", "swing"); 
        
        Graph grafoproyecto = new SingleGraph("Proyecto 1");
        
        return grafoproyecto;  
    }//cierre del método
    
    public static void main(String[] args) {
       
        Newmenu menu = new Newmenu();
        
        menu.show(true);
    }

}
