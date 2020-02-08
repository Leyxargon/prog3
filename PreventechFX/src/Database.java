    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Dario
 */
public class Database {
    private static Database instance = null;
    final private static MongoClient MONGOCLIENT = new MongoClient(new MongoClientURI("mongodb+srv://admin:admin@preventechdb-swyud.mongodb.net/test?retryWrites=true&w=majority"));
    final private static MongoDatabase DB = MONGOCLIENT.getDatabase("maps");
    final private static MongoCollection COLLECTION = DB.getCollection("prog3");

    private Database() {
        System.out.println("Connessione al database.");
    }
    
    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public static MongoClient getMongoClient() {
        return MONGOCLIENT;
    }

    public static MongoDatabase getDb() {
        return DB;
    }

    public static MongoCollection getCollection() {
        return COLLECTION;
    }
    
}
