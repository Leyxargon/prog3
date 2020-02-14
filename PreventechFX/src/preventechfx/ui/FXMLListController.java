/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.ui;

import java.io.IOException;
import java.net.URL;
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
import preventechfx.builder.*;
import preventechfx.command.*;
import preventechfx.facade.Facade;
import preventechfx.iterator.TupleCollection;
import preventechfx.memento.Action;

/**
 * FXML Controller class
 *
 * @author Attanasio Raffaele  Musella Dario  Venuso Raffaele
 */
public class FXMLListController implements Initializable {
    Facade instance;
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
     * Attraverso il metodo initialize andiamo a valorizzare i campi della nostra tableView, definendo l'elemento della tupla che ogni colonna contiene.
     * Infine con il setItems, passandogli il metodo generateObservavleList, prendiamo i valori dal DB e generiamo la nostra Tabella.
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
        instance = new Facade();
        table.setItems(generateObservableList(instance.getOriginator().getCollection()));
        tServizio.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getServizio()));
        
        undoButton.setDisable(true);
    }
    
    /**
     *Attraverso questa funzione passando in input un oggetto TupleCollection la classe FXCollection genera attraverso il metodo
     *observableList una lista di Tuple che poi verrà utilizzata dagli altri metodi per la visualizzazione della stessa.
     */
    public ObservableList<Tuple> generateObservableList(TupleCollection tuples){
        return FXCollections.observableList(tuples.getCollection());
    }
    
    
   /**
    *La funzione "aggiungiSegnaposto" permette di creare una tupla all interno del nostro DB.
    *Essa opera attraverso un istanza della classe Facade che ritorna un oggetto di tipo TupleCollOriginator e allo stesso tempo,
    *lo imposta come ultima operazione effettuata, successivamente con il getCaretaker.addMemento designa questa operazione come ultimo stato
    *che potra poi essere ripristinato dal Memento.
    *Successivamente con il metodo "execute" della classe "InsertTuplaCommand" la tupla creata viene inserita definitivamente nel DB.
    *Infine attraverso il setItems fa un refresh della tabella aggiungendo anche la tupla appena inserita.
    */
    @FXML
    private void aggiungiSegnaposto(MouseEvent event) throws IOException {
        instance.getOriginator().setLastAction(Action.ADD);
        instance.getCaretaker().addMemento(instance.getOriginator().saveToMemento());
        new InsertTuplaCommand().execute();
        instance.getOriginator().setCollection(Facade.loadDB());
        table.setItems(generateObservableList(instance.getOriginator().getCollection()));
        if (undoButton.isDisabled())
            undoButton.setDisable(false);
    }
    
    


        /**
     *rimuoviSegnaposto opera nella maniera inversa dell inserisci, come primo passo registra nel Memento ,come visto in precedenza,
     *tale operazione che potrà essere annullata successivamente.
     *Effettuando una selezione attraverso la tabella verranno salvati tutti i campi di una tupla, che verranno passati ad un construttore di Tuple
     *ed il risultato viene passato al metodo "execute" della classe RemoveTuplaCommand che si occuperà di eliminare la tupla dal DB.
     *Infine come in precedenza verrà effettuato il refresh della tabella per mostrare la stessa aggiornata.
     */
    @FXML
    private void rimuoviSegnaposto(MouseEvent event) throws IOException {
        instance.getOriginator().setLastAction(Action.DEL);
        instance.getCaretaker().addMemento(instance.getOriginator().saveToMemento());
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
        instance.getOriginator().setCollection(Facade.loadDB());
        table.setItems(generateObservableList(instance.getOriginator().getCollection()));
        if (undoButton.isDisabled())
            undoButton.setDisable(false);
    }
    
    /**
     * Questo metodo ci permette di annullare, attraverso il metodo "execute" dalla classe UndoCommand, l'ultima operazione effettuata 
     * attraverso i get delle classi TupleCollOriginator e TupleCollCaretaker.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void annullaOperazione(MouseEvent event) throws IOException {
        new UndoCommand().execute(instance.getOriginator(), instance.getCaretaker());
        table.setItems(generateObservableList(instance.getOriginator().getCollection()));
        if (instance.getCaretaker().noEdit())
            undoButton.setDisable(true);
    }
    
    
  /**
    * Attraverso la funzione "viewMap" riusciamo ad aprire un nuovo Stage settando come root il nostro FXMLMappa contenente una webView
    *che ci permetterà di controllare le nostre modifiche apportate alla mappa, 
    *e quindi al corretto inserimento o cancellazione di una tupla.
    */
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

