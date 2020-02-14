/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.command;

import java.util.Optional;
import javafx.stage.Window;
import preventechfx.builder.Tuple;
import preventechfx.iterator.Iterator;
import preventechfx.memento.Action;
import preventechfx.memento.TupleCollCaretaker;
import preventechfx.memento.TupleCollOriginator;

/**
 * Questa classe si occupa di interfacciarsi con la classe Memento per annullare 
 * l'ultima operazione effettuata e ritornare all'ultimo stato del DB.
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
     * l'execute opera a partire da uno switch case per definire se bisogna 
     * aggiungere o rimuovere una tupla dal DB, prendendo le informazioni dai 
     * due parametri in ingresso.
     * @param tupleCollOriginator
     * @param tupleCollCaretaker 
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
