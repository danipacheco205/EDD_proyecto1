/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

/**
 *
 * @author Daniela
 */
public class Nodo ///Usuarios
{  
    
    public String[] users;

    public Nodo() 
    {
        this.users = new String[0];
    }
        
    public void addusers (String newuser)
    {
        String[] adduser = new String[this.users.length + 1];
        for(int i=0; i<this.users.length; i++)
        {
            adduser[i] = this.users[i];
        }
        adduser[adduser.length - 1]=newuser;
        this.users = adduser;
    }
    
    public boolean userexists(String user)
    {
      String[] allusers = new String[this.users.length];
        for(int i=0; i<this.users.length; i++)
        {
            allusers[i] = this.users[i];
            if (allusers[i].equals(user))
            {
                return true;
            }
        }  
        return false;
    }
    
    public void deleteuser(String deluser)
    {
        String[] tmpuser = new String[this.users.length - 1];
        int indx = 0;
        for(int i=0; i<this.users.length; i++)
        {
            if(!deluser.equals(this.users[i]))
            {
                tmpuser[indx] = this.users[i];
                indx++;
            }
        }
        this.users = tmpuser;
    }
}
