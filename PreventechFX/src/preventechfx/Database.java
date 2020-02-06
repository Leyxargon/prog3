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
    private static MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://admin:admin@preventechdb-swyud.mongodb.net/test?retryWrites=true&w=majority"));
    private static MongoDatabase db = mongoClient.getDatabase("maps");
    private static MongoCollection collection = db.getCollection("prog3");

    private Database() {
        System.out.println("Connessione al database.");
    }
    
    public static Database getInstance() {
        if (instance == null)
            instance = new Database();
        return instance;
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }

    public static MongoDatabase getDb() {
        return db;
    }

    public static MongoCollection getCollection() {
        return collection;
    }
    
}
