/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author info
 */
public class FXMLDocumentController implements Initializable {
    private Tupla x = new Tupla();
    
    private Label label;
    @FXML
    private Button button;
    @FXML
    private TextField nome;
    @FXML
    private TextField via;
    @FXML
    private TextField longitudine;
    @FXML
    private TextField latitudine;
    
  /* private String nome_farmacia = nome.getText();
   private String via_farmacia = via.getText();
   private String lat = latitudine.getText();
   private String longitude = longitudine.getText();
   */
   
  
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        x.insertTupla(nome.getText(), Double.parseDouble(latitudine.getText()), Double.parseDouble(longitudine.getText()), via.getText());
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
