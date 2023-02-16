package org.example.conexion;

import org.example.models.ModelConector;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conector {
    public static final ModelConector DbMysql = new ModelConector();

    public Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(DbMysql.getURL(),DbMysql.getUSER(), DbMysql.getPASS());
            System.out.println("se conecto a base de datos");
        }catch(Exception e){
            System.out.println("no hubo conexion a la base de datos"+e.getMessage());
        }
        return con;
    }

}
