
package org.brayancoronado.system;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;
    
    
    @Override
    public void start(Stage stage) throws Exception {
        try{
            primaryStage = stage;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/brayancoronado/views/VistaLogin.fxml"));
            
            Scene sc = new Scene(loader.load());
            
            primaryStage.setScene(sc);
            primaryStage.show();
        }catch (Exception e){
            System.out.println("Error al cargar la vista: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static Stage getPrimaryStage(){
        return primaryStage;
    }
    
    public static void main(String[] args) {
        launch(args);
    } 
}