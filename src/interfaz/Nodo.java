/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

/**
 *
 * @author Daniela
 */
public class Nodo /**Usuarios*/
{  
    
    public String[] users;

    public Nodo() 
    {
        /*Constructor de la clase*/
        this.users = new String[0];  /*Crea un arreglo de Strings vacío*/
    }
        
    public void addusers (String newuser)
    {
        /**
         * Agrega un nuevo usuario (newuser) al arreglo de Strings users
         * Crea un arreglo temporal llamado adduser con un tamaño de 1 posición más y realiza una copia del arreglo users
         * Agrega el nuevo usuario a la última posición siendo el tamaño menos un índice
         * Establece que el arreglo users es el arreglo adduser
         */
        String[] adduser = new String[this.users.length + 1];
        for (int i=0; i<this.users.length; i++)
        {
            adduser[i] = this.users[i];
        }
        adduser[adduser.length - 1]=newuser;
        this.users = adduser;
    }
    
    public boolean userexists(String user)
    {
        /**
         * Verifica si ya existe el usuario que se desea agregar (user)
         * Crea un arreglo temporal llamado allusers con el mismo tamaño del arreglo de la clase users
         * Itera sobre los valores de allusers y lee la información que contiene cada posición del arreglo temporal
         * Retorna true si encuentra un usuario con el mismo nombre que el que se quiere agregar
         * Retorna false si no encuentra a ningún usuario con ese nombre
         */
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
        /**
         * Elimina el usuario solicitado del arreglo (deluser)
         * Crea un nuevo arreglo temporal llamado tmpuser donde el tamaño de este arreglo es el tamaño del arreglo de la clase usuarios menos un índice 
         * Crea una variable numerica llamada indx que se le asigna el valor de 0
         * Itera sobre todos los valores del arreglo users 
         * Si el valor del arreglo users es distinto de deluser, rellena el arreglo en ese índice con la misma información, además de que indx aumenta en uno
         * Si coincide no lo agrega al arreglo y continua con la iteración
         * Establece que el arreglo de la clase users es igual a tmpuser
         */
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
