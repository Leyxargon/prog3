package preventechfx.iterator;

import preventechfx.builder.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */
/**
 * Implementa la collezione di tuple. Crea un ArrayList di Tuple in modo
 * da far ritornare una lista di Tuple.
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
     * Implementa Iterator, usato per scorrere l'ArrayList 
     * e prendere gli elementi nell'ArrayList.
     */
    private class TupleIterator implements Iterator {

        private int i;

        /**
         * Verifica se quell'indice è minore della dimensione della
         * TupleCollection, in tal caso vuol dire che che non è l'ultimo.
         *
         * @return  true se non è l'ultimo elemento, false se è l'ultimo
         */
        @Override
        public boolean hasNext() {
            return i < tuples.size();
        }

        /**
         * Prende il prossimo elemento nella TupleCollection.
         *
         * @return  il successivo elemento della TupleCollection
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
     * @param   object  tupla da inserire nella TupleCollection
     */
    public void add(Tuple object) {
        this.tuples.add(object);
    }
}
