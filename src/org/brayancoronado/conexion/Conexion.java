package org.brayancoronado.conexion;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    private static Conexion instancia;
    private Connection conexion;
    
    private Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Ejercicoveterinario_in5bv";
            String user = "IN5BV";
            String passaword = "_@miNdAa5V";
            conexion = DriverManager.getConnection(url,user,passaword);
            System.out.println("Conexion Exitosa");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static Conexion getInstancia(){
        if (instancia == null){
            instancia = new Conexion();
          }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
      
}