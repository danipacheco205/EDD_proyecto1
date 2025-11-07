/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

/**
 *
 * @author Daniela
 */
public class Kosaraju 
{
    public int[][] numaristas;
    public int numvertices;
    public int [][] numaristasinver;
    public String[][] visited;
    public String[][] stack;
    public String[][] rels_normal;
    public String[][] rels_transpose;
    public String[] conjunto;
    public String[][] scc;

    public Kosaraju() 
    {
        this.scc = new String[0][];
    }
    
    public void getvalsKosaraju()
    {
        /**
         * Calcula los Strongly Connected Components (SCC)
         */
        visited = new String[Inicio.objUsers.users.length][2];
        stack = new String[Inicio.objUsers.users.length][2];
        
        rels_normal = new String[Inicio.objRels.relations.length][3];
        rels_transpose = new String[Inicio.objRels.relations.length][3];
        
        conjunto = new String[Inicio.objUsers.users.length];
        scc = new String[Inicio.objUsers.users.length][Inicio.objUsers.users.length];
        
        for (int i=0; i<Inicio.objUsers.users.length; i++)
        {
            visited[i][0] = Inicio.objUsers.users[i];
            visited[i][1] = "F";
        }
        for (int i=0; i<Inicio.objRels.relations.length; i++)
        {
            rels_normal[i][0] = Inicio.objRels.relations[i][0];
            rels_normal[i][1] = Inicio.objRels.relations[i][1];
            rels_normal[i][2] = "F";

            rels_transpose[i][0] = Inicio.objRels.relations[i][1];
            rels_transpose[i][1] = Inicio.objRels.relations[i][0];
            rels_transpose[i][2] = "F";
        }
        int indxconjunto = 0;
        for(int i=0; i<visited.length; i++)
        {
            String current = visited[i][0];
            String flag_vis = visited[i][1];
            if(flag_vis == "F")
            {
                visited[i][1] = "T";
                conjunto[indxconjunto] = visited[i][0];
                indxconjunto++;
                String nextnode;
                while((nextnode=getNextNodeNormal(current)) != "NA")
                {
                    markVisited(nextnode);
                    conjunto[indxconjunto] = nextnode;
                    indxconjunto++;
                }
                
            }    
        }
        for(int i=conjunto.length-1; i>-1; i--)
        {
            stack[i][0] = conjunto[i];
            stack[i][1] = "F";
        }
        
        int row = 0;
        for(int i=0; i<stack.length; i++)
        {
            int col = 0;
            String current = stack[i][0];
            String flag_vis = stack[i][1];
            if(flag_vis == "F")
            {
                stack[i][1] = "T";
                scc[row][col] = stack[i][0];
                col++;
                String nextnode;
                while((nextnode=getNextNodeTranspose(current)) != "NA")
                {
                    markStackVisited(nextnode);
                    scc[row][col] = nextnode;
                    col++;
                    current=nextnode;
                }
                row++;
                col = 0;
            }    
        }  
    }
    
    private String getNextNodeNormal(String current)
    {
        /**
         * Ubica el próximo nodo conectado en el DFS1 (Depth First Search);
         */
        String nextnode = "NA";
        for(int j=0; j<rels_normal.length; j++)
        {
            if("F".equals(rels_normal[j][2]))
            {
                if(current.equals(rels_normal[j][0]))
                {
                    rels_normal[j][2] = "T";
                    if(!isVisited(rels_normal[j][1]))
                    {
                        nextnode = rels_normal[j][1];
                        break;
                    }
                }
            }
        }
        return nextnode;
    }

    private Boolean isVisited(String chkuser)
    {
        /**
         * Verifica si el nodo ya está marcado como visitado en el DFS1
         */
        Boolean flag_visited = false;
        for(int k=0; k<visited.length; k++)
        {
            if(chkuser.equals(visited[k][0]))
            {
                if("T".equals(visited[k][1]))
                {
                    flag_visited = true;
                }
                break;
            }
        }
        return flag_visited;
    } 
    
    private void markVisited(String chkuser)
    {
        /**
         * Marca el nodo como visitado dentro del DFS1
         */
        for(int k=0; k<visited.length; k++)
        {
            if(chkuser.equals(visited[k][0]))
            {
                if("F".equals(visited[k][1]))
                {
                    visited[k][1] = "T";
                }
                break;
            }
        }
    }

    private String getNextNodeTranspose(String current)
    {
        /**
         * Busca el próximo nodo en la pila (STACK) en el DFS2 (DFS en el Transpose)
         */
        String nextnode = "NA";
        for(int j=0; j<rels_transpose.length; j++)
        {
            if("F".equals(rels_transpose[j][2]))
            {
                if(current.equals(rels_transpose[j][0]))
                {
                    rels_transpose[j][2] = "T";
                    if(!isStackVisited(rels_transpose[j][1]))
                    {
                        nextnode = rels_transpose[j][1];
                        break;
                    }
                }
            }
        }
        return nextnode;
    }

    private Boolean isStackVisited(String chkuser)
    {
        /**
         * Verifica si el nodo de la pila ya fue visitado
         */
        Boolean flag_visited = false;
        for(int k=0; k<stack.length; k++)
        {
            if(chkuser.equals(stack[k][0]))
            {
                if("T".equals(stack[k][1]))
                {
                    flag_visited = true;
                }
                break;
            }
        }
        return flag_visited;
    } 

    private void markStackVisited(String chkuser)
    {
        /**
         * Marca el nodo en la pila como visitado
         */
        for(int k=0; k<stack.length; k++)
        {
            if(chkuser.equals(stack[k][0]))
            {
                if("F".equals(stack[k][1]))
                {
                    stack[k][1] = "T";
                }
                break;
            }
        }
    }
    
}