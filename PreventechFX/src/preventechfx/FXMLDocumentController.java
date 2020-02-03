/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author info
 */
public class FXMLDocumentController implements Initializable {
    private Tupla x = new Tupla();
    
    private Label label;
    @FXML
    private TextField nome;
    @FXML
    private TextField via;
    @FXML
    private TextField longitudine;
    @FXML
    private TextField latitudine;
    
    Stage stage;
    Parent root;
    @FXML
    private Button bt1, bt2;
    
  /* private String nome_farmacia = nome.getText();
   private String via_farmacia = via.getText();
   private String lat = latitudine.getText();
   private String longitude = longitudine.getText();
   */
    @FXML
    private Button listView;

   
  
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == bt1) {
            x.insertTupla(nome.getText(), Double.parseDouble(latitudine.getText()), Double.parseDouble(longitudine.getText()), via.getText());
            stage = (Stage) bt1.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLSuccess.fxml"));
        } else if (event.getSource() == bt2) {
            stage = (Stage) bt2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FXMLMappa.fxml"));
        }
            
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    

    
    
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
    private void viewList(MouseEvent event) throws IOException {

        stage = (Stage) listView.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLList.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    
}
