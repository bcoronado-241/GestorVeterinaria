package org.brayancoronado.controllers;

import java.sql.CallableStatement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.brayancoronado.conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.brayancoronado.system.Main;



public class LoginController implements Initializable {

    @FXML
    private TextField txtHandle; 
    @FXML
    private PasswordField psDPI;
    
   @FXML
    private void botonLogin(){
        String handle = txtHandle.getText().trim();
        String dpi = psDPI.getText().trim();
        if (handle.isEmpty() || dpi.isEmpty()){
            alerta(Alert.AlertType.WARNING, "Campos Vacios", "Ingrese handle y dpi.");
            return;
        }
        try {
            Connection cn = Conexion.getInstancia().getConexion();
            try (CallableStatement cs = cn.prepareCall("{call sp_login(?,?)}")){
                cs.setString(1, handle);
                cs.setString(2, dpi);
                try (ResultSet rs = cs.executeQuery()){
                    if(rs.next()){
                        alerta(Alert.AlertType.CONFIRMATION, "Bienvenido", "Ingreso Exitoso");
                        cambioEscena();
                    } else {
                        alerta(Alert.AlertType.ERROR, "Error", "Credenciales incorrectas");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            alerta(Alert.AlertType.ERROR, "Error", "No se puede conectar a la DB.");
        }
    }
    
    private void cambioEscena(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/org/brayancoronado/views/VistaHome.fxml"));
            Main.getPrimaryStage().setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
            alerta(Alert.AlertType.ERROR, "Error", "No se pudo abrir el menú principal.");
        }
    }
 
    private void alerta(Alert.AlertType tipo, String titulo, String msg){
        Alert a  = new Alert(tipo);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
    
 /*   @FXML
    private void botonLogin(){
        String handle = txtHandle.getText().trim();
        String dpi = psDPI.getText().trim();
        
        if (handle.isEmpty() || dpi.isEmpty() ){
            alerta(Alert.AlertType.WARNING,"Campos Vacios", "Ingrese handle  y DPI");
            return;
        }
        
        try{
            Connection cn = Conexion.getInstancia().getConexion();
            try(CallableStatement cs = cn.prepareCall("{call sp_validarLogin(?,?)}")){
                cs.setString(1,handle);
                cs.setString(2,dpi);
                try(ResultSet rs = cs.executeQuery()){
                    if(rs.next()){
                        alerta(Alert.AlertType.CONFIRMATION,"Bienvenido","Ingreso exitoso");
                    }else{
                        alerta(Alert.AlertType.ERROR,"Error","Credenciales incorrectas");
                    }
            }catch(Exception e){
            }
            }catch(Exception e){
            }    
        }catch(Exception e){
            e.printStackTrace();
            alerta(Alert.AlertType.ERROR,"Error","No se puede conectar a DB");
        }
           
    }
        
    private void cambioEscena(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/org/brayancoronado/views/VistaHome.fxml"));
            Main.getPrimaryStage().setScene(new Scene(root));
        }catch(Exception e){
            e.printStackTrace();
            alerta(Alert.AlertType.ERROR,"Error","No se puedo subir al menu principal");
        }
    }
    
    private void alerta(Alert.AlertType tipo, String titulo, String msg){
        Alert a = new Alert(tipo);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
    */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
}
