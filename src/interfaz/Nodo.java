/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

/**
 *
 * @author Daniela
 */
public class Nodo 
{  ///Usuarios
    
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
}
