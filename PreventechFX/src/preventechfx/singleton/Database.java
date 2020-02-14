package preventechfx.singleton;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */


/**
 * La classe Database implementa la connessione con il database.
 */
public class Database {
    private static Database instance = null;
    final private static MongoClient MONGOCLIENT = new MongoClient(new MongoClientURI("mongodb+srv://admin:admin@preventechdb-swyud.mongodb.net/test?retryWrites=true&w=majority"));
    final private static MongoDatabase DB = MONGOCLIENT.getDatabase("maps");
    final private static MongoCollection COLLECTION = DB.getCollection("prog3");

    /**
     * Effettua una connessione e ne riporta lo stato.
     * 
     */
    private Database() {
        System.out.println("Connessione al database.");
    }
    
    /**
     * Restituisce l'istanza del database se è già istanziato, altrimenti
     * la istanzia e apre una connessione col database.
     * @return  instance    istanza della connessione al database
     */
    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    /**
     * Restituisce il contenuto dell'oggetto di tipo MongoClient.
     * @return  oggetto di tipo MongoClient
     */
    public static MongoClient getMongoClient() {
        return MONGOCLIENT;
    }

     /**
     * Restituisce il contenuto dell'oggetto di tipo MongoDatabase.
     * @return  oggetto di tipo MongoDatabase
     */
    public static MongoDatabase getDb() {
        return DB;
    }

     /**
     * Restituisce il contenuto dell'oggetto di tipo MongoCollection.
     * @return  oggetto di tipo MongoCollection
     */
    public static MongoCollection getCollection() {
        return COLLECTION;
    }
    
}