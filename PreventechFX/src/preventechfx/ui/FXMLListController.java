/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.bson.Document;
import preventechfx.builder.*;
import preventechfx.command.*;
import preventechfx.iterator.TupleCollection;
import preventechfx.memento.Action;
import preventechfx.memento.TupleCollCaretaker;
import preventechfx.memento.TupleCollOriginator;
import preventechfx.singleton.*;

/**
 * FXML Controller class
 *
 * @author mitic
 */
public class FXMLListController implements Initializable {
    TupleCollOriginator tupleCollOriginator;
    TupleCollCaretaker tupleCollCaretaker;
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
    private Button addButton;
    @FXML
    private Button delButton;
    @FXML
    private Button viewMap;
    @FXML
    private Button undoButton;
    @FXML
    private TableColumn<Tuple, String> tServizio;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tName.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tVia.setCellValueFactory(new PropertyValueFactory<>("via"));
        tCap.setCellValueFactory(new PropertyValueFactory<>("cap"));
        tCitta.setCellValueFactory(new PropertyValueFactory<>("citta"));
        tProv.setCellValueFactory(new PropertyValueFactory<>("prov"));
        tLat.setCellValueFactory(new PropertyValueFactory<>("lat"));
        tLon.setCellValueFactory(new PropertyValueFactory<>("lon"));
        tApertura.setCellValueFactory(new PropertyValueFactory<>("apertura"));
        tChiusura.setCellValueFactory(new PropertyValueFactory<>("chiusura"));
        tServizio.setCellValueFactory(new PropertyValueFactory<>("servizio"));
        tupleCollOriginator = new TupleCollOriginator();
        tupleCollOriginator.setCollection(loadDB());
        tupleCollCaretaker = new TupleCollCaretaker();
        table.setItems(generateObservableList(tupleCollOriginator.getCollection()));
        tServizio.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getServizio()));
        
        undoButton.setDisable(true);
    }
    
    public TupleCollection loadDB() {
        Director director = new Director();
        TupleBuilder builder = new TupleBuilder();
        List<Document> document = (List<Document>) Database.getCollection().find().into(new ArrayList<>());
        TupleCollection tuples = new TupleCollection();

        for (Document d : document) {
            director.constructTupleFromDocument(builder, d);
            tuples.add(builder.getResult());
        }
        
        return tuples;
    }
    
    public ObservableList<Tuple> generateObservableList(TupleCollection tuples){
        return FXCollections.observableList(tuples.getCollection());
    }
    
    @FXML
    private void aggiungiSegnaposto(MouseEvent event) throws IOException {
        tupleCollOriginator.setLastAction(Action.ADD);
        tupleCollCaretaker.addMemento(tupleCollOriginator.saveToMemento());
        new InsertTuplaCommand().execute();
        tupleCollOriginator.setCollection(loadDB());
        table.setItems(generateObservableList(tupleCollOriginator.getCollection()));
        if (undoButton.isDisabled())
            undoButton.setDisable(false);
    }
    
    @FXML
    private void rimuoviSegnaposto(MouseEvent event) throws IOException {
        tupleCollOriginator.setLastAction(Action.DEL);
        tupleCollCaretaker.addMemento(tupleCollOriginator.saveToMemento());
        Director director = new Director();
        TupleBuilder builder = new TupleBuilder();
        String nome = table.getSelectionModel().getSelectedItem().getNome();
        double lat = table.getSelectionModel().getSelectedItem().getLat();
        double lon = table.getSelectionModel().getSelectedItem().getLon();
        String via = table.getSelectionModel().getSelectedItem().getVia();
        String cap = table.getSelectionModel().getSelectedItem().getCap();
        String citta = table.getSelectionModel().getSelectedItem().getCitta();
        String prov = table.getSelectionModel().getSelectedItem().getProv();
        double apertura = table.getSelectionModel().getSelectedItem().getApertura();
        double chiusura = table.getSelectionModel().getSelectedItem().getChiusura();
        director.constructTupleFromData(builder, nome, lat, lon, via, cap, citta, prov, apertura, chiusura);
        new RemoveTuplaCommand().execute(builder.getResult());
        tupleCollOriginator.setCollection(loadDB());
        table.setItems(generateObservableList(tupleCollOriginator.getCollection()));
        if (undoButton.isDisabled())
            undoButton.setDisable(false);
    }
    
    @FXML
    private void annullaOperazione(MouseEvent event) throws IOException {
        new UndoCommand().execute(tupleCollOriginator, tupleCollCaretaker);
        table.setItems(generateObservableList(tupleCollOriginator.getCollection()));
        if (tupleCollCaretaker.noEdit())
            undoButton.setDisable(true);
    }

    @FXML
    private void viewMap(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLMappa.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.getIcons().add(new Image("img/favicon.png"));
        stage.setOpacity(1);
        stage.setTitle("Mappa");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
    }
}

