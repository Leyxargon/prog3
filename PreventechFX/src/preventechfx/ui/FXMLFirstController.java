/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author raffa
 */
public class FXMLFirstController implements Initializable {

    @FXML
    private Button mappa;
    @FXML
    private Button lista;
    
    Stage stage = new Stage();
    Parent root;
    Scene scene;
    
    BorderPane border = new BorderPane();
    @FXML
    SubScene sub;
    @FXML
    private Button mod;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*
        try {
            root = FXMLLoader.load(getClass().getResource("FXMLList.fxml"));
            sub.setRoot(root); 
            sub.setCursor(Cursor.DEFAULT);
        } catch (IOException ex) {
            Logger.getLogger(FXMLFirstController.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }    

    @FXML
    private void viewMap(MouseEvent event) throws IOException {      
        root = FXMLLoader.load(getClass().getResource("FXMLMappa.fxml"));
        sub.setRoot(root); 
        sub.setCursor(Cursor.DEFAULT);
    }

    @FXML
    private void viewList(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLList.fxml"));
        sub.setRoot(root);
	sub.setCursor(Cursor.DEFAULT);
    }
    

    @FXML
    /* tasto inutile */
    private void modList(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLMod.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(root, 450, 450));
        stage.showAndWait();
    }

    
    
}
