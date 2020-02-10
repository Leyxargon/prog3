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
    
    @Override
    public void start(Stage stage) throws Exception {
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
        /*
        Director director = new Director();
        TupleBuilder builder = new TupleBuilder();
        List<Document> document = (List<Document>) Database.getCollection().find().into(new ArrayList<>());
        TupleCollection tuplec = new TupleCollection();
        for (Document d : document) {
            director.constructFarmaciaTuple(builder, d);
            tuplec.add(builder.getResult());
        }
        for (Iterator iter = tuplec.getIterator(); iter.hasNext();)
            System.out.println(iter.next());*/
        launch(args);
        
    }
    
}
