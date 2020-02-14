package preventechfx.command;

import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import preventechfx.builder.*;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Apre un form che legge in input da tastiera i parametri necessari 
 * alla creazione di una tupla.
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */
public class FXMLInsertTuplaFormController implements Initializable {
    private Label label;
    @FXML
    private TextField nome;
    @FXML
    private TextField via;
    @FXML
    private TextField cap;
    @FXML
    private TextField citta;
    @FXML
    private TextField prov;
    @FXML
    private TextField longitudine;
    @FXML
    private TextField latitudine;
    @FXML
    private TextField apertura;
    @FXML
    private TextField chiusura;
    
    Stage stage;
    Parent root;
    private Button inviadati;
    SubScene succ;

    private Button listView;
    @FXML
    private Button del;
    SubScene sub;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    /**
     * Metodo collegato al pulsante per l'invio dei dati, che quindi
     * attraverso il director genera una tupla a partire dai singoli dati.
     * @param   event   parametro che prende in input il click del mouse
     */
    @FXML
    private void insertTupla(ActionEvent event) throws IOException {
        Director director = new Director();
        TupleBuilder builder = new TupleBuilder();
        director.constructTupleFromData(builder, nome.getText(), Double.parseDouble(latitudine.getText()), Double.parseDouble(longitudine.getText()), via.getText(), cap.getText(), citta.getText(), prov.getText(), Double.parseDouble(apertura.getText()),Double.parseDouble(chiusura.getText()));
        builder.getResult().inserisciInDB();
    }

    /**
     * Questo evento è anch'esso collegato all'invio dei dati e pulisce
     * i campi successivamente al click.
     * @param   event   parametro che prende in input il click del mouse
     */
    @FXML
    private void pulisciTutto(MouseEvent event) {
        nome.clear();
        via.clear();
        cap.clear();
        citta.clear();
        prov.clear();
        longitudine.clear();
        latitudine.clear();
        apertura.clear();
        chiusura.clear();
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
