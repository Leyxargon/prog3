package preventechfx.memento;

import preventechfx.iterator.TupleCollection;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Immagazzina una collezione di tuple e memorizza l'ultima operazione
 * effettuata su di essa.
 */
public class TupleCollOriginator {
    private TupleCollection tuples;
    private Action lastAction;

    public TupleCollection getCollection() {
        return this.tuples;
    }
    
    public Action getLastAction() {
        return this.lastAction;
    }
    
    public void setCollection(TupleCollection tuples) {
        this.tuples = tuples;
    }

    public void setLastAction(Action action) {
        this.lastAction = action;
    }
    
    /**
     * Crea una copia memento della TupleCollection.
     * @return  memento dell'ultimo stato della TupleCollection
     */
    public TupleCollMemento saveToMemento() {
        return new TupleCollMemento(this.tuples, this.lastAction);
    }
    
    /**
     * Riporta la collezione di tuple ad uno stato precedente.
     * @param   memento stato precedente della TupleCollection
     */
    public void undo(TupleCollMemento memento) {
        this.tuples = memento.getCollection();
        this.lastAction = memento.getLastAction();
    }
}