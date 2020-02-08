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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author raffa
 */
public class FXMLModController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    Stage stage;
    Parent root;
    @FXML
    SubScene sub;
    @FXML
    private Button add;
    @FXML
    private Button canc;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        @FXML
    private void Insert(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        sub.setRoot(root);
	sub.setCursor(Cursor.HAND);
    }

    @FXML
    private void Delete(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLDocumentDel.fxml"));
        sub.setRoot(root);
	sub.setCursor(Cursor.HAND);
    }
   
   /* public void Success() throws IOException{
       root= FXMLLoader.load(getClass().getResource("FXMLSuccess.fxml"));
        sub.setRoot(root);
    }*/
    
}
