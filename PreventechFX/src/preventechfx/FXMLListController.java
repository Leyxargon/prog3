/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.bson.Document;

/**
 * FXML Controller class
 *
 * @author mitic
 */
public class FXMLListController implements Initializable {
    ObservableList list=FXCollections.observableArrayList();
    @FXML
    private ListView<String> listaNegozi;
    @FXML
    private Button backToMenu;
    
    @FXML
    Stage stage;
    Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    

    @FXML
    private void backAction(MouseEvent event) throws IOException {
        stage = (Stage) backToMenu.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
    private void loadData(){
        list.removeAll(list);
        Tupla lista = new Tupla();
        list.addAll(lista.castLista(lista.getFoundDocument()));
        listaNegozi.getItems().addAll(list);
    }
    
}
