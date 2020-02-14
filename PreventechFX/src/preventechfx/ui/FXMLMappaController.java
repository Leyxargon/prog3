/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author raffa
 */
public class FXMLMappaController implements Initializable {

    @FXML
    private WebView map;

    /**
     * Questo metodo permette di aprire nella nostra webWiew la mappa generata dalla servlet 
     * visualizzata anche dalla webApp sviluppata nel progetto di Tecnologie Web
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        WebEngine engine = map.getEngine();
        engine.load("http://localhost:8180/Preventech/MapServlet");
    }    
    
}
