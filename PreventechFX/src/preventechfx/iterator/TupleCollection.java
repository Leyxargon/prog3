package preventechfx.iterator;

import preventechfx.builder.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */
/**
 * la classe TupleCollection implementa la struttura dati. In questo caso
 * creiamo un ArrayList di Tuple in modo da farci ritornare una lista di Tuple.
 */
public class TupleCollection implements Aggregate {

    private final List<Tuple> tuples = new ArrayList<>();

    @Override
    public Iterator getIterator() {
        return new TupleIterator();
    }

    public List<Tuple> getCollection() {
        return this.tuples;
    }

    /**
     * Utilizzando le inner Class implementiamo anche la classe TupleIterator
     * che implementa Iterator, in questo caso non fa altro che scorrere
     * l'ArrayList e prendere i prossimi elementi nell'ArrayList
     */
    private class TupleIterator implements Iterator {

        int i;

        /**
         * Verifica se quell'indice è minore dell'Arraylist.size in tal caso
         * vuol dire che che non è l'ultimo.
         *
         * @return i<tuples.size();
         */
        @Override
        public boolean hasNext() {
            return i < tuples.size();
        }

        /**
         * Prende il prossimo elemento nell'ArrayList
         *
         * @return tuples.get(i++)
         */
        @Override
        public Tuple next() {
            if (this.hasNext()) {
                return tuples.get(i++);
            }
            return null;
        }
    }

    /**
     * Permette di aggiungere un oggetto in Tuple.
     *
     * @param object (Tuple)
     */
    public void add(Tuple object) {
        this.tuples.add(object);
    }
}
