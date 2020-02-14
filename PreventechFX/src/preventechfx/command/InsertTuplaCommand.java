/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.command;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 *Questa classe viene richiamata alla richiesta da parte dell'utente di inserire
 * una tupla.
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

public class InsertTuplaCommand extends AbstractCommand<Boolean> {
    public InsertTuplaCommand() {
        this(null);
    }
   
    public InsertTuplaCommand(Window window) {
        super(window);
    }

    /**
     * Questo execute va a cambiare la scena aprendo il form di inserimento tupla.
     */
    @Override
    public Optional<Boolean> execute() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLInsertTuplaForm.fxml"));
        Parent root;
        try {
            root = fxmlLoader.load();
        } catch (IOException ex) {
            Logger.getLogger(InsertTuplaCommand.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);
        stage.setTitle("Aggiungi segnaposto");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.showAndWait();
        return null;
    }
    


}
