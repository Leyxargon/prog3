/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.command;

import java.util.Optional;
import javafx.stage.Window;
import preventechfx.builder.Tuple;
import preventechfx.memento.TupleCollCaretaker;
import preventechfx.memento.TupleCollMemento;
import preventechfx.memento.TupleCollOriginator;

/**
 *
 * @author Dario
 */
public class UndoCommand extends AbstractCommand<Tuple> {
    public UndoCommand() {
        this(null);
    }
   
    public UndoCommand(Window window) {
        super(window);
    }
    public void execute(TupleCollOriginator tupleCollOriginator, TupleCollMemento tupleCollMemento, TupleCollCaretaker tupleCollCaretaker) {
        switch(tupleCollOriginator.getLastAction()) {
            case ADD:
                tupleCollOriginator.getCollection().getCollection().get(tupleCollOriginator.getCollection().getCollection().size()-1).rimuoviDalDB();
                break;
            case DEL:
                tupleCollOriginator.getCollection().getCollection().get(tupleCollOriginator.getCollection().getCollection().size()-1).inserisciInDB();
                break;
        }
        tupleCollMemento = tupleCollCaretaker.getMemento();
        tupleCollOriginator.undo(tupleCollMemento);
    }

    @Override
    public Optional<Tuple> execute() {
        return null;
    }
    
}
