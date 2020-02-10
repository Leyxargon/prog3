/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.iterator;

import preventechfx.builder.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dario
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
    
    private class TupleIterator implements Iterator {
        int i;
        
        @Override
        public boolean hasNext() {
            return i < tuples.size();
        }
        
        @Override
        public Tuple next() {
            if (this.hasNext())
                return tuples.get(i++);
            return null;
        }
    }
    
    public void add(Tuple object) {
        this.tuples.add(object);
    }
}
