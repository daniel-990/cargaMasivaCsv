package org.example;

//librerias externas
import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;
import org.example.conexion.Conector;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main {

    public static Conector conector = new Conector();
    public static Connection con = conector.getConnection();
    public static String Sql;
    public static PreparedStatement ps;
    public static void main(String[] args) throws FileNotFoundException {
        try {

            CsvReader datos = new CsvReader("C:\\Users\\XorroPerro\\Documents\\proyectos_Java\\leerArchivos\\excel\\data8.csv");

            datos.readHeaders();
            while (datos.readRecord())
            {
                try{
                    Sql = "INSERT INTO radicar (uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,diez,once,doce,trece,catorce,quince,dieciseis,diecisiete,dieciocho,diecinuve) VALUES (" +
                            "'"+datos.get(0)+"'," +
                            "'"+datos.get(1)+"'," +
                            "'"+datos.get(2)+"'," +
                            "'"+datos.get(3)+"'," +
                            "'"+datos.get(4)+"'," +
                            "'"+datos.get(5)+"'," +
                            "'"+datos.get(6)+"'," +
                            "'"+datos.get(7)+"'," +
                            "'"+datos.get(8)+"'," +
                            "'"+datos.get(8)+"'," +
                            "'"+datos.get(10)+"'," +
                            "'"+datos.get(11)+"'," +
                            "'"+datos.get(12)+"'," +
                            "'"+datos.get(13)+"'," +
                            "'"+datos.get(14)+"'," +
                            "'"+datos.get(15)+"'," +
                            "'"+datos.get(16)+"'," +
                            "'"+datos.get(17)+"'," +
                            "'"+datos.get(18)+"')";
                    ps = con.prepareStatement(Sql);

                    if(datos.get(0).equals("1152168563") || datos.get(0).equals("1152171169")){
                        System.out.println("el id radico "+datos.get(0)+" ya existe en base de datos");
                    }else {
                        ps.executeUpdate();
                        System.out.println("se imprime dato: "+datos.get(0));
                    }
                }catch(Exception e){
                    System.out.println("no se logro crear la carga de datos");
                }
            }
            datos.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}