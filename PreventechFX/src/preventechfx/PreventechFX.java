/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;


import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import static javafx.scene.Cursor.DEFAULT;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import org.bson.Document;

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
        Director director = new Director();
        TupleBuilder builder = new TupleBuilder();
        List<Document> document = (List<Document>) Database.getCollection().find().into(new ArrayList<>());
        director.constructFarmaciaTuple(builder, document.get(0));
        Tuple tuple = builder.getResult();
        System.out.println(document);
        launch(args);
        
    }
    
}
