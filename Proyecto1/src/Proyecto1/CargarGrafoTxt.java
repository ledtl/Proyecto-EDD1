/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto1;


import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.graphstream.graph.implementations.SingleGraph;

public class CargarGrafoTxt {
    
    private Graph graph;

    
    public CargarGrafoTxt() {
        this.graph = new SingleGraph("Grafo");
    }
    
    public void cargarGrafoDesdeArchivo() {
        String archivoSeleccionado = abrirArchivo();
        if (archivoSeleccionado != null && !archivoSeleccionado.isEmpty()) {
            CargarGrafoTxt cargador = new CargarGrafoTxt();
            if (cargador.cargarGrafoTxt(graph, archivoSeleccionado)) {
                JOptionPane.showMessageDialog(null, "Grafo cargado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al cargar el grafo.");
            }
        }
    }
    
    public String abrirArchivo() {
        String aux = "";
        String texto = "";

        try {
            JFileChooser file = new JFileChooser();
            file.setFileFilter(new FileNameExtensionFilter("Archivos de texto (.txt)", "txt"));
            file.showOpenDialog(file);

            File abre = file.getSelectedFile();

            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                try (BufferedReader lee = new BufferedReader(archivos)) {
                    while ((aux = lee.readLine()) != null) {
                        texto += aux + "\n";
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + "" +
                    "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }

    // Método que lee el archivo 
    // @param graph el grafo del sistema, fileName el string con los datos del archivo
    // @return true o false
        public boolean leerArchivo(Graph graph, String fileName) {
            try {
                File file = new File(fileName);
                try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
                    String linea = br.readLine();
                    while (linea != null) {
                        if (linea.startsWith("ciudad")) {
                            linea = br.readLine();
                            while (!linea.startsWith("aristas")) {
                                if (!linea.isEmpty()) {
                                    agregarNodo(graph, linea);
                                }
                                linea = br.readLine();
                            }
                        } else if (linea.startsWith("aristas")) {
                            linea = br.readLine();
                            while (linea != null) {
                                if (!linea.isEmpty()) {
                                    agregarArista(graph, linea);
                                }
                                linea = br.readLine();
                            }
                        }
                    }
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        }//cierre del método

        // Método que agrega el nodo al txt
        // @param graph el grafo del sistema, linea la linea de string con los datos requeridos
        public void agregarNodo(Graph graph, String linea) {
            try {
                int idNodo = Integer.parseInt(linea.trim());
                Node nodo = graph.getNode(String.valueOf(idNodo));
                if (nodo == null) {
                    graph.addNode(String.valueOf(idNodo));
                }
            } catch (NumberFormatException e) {
                System.err.println("Error al parsear el ID del nodo: " + linea);
            }
        }//cierre del método

        // Método que agrega la arista al txt
        // @param graph el grafo del sistema, linea la linea de string con los datos requeridos
    public void agregarArista(Graph graph, String linea) {
        String[] partes = linea.split("\\s*,\\s*");
        int idNodo1, idNodo2;
        double length;

        try {
            idNodo1 = Integer.parseInt(partes[0]);
            idNodo2 = Integer.parseInt(partes[1]);
            length = Double.parseDouble(partes[2]);
        } catch (NumberFormatException e) {
            System.err.println("Error al parsear los datos de la arista: " + linea);
            return;
        }

        Node nodo1 = graph.getNode(String.valueOf(idNodo1));
        Node nodo2 = graph.getNode(String.valueOf(idNodo2));

        if (nodo1 != null && nodo2 != null) {
            if (!nodo1.hasEdgeToward(nodo2)) {
                Edge edge = graph.addEdge(nodo1.getId() + "-" + nodo2.getId(), nodo1, nodo2, true);
                edge.setAttribute("length", length);
            }
        }
    }//cierre del método

    public boolean cargarGrafoTxt(Graph graph, String archivoSeleccionado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
