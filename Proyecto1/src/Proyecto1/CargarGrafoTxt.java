/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Esta clase define las funciones para poder cargar el grafo en un archivo txt
 * @author Jesús Fernandez
 * @version 25/02/2024
 */
public class CargarGrafoTxt {

    //campos de la clase
    
    // Método que carga los grafos en un txt
    // @param graph el grafo del sistema, fileName el string con los datos del archivo
    public void cargarGrafoTxt(Graph graph, String fileName) {
        if (leerArchivo(graph, fileName) == true) {
            JOptionPane.showMessageDialog(null, "Grafo cargado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al cargar el grafo.");
        }
    }//cierre del método

    // Método que lee el archivo 
    // @param graph el grafo del sistema, fileName el string con los datos del archivo
    // @return true o false
    private boolean leerArchivo(Graph graph, String fileName) {
        try {
            File file = new File(fileName);
            try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                
                String linea = br.readLine();
                while (linea != null) {
                    if (linea.startsWith("Nodos")) {
                        linea = br.readLine();
                        while (!linea.startsWith("Aristas")) {
                            if (!linea.isEmpty()) {
                                agregarNodo(graph, linea);
                            }
                            linea = br.readLine();
                        }
                    } else if (linea.startsWith("Aristas")) {
                        linea = br.readLine();
                        while (linea != null) {
                            if (!linea.isEmpty()) {
                                agregarArista(graph, linea);
                            }
                            linea = br.readLine();
                        }
                    }
                }
                
            }
            return true;

        } catch (IOException e) {
            return false;
        }
    }//cierre del método

    // Método que agrega el nodo al txt
    // @param graph el grafo del sistema, linea la linea de string con los datos requeridos
    private void agregarNodo(Graph graph, String linea) {
        String idNodo = linea.trim();
        Node nodo = graph.getNode(idNodo);
        if (nodo.getId() == null) {
            graph.addNode(idNodo);
        }
    }//cierre del método

    // Método que agrega la arista al txt
    // @param graph el grafo del sistema, linea la linea de string con los datos requeridos
    private void agregarArista(Graph graph, String linea) {
        String[] partes = linea.split("->");
        String idNodo1 = partes[0].trim();
        String idNodo2 = partes[1].split("\\(")[0].trim();
        
        Node nodo1 = graph.getNode(idNodo1);
        Node nodo2 = graph.getNode(idNodo2);

        if (nodo1.getId() != null && nodo2.getId() != null) {

            double length = Double.parseDouble(partes[1].split("\\(")[1].replace(")", "").trim());

            if (nodo1.hasEdgeToward(nodo2)) {
                graph.addEdge(idNodo1 + "-" + idNodo2, nodo1, nodo2, true);
                graph.getEdge(idNodo1 + "-" + idNodo2).setAttribute("length", length);
            }
        }
    }//cierre del método
}//cierre de la clase
