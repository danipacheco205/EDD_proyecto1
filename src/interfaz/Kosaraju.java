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
    }
    
    public String getNextNodeNormal(String current)
    {
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

    public Boolean isVisited(String chkuser)
    {
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
    
    public void markVisited(String chkuser)
    {
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
}