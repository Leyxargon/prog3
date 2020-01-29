/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventech;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.geojson.Polygon;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.java.html.leaflet.*;
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
        nuovaTupla.append("name", nome);
        nuovaTupla.append("pos",Arrays.asList(lat,lon));
        nuovaTupla.append("str",indirizzo);
        collection.insertOne(nuovaTupla);
        System.out.println("tupla inserita");
            System.out.println();
        }
    
    public void stamp(Tupla x){
        System.out.println(x.nome + " "+ x.lat +" "+ x.lon +" "+ x.indirizzo);
    }
    
    
    
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    @Override
    public String toString() {
        return "Tupla{" + "nome=" + nome + ", lat=" + lat + ", lon=" + lon + ", indirizzo=" + indirizzo + '}';
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
        
}
