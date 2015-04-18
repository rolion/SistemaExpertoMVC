package sistemaexperto.util;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import sistemaexperto.Entidad.BC;
import sistemaexperto.Entidad.Regla;
import sistemaexperto.Entidad.TablaVal;
import sistemaexperto.Entidad.TablaVar;
import sistemaexperto.Entidad.Tupla;


/**
 *
 * @author Lion
 */
public class FileManager {
    private static final String path=System.getProperty("user.dir")+"\\archivos";
    private final String nameFile="usuario.txt";
    private static File file=new File(System.getProperty("user.dir")+"\\archivos");
    private static Writer fileWriter;
    private static BufferedWriter bufferedWriter;
    private static Gson gson=new Gson();
        
    public static boolean writeToFile(Object object,String mfile){
        boolean rslt=false;
        file.mkdirs();
        System.out.print("Direccion archivo------>>>>>>"+file.getAbsolutePath()+"\n");
        if(!existObj(object, mfile)){
            if(file!=null && file.exists() ){
                try(PrintWriter out = new PrintWriter(
                        new BufferedWriter(new FileWriter(
                                System.getProperty("user.dir")+"\\archivos"+"\\"+mfile, true)))) {

                        out.println(gson.toJson(object));

                }catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return rslt;
    }
    public static boolean writeListToFile(List lobject, String mfile){
        boolean rstl=false;
        file.mkdirs();
        if(lobject!=null  && mfile!=null && mfile.length()>0  ){
            try(PrintWriter out = new PrintWriter(
                    new BufferedWriter(new FileWriter(
                            mfile, false)))) {
                for (Object lobject1 : lobject) {
                    out.println(gson.toJson(lobject1));
                }

            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return rstl;
    }
    public static boolean existObj(Object o, String mfile){
        boolean rslt=false;
        try(BufferedReader br = new BufferedReader(new FileReader(path+"\\"+mfile))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
               
                while (line != null) {
                    try{
                        Object mObject= gson.fromJson(line,o.getClass());
                        if(o.equals(mObject))
                            rslt=true;
                    }catch(JsonSyntaxException jse){
                        System.out.println("No es su tipo");
                    }
                    if(rslt==false)
                        line = br.readLine();
                    else
                        line=null;
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        
        return rslt;
    }
    public static List<Object> getAllObject(String mfile) {
        List rslt=null;
       
         if(mfile!=null && mfile.length()>0 ){
            try(BufferedReader br = new BufferedReader(new FileReader(mfile))) {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                rslt= new ArrayList<>();
                for(int i=0;i<3;i++){
                    if(line!=null){
                        switch(i){
                            case 0:
                                List<String> alString=gson.fromJson(line, 
                                        new TypeToken<List<String>>(){}.getType());
                                GV.tablaVal=new TablaVal(alString);
                                break;
                            case 1:
                                List<Tupla> alTupla=gson.fromJson(line, 
                                        new TypeToken<List<Tupla>>(){}.getType());
                                GV.tablaVar=new TablaVar(alTupla);
                                break;
                            case 2:
                                List<Regla> alRegla =gson.fromJson(line, 
                                        new TypeToken<List<Regla>>(){}.getType());
                                GV.tableBC=new BC(alRegla);
                                break;
                        }
                    }
                    line = br.readLine();
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
         }
        return rslt;
    }
    private void validarFile(){
        if(!file.exists())
            file.mkdirs();
    
    }
    
    
}
