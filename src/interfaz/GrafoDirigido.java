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
public class GrafoDirigido /**grafo con sus usuarios y aristas*/
{
    /**Arreglos para realizar el grafo*/
    public String[] usuarios;
    public String[][] relaciones;
    public String[] colores;

    public GrafoDirigido() 
    {
        this.usuarios = new String[0];             /**Crea un arreglo vacío llamado usuarios*/
        this.relaciones = new String[0][2];        /**Crea un arreglo vacío con dos columnas llamado relaciones*/
        this.colores = new String[0];              /**Crea un arreglo vacío llamado colores*/
    }

    public void vergrafo()
    {
        /**
         * Crea un nuevo grafo donde puedes tener más de una relación para cada nodo,
         * Establece que el arreglo de esta clase usuarios es del mismo tamaño que users,
         * Establece que el arreglo relaciones de esta clase es del mismo tamaño que relations,
         * Crea un nuevo arreglo llamado comuntemp que copia a todo el arreglo SCC de la clase Kosaraju,
         * Crea una variable numérica que contendrá la cantidad de vertices o nodos que hay en el arreglo users,
         * Se agregan diversos colores escritos en hexadecimal al arreglo de la clase colores,
         * Se le atribuye al nodo creado un color dependiendo de donde este el nodo creado del arreglo SCC 
         * Según el algoritmo de Kosaraju,
         * Se crean Edges o aristas para la representación gráfica del grafo,
         * Muestra el grafo en pantalla
         */
        Graph grafo = new MultiGraph("Grafo dirigido", false, true);
        this.usuarios = Inicio.objUsers.users;
        this.relaciones = Inicio.objRels.relations;
        String[][] comuntemp = Inicio.kosara.scc;
        int numvertices = Inicio.objUsers.users.length;
        this.colores = new String[]{"#ffafcd","#b0fae8","#c97bab","#7caaee","#9bee7c","#ffbb66","#ff6666","#3db822","#287fff","#f2f768","#53d699","#da9494"};
        for (int h=0; h < numvertices; h++)
        {
            for (int i = 0; i<numvertices; i++)
            {
                for (int j = 0; j<numvertices; j++)
                {
                    if(comuntemp[i][j]==null) break;
                    if (comuntemp[i][j].equals(usuarios[h]))
                    {
                        Node nodo = grafo.addNode(usuarios[h]);
                        nodo.setAttribute("ui.label", usuarios[h]);
                        nodo.setAttribute("ui.style", "fill-color: " + this.colores[i]+";");
                    }
                }  
            }
        }
        
        for (int i= 0; i<relaciones.length; i++)
        {
            grafo.addEdge(relaciones[i][0]+ ", " + relaciones[i][1], relaciones[i][0],relaciones[i][1], true);
        }
        grafo.setAttribute("ui.stylesheet",  
              "node {"
        + "   size: 75px;"
        + "   text-alignment: center;"
        + "   shape: circle;"
        + "   size-mode: dyn-size;"        
        + "   text-size: 10;"
        + "   text-color: black;"       
        + "   text-style: bold;"
        + "}"
        + "edge {"
        + "   size: 3px;"
        + "   arrow-size: 7px, 7px;"      
        + "}");
        Viewer view = grafo.display();
        view.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }   
}
