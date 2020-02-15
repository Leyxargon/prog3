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
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */


/**
 * Classe di facciata usata per accedere alle funzioni senza istanziare
 * manualmente tutti gli oggetti necessari.
 */
public class Facade {
    TupleCollOriginator originator;
    TupleCollCaretaker caretaker;
    
    /**
     * Istanzia tutti gli oggetti necessari per l'interazione con le
     * tuple. Fornisce un punto di accesso ad una collezione di tuple mantenuta
     * da un custode che può creare snapshot della collezione.
     */
    public Facade() {
        originator = new TupleCollOriginator();
        originator.setCollection(loadDB());
        caretaker = new TupleCollCaretaker();
    }
    
    /**
     * Metodo che recupera tutte le tuple dal database e le copia in
     * un oggetto di tipo TupleCollection. 
     * @return  tuples   collezione di tuple del database
    */
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
