
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
 * Facade è un Design Pattern che viene utilizzato dal Main per utilizzare tutte
 * le funzioni senza instanziare tutti gli oggetti che servono per utilizzare
 * tali metodi.
*/
public class Facade {
    TupleCollOriginator originator;
    TupleCollCaretaker caretaker;
    
    /**
     * Il costruttore di Facade instanzia tutte gli Oggetti necessari per 
     * l'utilizzo dei metodi che serviranno al main.
     */
    public Facade() {
        originator = new TupleCollOriginator();
        originator.setCollection(loadDB());
        caretaker = new TupleCollCaretaker();
    }
    
    /**
     * loadDb è un metono che tramite connessione al database "copia" tutte le 
     * tuple di quest'ultimo in un oggetto di tipo TupleCollection. 
     * @return tuples
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
