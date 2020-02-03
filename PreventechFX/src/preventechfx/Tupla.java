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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author raffa
 */
public class Tupla {
    
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://admin:admin@preventechdb-swyud.mongodb.net/test?retryWrites=true&w=majority")) {};
        MongoDatabase db = mongoClient.getDatabase("maps");
        MongoCollection collection = db.getCollection("prog3");
        List<Document> foundDocument = (List<Document>) collection.find().into(new ArrayList<>());
        Document nuovaTupla = new Document();
    
        
        String nome;
        double lat;
        double lon;
        String indirizzo;      

    public Tupla() {
    }

    public Tupla(String nome, double lat, double lon, String indirizzo) {
        this.nome = nome;
        this.lat = lat;
        this.lon = lon;
        this.indirizzo = indirizzo;
    }


        
        public void insertTupla(String nome, double lat, double lon, String indirizzo) {
        nuovaTupla.append("pos",Arrays.asList(lat,lon));
        nuovaTupla.append("name", indirizzo);
        nuovaTupla.append("str",nome);
        collection.insertOne(nuovaTupla);
        System.out.println("tupla inserita");
        }

    
    
    
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public MongoDatabase getDb() {
        return db;
    }

    public void setDb(MongoDatabase db) {
        this.db = db;
    }

    public MongoCollection getCollection() {
        return collection;
    }

    public void setCollection(MongoCollection collection) {
        this.collection = collection;
    }

    public List<Document> getFoundDocument() {
        return foundDocument;
    }

    public void setFoundDocument(List<Document> foundDocument) {
        this.foundDocument = foundDocument;
    }

    public Document getNuovaTupla() {
        return nuovaTupla;
    }

    public void setNuovaTupla(Document nuovaTupla) {
        this.nuovaTupla = nuovaTupla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    
    public List<String> castLista(List<Document> foundDocument) {
        List<String> cast = new ArrayList<>();
        for (Document o : foundDocument) {
            String list2 = (String) o.get("str");
            cast.add(list2);
        }
        return cast;
    }
    
}