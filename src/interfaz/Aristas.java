/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;


/**
 *
 * @author Daniela
 */
public class Aristas  ///relaciones entre usuarios
{ 
    public String[][] relations;

    public Aristas() 
    {
        this.relations = new String[0][2];
    }
    public void addrelations (String user, String newrel)
    {
        String[][] addrel = new String[this.relations.length + 1][2];
        for(int i=0; i<this.relations.length; i++)
        {
            addrel[i] = this.relations[i];
        }
        addrel[addrel.length - 1][0]=user;
        addrel[addrel.length - 1][1]=newrel;
        this.relations = addrel;
    }    
    
    public boolean relexist(String user, String rel)
    {
        String[][] allrels = new String[this.relations.length][2];
        for(int i = 0; i<this.relations.length; i++)
        {
            allrels[i] = this.relations[i];
            if(allrels[i][0].equals(user) && allrels[i][1].equals(rel))
            {
                return true;
            }
        }
        return false;
    }
    
    public void delrelbyuser(String deluser)
    {
        int newlen = this.relations.length;
        for (int i = 0; i<this.relations.length; i++)
        {
            if (deluser.equals(this.relations[i][0])||deluser.equals(this.relations[i][1]))
            {
                newlen -= 1;
            }
        }
        String[][] tmprel = new String[newlen][2];
        int indx = 0;
        for(int i=0; i<this.relations.length; i++)
        {
            if(!deluser.equals(this.relations[i][0])&&!deluser.equals(this.relations[i][1]))
            {
                tmprel[indx] = this.relations[i];
                indx++;
            }
        }
        this.relations = tmprel;
    }
    
    public void delrelation(String relation)
    {
        String[][] reltemp = new String[this.relations.length-1][2];
        int indx = 0;
        for(int i=0; i<this.relations.length; i++)
        {
            String Combine = this.relations[i][0] + ", " + this.relations[i][1];
            if(!relation.equals(Combine))
            {
                reltemp[indx] = this.relations[i];
                indx++;
            }
        }
        this.relations = reltemp;
    }
}
