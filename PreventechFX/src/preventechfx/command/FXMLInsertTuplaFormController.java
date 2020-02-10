/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author info
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
        // TODO
    }
    
    @FXML
    private void insertTupla(ActionEvent event) throws IOException {
        Director director = new Director();
        TupleBuilder builder = new TupleBuilder();
        director.constructTupleFromData(builder, nome.getText(), Double.parseDouble(latitudine.getText()), Double.parseDouble(longitudine.getText()), via.getText(), cap.getText(), citta.getText(), prov.getText(), Double.parseDouble(apertura.getText()),Double.parseDouble(chiusura.getText()));
        builder.getResult().inserisciInDB();
    }

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
