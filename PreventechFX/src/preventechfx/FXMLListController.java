/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.bson.Document;

/**
 * FXML Controller class
 *
 * @author mitic
 */
public class FXMLListController implements Initializable {
    
    Stage stage;
    Parent root;
    SubScene sub;
    @FXML
    private TableView<Tuple> table;
    @FXML
    private TableColumn<Tuple, String> tName;
    @FXML
    private TableColumn<Tuple, String> tVia;
    @FXML
    private TableColumn<Tuple, String> tCap;
    @FXML
    private TableColumn<Tuple, String> tCitta;
    @FXML
    private TableColumn<Tuple, String> tProv;
    @FXML
    private TableColumn<Tuple, Double> tLat;
    @FXML
    private TableColumn<Tuple, Double> tLon;
    @FXML
    private TableColumn<Tuple, Double> tApertura;
    @FXML
    private TableColumn<Tuple, Double> tChiusura;
    @FXML
    private TextField tex;
    @FXML
    private Button buttone;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Tuple x = new Tuple();
        tName.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tVia.setCellValueFactory(new PropertyValueFactory<>("via"));
        tCap.setCellValueFactory(new PropertyValueFactory<>("cap"));
        tCitta.setCellValueFactory(new PropertyValueFactory<>("citta"));
        tProv.setCellValueFactory(new PropertyValueFactory<>("prov"));
        tLat.setCellValueFactory(new PropertyValueFactory<>("lat"));
        tLon.setCellValueFactory(new PropertyValueFactory<>("lon"));
        tApertura.setCellValueFactory(new PropertyValueFactory<>("apertura"));
        tChiusura.setCellValueFactory(new PropertyValueFactory<>("chiusura"));
        table.setItems(Prova());

    }
    
        public ObservableList<Tuple> Prova(){
        Director director = new Director();
        TupleBuilder builder = new TupleBuilder();
        List<Document> document = (List<Document>) Database.getCollection().find().into(new ArrayList<>());
        ObservableList<Tuple> tuples = FXCollections.observableArrayList();

        for (Document d : document) {
            director.constructFarmaciaTuple(builder, d);
            tuples.add(builder.getResult());
        }
        return tuples;
        }
        


    @FXML
    private void deleteAction(MouseEvent event) {
        //table.getSelectionModel().getSelectedItem().getNome();
        System.out.println(table.getSelectionModel().getSelectedItem().getNome());

    }

    @FXML
    private void changeText(MouseEvent event) {
        tex.setText(table.getSelectionModel().getSelectedItem().getNome());
    }
    
   
        
        
}
