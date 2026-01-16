package org.brayancoronado.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import org.brayancoronado.system.Main;


public class HomeController implements Initializable {

        @FXML
        private void btnLogout(){
            cambioEscena();
        }
        
        @FXML
        private void btnUsuarios(){
            cambioEscenaUsuario();
        }
        
        @FXML
        private void btnMascotas(){
             cambioEscenaMascota();           
        }
        
        @FXML
        private void btnProductos(){
            cambioEscenaProducto();            
        }
        
        private void cambioEscena(){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/org/brayancoronado/views/VistaLogin.fxml"));
                Main.getPrimaryStage().setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
                alerta(Alert.AlertType.ERROR, "Error", "No se pudo abrir el Login principal.");
            }
        }
        
        private void cambioEscenaUsuario(){
             try {
                 Parent root = FXMLLoader.load(getClass().getResource("/org/brayancoronado/views/VistaUsuario.fxml"));
                 Main.getPrimaryStage().setScene(new Scene(root));
            } catch (Exception e) {
                 e.printStackTrace();
                 alerta(Alert.AlertType.ERROR, "Error", "No se pudo abrir el Login principal.");
            }
        }
        
         private void cambioEscenaMascota(){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/org/brayancoronado/views/VistaMascota.fxml"));
                Main.getPrimaryStage().setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
                alerta(Alert.AlertType.ERROR, "Error", "No se pudo abrir el Login principal.");
            }
        }
        
          private void cambioEscenaProducto(){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/org/brayancoronado/views/VistaProducto.fxml"));
                Main.getPrimaryStage().setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
                alerta(Alert.AlertType.ERROR, "Error", "No se pudo abrir el Login principal.");
            }
        }
    
     private void alerta(Alert.AlertType tipo, String titulo, String msg){
        Alert a  = new Alert(tipo);
        a.setTitle(titulo);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
}