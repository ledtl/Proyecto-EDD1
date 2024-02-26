/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import ventanas.Newmenu;

/**
 *
 * @author Windows Pro
 */
public class MostrarInterfaz {
    
    public Graph Grafo(){
        
        System.setProperty("org.graphstream.ui", "swing"); 
        
        Graph grafoproyecto = new SingleGraph("Proyecto 1");
        
        return grafoproyecto;  
    }
    
    public static void main(String[] args) {
        
        Newmenu menu = new Newmenu();
        
        menu.show(true);
    }
}
