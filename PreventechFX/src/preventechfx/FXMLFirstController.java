/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
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
    
    Stage stage;
    Parent root;
    
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
        // TODO
    }    

    @FXML
    private void handleButtonAction(MouseEvent event) throws IOException {
                   
            root = FXMLLoader.load(getClass().getResource("FXMLMappa.fxml"));
            sub.setRoot(root); 
            sub.setCursor(Cursor.HAND);
    }

    @FXML
    private void viewList(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLList.fxml"));
        sub.setRoot(root);
	sub.setCursor(Cursor.HAND);
    }
    

    @FXML
    private void modList(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLMod.fxml"));
        sub.setRoot(root);
	sub.setCursor(Cursor.HAND);
    }

    
    
}
