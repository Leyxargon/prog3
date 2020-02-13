/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.facade;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import preventechfx.builder.Director;
import preventechfx.builder.TupleBuilder;
import preventechfx.iterator.TupleCollection;
import preventechfx.memento.TupleCollCaretaker;
import preventechfx.memento.TupleCollOriginator;
import preventechfx.singleton.Database;

/**
 *
 * @author Dario
 */
public class Facade {
    TupleCollOriginator originator;
    TupleCollCaretaker caretaker;
    
    public Facade() {
        originator = new TupleCollOriginator();
        originator.setCollection(loadDB());
        caretaker = new TupleCollCaretaker();
    }
    
    public static TupleCollection loadDB() {
        Director director = new Director();
        TupleBuilder builder = new TupleBuilder();
        List<Document> document = (List<Document>) Database.getCollection().find().into(new ArrayList<>());
        TupleCollection tuples = new TupleCollection();

        for (Document d : document) {
            director.constructTupleFromDocument(builder, d);
            tuples.add(builder.getResult());
        }
        
        return tuples;
    }

    public TupleCollOriginator getOriginator() {
        return originator;
    }

    public TupleCollCaretaker getCaretaker() {
        return caretaker;
    }    
}
