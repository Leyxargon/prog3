package preventechfx.memento;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Custode di una collezione di tuple. Gestisce gli snapshot degli stati
 * della TupleCollection.
 */
public class TupleCollCaretaker {
    final Deque<TupleCollMemento> mementos = new ArrayDeque<>();
    int numEdit = 0;
    
    /**
     * Retituisce l'ultimo stato della TupleCollection.
     * @return  ultimo stato della TupleCollection
     */
    public TupleCollMemento getMemento() {
        if (!mementos.isEmpty()) {
            --numEdit;
            return mementos.pop();
        }
        return null;
    }
    
    /**
     * Verifica se sono state applicate delle modifiche.
     * @return  true se sono state applicate delle modifiche, false altrimenti
     */
    public boolean noEdit() {
        return numEdit == 0;
    }
    
    /**
     * Crea uno snapshot dello stato della TupleCollection.
     * @param   memento oggetto contenente la TupleCollection e l'operazione effettuata
     */
    public void addMemento(TupleCollMemento memento) {
        mementos.push(memento);
        ++numEdit;
    }
}
