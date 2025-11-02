/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;


/**
 *
 * @author Daniela
 */
public class Aristas { ///relaciones entre usuarios

        private String usercontent;
        private String relacontent;

    public Aristas() {
        this.usercontent = "";
    }
    
    public static String[][] getRelationships(String lastContent)
    {
        String[][] rels = {};
        int maxColumns = 0;
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
                        int Columns = 1;
                        for(int j=1;j<val.length;j++)
                        {
                            val[j] = val[j].trim();
                            if("@".equals(val[j].substring(0, 1))) Columns++; 
                        }
                        if(Columns > maxColumns) maxColumns = Columns;
                        String[] val_res = new String[Columns];
                        val_res[0] = val[0];
                        int indxColumn = 0;
                        for(int j=1;j<val.length;j++)
                        {
                            val[j] = val[j].trim();
                            if("@".equals(val[j].substring(0, 1)))
                            {
                                indxColumn++;
                                val_res[indxColumn] = val[j]; 
                            }
                        }
                        String[][] addrels = new String[rels.length+1][maxColumns];
                        for(int j=0; j<rels.length; j++)
                        {
                            addrels[j] = rels[j];
                        }
                        for(int j=0; j< val_res.length; j++)
                        {
                            addrels[addrels.length-1][j] = val_res[j];
                        }
                        rels = addrels;
                    }
                }
            }
        }
        return rels;
    }
    
    

        
        
        
}
