/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;


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
    
    @Override
    public void start(Stage stage) throws Exception {
       //Parent root = FXMLLoader.load(getClass().getResource("FXMLMappa.fxml"));
       Parent root = FXMLLoader.load(getClass().getResource("FXMLFirst.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.getIcons().add(new Image("img/favicon.png"));
        stage.setTitle("Preventech");
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
