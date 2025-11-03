/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz;

/**
 * Importa las librerías para leer y sobreescribir en el archivo txt
*/
import java.io.File;        
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;

/**
 * @author Daniela
 * Esta clase 
 */
public class Inicio {    

    /**
     */
    public static String strappfile = System.getProperty("java.io.tmpdir") + "grafo.txt";
    public static File appfile = new File(strappfile);
    public static Nodo objUsers = new Nodo();
    public static Aristas objRels = new Aristas();
    public static principal f = new principal();
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        String lastcontent = null;
        
        if(appfile.exists())
        {
            lastcontent = ReadContent(appfile);
        }
        else
        {
            lastcontent = cargadefault();
            WriteContent(lastcontent, appfile);
            
        }

        getUsers(lastcontent);
        getRelationships(lastcontent);
        
        String Result;
        f.setVisible(true);
        Result = refreshUsers();
        f.txtusr.setText(Result);
        Result = refreshRels();
        f.txtrel.setText(Result);
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
    
    public static String cargadefault()
    {
        String newcontent = "usuarios\r\n@pepe\r\n@mazinger\r\n";
        newcontent += "@juanc\r\n@xoxojaime\r\n@tuqui33\r\n";
        newcontent += "@sancho23\r\n@terciopelo\r\n@caribedoble\r\n";
        newcontent += "@africa\r\n@totalfree\r\n@radiogaga\r\n";       
        newcontent += "@cipriano\r\n@newageforever\r\n";      
        
        newcontent += "relaciones\r\n@pepe, @mazinger\r\n@mazinger, @juanc\r\n";
        newcontent += "@mazinger, @tuqui33\r\n@tuqui33, @xoxojaime\r\n@xoxojaime, @pepe\r\n";
        newcontent += "@juanc, @sancho23\r\n@sancho23, @mazinger\r\n@sancho23, @terciopelo\r\n";
        newcontent += "@terciopelo, @juanc\r\n@terciopelo, @newageforever\r\n@terciopelo, @caribedoble\r\n";
        newcontent += "@caribedoble, @africa\r\n@africa, @cipriano\r\n@cipriano, @totalfree\r\n";
        newcontent += "@cipriano, @radiogaga\r\n@totalfree, @africa\r\n@totalfree, @radiogaga\r\n@radiogaga, @caribedoble\r\n";
        
        return newcontent;
    }
    
    public static void getUsers(String lastContent)
    {
        String[] info = lastContent.toLowerCase().split("relaciones");
        String val = info[0].replace("usuarios\r\n", "");
        String[] tmp_users = val.split("\r\n");
        
        for(int i=0;i<tmp_users.length; i++)
        {
            tmp_users[i] = tmp_users[i].trim();
            if(tmp_users[i].length()>0)
            {
                if("@".equals(tmp_users[i].substring(0, 1)))
                {
                    objUsers.addusers(tmp_users[i]);
                }
            }
        }
    }
    
    public static void getRelationships(String lastContent)
    {
        String[][] rels = {};
        if(lastContent.contains("relaciones"))
        {
            String[] info = lastContent.toLowerCase().split("relaciones");
            String[] tmp_rels = info[1].split("\r\n");
            for(int i=0;i<tmp_rels.length; i++)
            {
                tmp_rels[i] = tmp_rels[i].trim();
                if(tmp_rels[i].length()>0)
                {
                    if("@".equals(tmp_rels[i].substring(0, 1)))
                    {
                        String[] val = tmp_rels[i].split(",");
                        String[] val_res = new String[2];
                        if(val.length == 2)
                        {
                            if("@".equals(val[1].trim().substring(0, 1)))
                            {
                                objRels.addrelations(val[0].trim(), val[1].trim());
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static String refreshUsers()
    {
        String texto = "";
        for(int i=0; i<objUsers.users.length; i++)
        {
            texto += objUsers.users[i] + "\r\n";
        }
        return texto;
    }
    public static String refreshRels()
    {
        String texto = "";
        for(int i = 0; i<objRels.relations.length; i++)
        {
            texto += objRels.relations[i][0]+","+objRels.relations[i][1]+"\r\n";
        }
        return texto;
    }
}