/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

/**
 *
 * @author Daniela
 */
public class Grafo {

    /**
     * @param args the command line arguments
     */
    public static String strappfile = System.getProperty("java.io.tmpdir") + "grafo.txt";
    public static File appfile = new File(strappfile);
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        String lastcontent = null;
        
        if(appfile.exists())
        {
            lastcontent = ReadContent(appfile);
        }

        principal f = new principal();
        f.setVisible(true);
        f.TextoSel.setText(lastcontent);
    }
    public static String ReadContent(File txt)
    {
        String content = "";
        String line;
        try
        {
            FileReader r = new FileReader(txt);
            BufferedReader br = new BufferedReader(r);
            while ((line = br.readLine()) != null)
            {
                content += line + "\r\n";
            }
            r.close();
        }
        catch(Exception ex)
        {
            content = null;
        }
        return content;
    }
    public static Boolean WriteContent(String LastContent, File txt )
    {
        Boolean val = false;
        try
        {
            FileWriter w = new FileWriter(txt);
            w.write(LastContent);
            w.close();
            val = true;
        }
        catch(Exception ex)
        {
            val = false;
        }
        return val;
    }
}