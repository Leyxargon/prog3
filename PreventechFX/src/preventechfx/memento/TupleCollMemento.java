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

public class TupleCollMemento {
    private TupleCollection tuples;
    private Action lastAction;

    public TupleCollMemento(TupleCollection tuples) {
        this.tuples = tuples;
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
