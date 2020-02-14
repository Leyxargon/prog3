/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import static javafx.scene.Cursor.DEFAULT;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 *
 * @author info
 */
public class PreventechFX extends Application {
   /**
    * @param stage
    * Questo metodo inizializza la nostra JavaFx definendo la pagina iniziale e le varie impostazioni grafiche,
    * quali l'icona e il logo.
    */ 
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLList.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.getIcons().add(new Image("img/favicon.png"));
        stage.setTitle("PrevenTech");
        stage.show();
        scene.setCursor(DEFAULT);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
