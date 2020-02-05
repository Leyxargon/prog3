/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mitic
 */
public class FXMLListController implements Initializable {
    ObservableList list=FXCollections.observableArrayList();
    @FXML
    private ListView<String> listaNegozi;
    
    Stage stage;
    Parent root;
    SubScene sub;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    
    
        private void loadData(){
        list.removeAll(list);
        Tupla lista = new Tupla();
        list.addAll(lista.castLista(lista.getFoundDocument()));
        listaNegozi.getItems().addAll(list);
        }    
}
