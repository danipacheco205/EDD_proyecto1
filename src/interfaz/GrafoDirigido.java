/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

/**
 *
 * @author Daniela
 */
public class GrafoDirigido {
    
    
    public void vergrafo()
    {
        Graph grafo = new MultiGraph("Grafo dirigido", false, true);
        String[] usuarios = Inicio.objUsers.users;
        String[][] relaciones = Inicio.objRels.relations;
        for (int i= 0; i<usuarios.length; i++)
        {
            Node nodo = grafo.addNode(usuarios[i]);
            nodo.setAttribute("ui.label", usuarios[i]);
        }
        for (int i= 0; i<relaciones.length; i++)
            grafo.addEdge(relaciones[i][0]+ ", " + relaciones[i][1], relaciones[i][0],relaciones[i][1], true);
        grafo.setAttribute("ui.stylesheet", 
            "node {"
            + "   fill-color: blue;"
            + "   size: 75px;"
            + "   text-alignment: center;"
            + "   shape: circle; "
            + "   size-mode: dyn-size;"        
            + "   text-size: 10;"
            + "   text-color: white;"       
            + "   text-style: bold;}"
            + "edge {"
            + "   arrow-size: 7px, 7px;"      
            + "}");
        Viewer view = grafo.display();
        view.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
}
