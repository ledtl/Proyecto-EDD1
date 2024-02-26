/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

import org.graphstream.graph.Graph;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.graphstream.graph.Node;

/**
 * Esta clase define las funciones para poder guardar el grafo en un archivo txt
 * @author Jesús Fernandez
 * @version 25/02/2024
 */
public class GuardarGrafoTxt {
   
    //campos de la clase
    
    // Método que guarda los grafos en un txt
    // @param graph el grafo del sistema, fileName el string con los datos del archivo
    public void GuardarGrafoTxt(Graph graph, String fileName) {
        try {
            File file = new File(fileName);
            try (FileWriter fw = new FileWriter(file); BufferedWriter bw = new BufferedWriter(fw)) {
                
                bw.write("Nodos:");
                bw.newLine();
                for (Node nodo : graph) {
                    bw.write(nodo.getId());
                    bw.newLine();
                }
                
                bw.write("Aristas:");
                bw.newLine();
                graph.edges().forEach(arista -> {
                    try {
                        bw.write(arista.getSourceNode().getId() + " -> " + arista.getTargetNode().getId() + " (" + arista.getAttribute("length") + ")");
                    } catch (IOException ex) {
                        Logger.getLogger(GuardarGrafoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        bw.newLine();
                    } catch (IOException ex) {
                        Logger.getLogger(GuardarGrafoTxt.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                
            }
            JOptionPane.showMessageDialog(null, "Grafo guardado con éxito.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar el grafo: " + e.getMessage());
        }
    }//cierre del método
}//cierre de la clase

