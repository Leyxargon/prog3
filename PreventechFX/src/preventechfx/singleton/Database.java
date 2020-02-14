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
 * La classe Database implementa la connessione con il Database.
 */
public class Database {
    private static Database instance = null;
    final private static MongoClient MONGOCLIENT = new MongoClient(new MongoClientURI("mongodb+srv://admin:admin@preventechdb-swyud.mongodb.net/test?retryWrites=true&w=majority"));
    final private static MongoDatabase DB = MONGOCLIENT.getDatabase("maps");
    final private static MongoCollection COLLECTION = DB.getCollection("prog3");

    /**
     * Database() effettua una connessione e ne riporta lo stato.
     * 
     */
    private Database() {
        System.out.println("Connessione al database.");
    }
    
    /**
     * getInstance() non è altro che un pattern Singleton per verificare se
     * esiste già un instanza (connesione al Database)
     * @return instance (instanza della connessione al DB)
     */
    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    /**
     * getMongoClient() restituisce il contenuto dell'oggetto MONGOCLIENT
     * @return MONGOCLIENT
     */
    public static MongoClient getMongoClient() {
        return MONGOCLIENT;
    }

     /**
     * getDB() restituisce il contenuto dell'oggetto MongoDatabase
     * @return DB
     */
    public static MongoDatabase getDb() {
        return DB;
    }

     /**
     * getCollection() restituisce il contenuto dell'oggetto Collection
     * @return COLLECTION
     */
    public static MongoCollection getCollection() {
        return COLLECTION;
    }
    
}
