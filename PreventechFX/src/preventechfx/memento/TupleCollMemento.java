package preventechfx.memento;

import preventechfx.iterator.TupleCollection;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Copia memento della classe Originator. Utilizzata per gli snapshot della TupleCollection.
 */
public class TupleCollMemento {
    private TupleCollection tuples;
    private Action lastAction;

    /**
     * Costruisce un memento basato sulla ultima modifica alla
     * TupleCollection.
     * @param   tuples      collezione di tuple
     * @param   lastAction  ultima azione effettuata
     */
    public TupleCollMemento(TupleCollection tuples, Action lastAction) {
        this.tuples = tuples;
        this.lastAction = lastAction;
    }
    
    public TupleCollection getCollection() {
        return this.tuples;
    }
    
    public Action getLastAction() {
        return this.lastAction;
    }
    
    public void setCollection(TupleCollection tuples) {
        this.tuples = tuples;
    } 
}
