/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import preventechfx.Tupla;

/**
 * FXML Controller class
 *
 * @author raffa
 */
public class FXMLDocumentDelController implements Initializable {

    @FXML
    private Button del;
    @FXML
    private TextField nome;
    @FXML
    private TextField via;
    @FXML
    private TextField latitudine;
    @FXML
    private TextField longitudine;
    @FXML
    private TextField apertura;
    @FXML
    private TextField chiusura;
    
    private Tupla x = new Tupla();
    Stage stage;
    Parent root;
    
    SubScene succ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pulisciTutto(MouseEvent event) {
        nome.clear();
        via.clear();
        longitudine.clear();
        latitudine.clear();
    }

    @FXML
    private void delAction(ActionEvent event) throws IOException {
        x.removeTupla(nome.getText(), Double.parseDouble(latitudine.getText()), Double.parseDouble(longitudine.getText()), via.getText(),Double.parseDouble(apertura.getText()),Double.parseDouble(chiusura.getText()));
        
    }
}
