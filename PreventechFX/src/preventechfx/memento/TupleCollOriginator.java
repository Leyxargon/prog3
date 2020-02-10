/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.memento;

import preventechfx.iterator.TupleCollection;

/**
 *
 * @author Dario
 */
public class TupleCollOriginator {
    private TupleCollection tuples;
    private Action lastAction;
    
    public TupleCollOriginator(TupleCollection tuples) {
        this.tuples = tuples;
        this.lastAction = Action.NULL;
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
    
    public void setLastAction(Action action) {
        this.lastAction = action;
    }
    
    public TupleCollMemento saveToMemento() {
        TupleCollMemento tupleCollMemento = new TupleCollMemento(this.tuples);
        return tupleCollMemento;
    }
    
    public void undo(TupleCollMemento memento) {
        this.tuples = memento.getCollection();
        this.lastAction = memento.getLastAction();
    }
}
