/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.memento;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @author Dario
 */
public class TupleCollCaretaker {
    final Deque<TupleCollMemento> mementos = new ArrayDeque<>();
    int numEdit = 0;
    
    public TupleCollMemento getMemento() {
        if (!mementos.isEmpty()) {
            TupleCollMemento tupleCollMemento = mementos.pop();
            --numEdit;
            return tupleCollMemento;
        }
        return null;
    }

    public boolean noEdit() {
        return numEdit == 0;
    }
    
    public void addMemento(TupleCollMemento memento) {
        mementos.push(memento);
        System.out.println("Memorizzata azione "+ (memento.getLastAction() == Action.ADD ? "ADD" : (memento.getLastAction() == Action.DEL ? "DEL" : "NULL")));
        System.out.println("Dimensione stack: "+mementos.size());
        ++numEdit;
    }
}
