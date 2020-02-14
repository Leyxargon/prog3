/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.command;

import java.util.Optional;
import javafx.stage.Window;
import preventechfx.builder.Tuple;

/**
 * Questa classe viene richiamata alla richiesta dell'utente di eliminare una tupla.
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */
public class RemoveTuplaCommand extends AbstractCommand<Tuple> {
    public RemoveTuplaCommand() {
        this(null);
    }
   
    public RemoveTuplaCommand(Window window) {
        super(window);
    }
    @Override
    public Optional<Tuple> execute() {
        return null;
    }
    /**
     * Essa prende in ingresso una tupla selezionata e la passa alla funzione di
     * rimozione della classe "Tuple".
     * @param tuple 
     */
    public void execute(Tuple tuple) {
        tuple.rimuoviDalDB();
    }
}
