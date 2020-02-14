package preventechfx.command;

import java.util.Optional;
import javafx.stage.Window;
import preventechfx.builder.Tuple;
import preventechfx.iterator.Iterator;
import preventechfx.memento.TupleCollCaretaker;
import preventechfx.memento.TupleCollOriginator;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Annulla l'ultima operazione effettuata e ritorna all'ultimo stato del DB.
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */
public class UndoCommand extends AbstractCommand<Tuple> {
    public UndoCommand() {
        this(null);
    }
   
    public UndoCommand(Window window) {
        super(window);
    }
    
    /**
     * Esegue il comando di annullamento dell'ultima operazione. Legge
     * l'ultima operazione effettuata e ne annulla l'applicazione.
     * @param   tupleCollOriginator collezione di tuple originaria
     * @param   tupleCollCaretaker  custode che gestisce gli snapshot
     */
    public void execute(TupleCollOriginator tupleCollOriginator, TupleCollCaretaker tupleCollCaretaker) {
        switch(tupleCollOriginator.getLastAction()) {
            case ADD:
                tupleCollOriginator.getCollection().getCollection().get(tupleCollOriginator.getCollection().getCollection().size()-1).rimuoviDalDB();
                tupleCollOriginator.undo(tupleCollCaretaker.getMemento());
                break;
            case DEL:
                tupleCollOriginator.undo(tupleCollCaretaker.getMemento());
                Tuple tuple;
                Iterator iter = tupleCollOriginator.getCollection().getIterator();
                do {
                    tuple = iter.next();
                } while (iter.hasNext() && tuple.isInDB());
                tuple.inserisciInDB();
                break;
        }
    }

    @Override
    public Optional<Tuple> execute() {
        return null;
    }
    
}
