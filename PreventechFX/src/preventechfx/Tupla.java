/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.Locale.filter;
import java.util.function.Consumer;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author raffa
 */
public class Tupla {

    MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://admin:admin@preventechdb-swyud.mongodb.net/test?retryWrites=true&w=majority")) {
    };
    MongoDatabase db = mongoClient.getDatabase("maps");
    DB database = mongoClient.getDB("maps");
    MongoCollection collection = db.getCollection("prog3");
    //MongoCollection<Document> orarioCollection = db.getCollection("prog3");
    DBCollection orarioCollection = database.getCollection("prog3");
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

    public void insertTupla(String nome, double lat, double lon, String indirizzo, double open, double close) {
        nuovaTupla.append("pos", Arrays.asList(lat, lon));
        nuovaTupla.append("name", indirizzo);
        nuovaTupla.append("str", "<strong>" + nome + "</strong>" + "<br>" + indirizzo);
        nuovaTupla.append("open", open);
        nuovaTupla.append("close", close);
        collection.insertOne(nuovaTupla);
        System.out.println("tupla inserita");
    }

    public void removeTupla(String nome, double lat, double lon, String indirizzo, double open, double close) {
        nuovaTupla.append("pos", Arrays.asList(lat, lon));
        nuovaTupla.append("name", indirizzo);
        nuovaTupla.append("str", "<strong>" + nome + "</strong>" + "<br>" + indirizzo);
        nuovaTupla.append("open", open);
        nuovaTupla.append("close", close);
        collection.deleteOne(nuovaTupla);
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
        Director x = new Director();
        for (Document o : foundDocument) {
            String list2 = (String) o.get("str");
            list2 = list2.replace("<strong>", "");
            list2 = list2.replace("</strong>", "");
            list2 = list2.replace("<br>", " ");
            list2 = list2 + " " + x.controlState((String) o.get("str"), this);
            cast.add(list2);
        }
        return cast;
    }

    public Double trovaOrario(String nome_negozio) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("str", nome_negozio);
        DBCursor cursor = orarioCollection.find(searchQuery);

        return (Double) cursor.next().get("open");
    }

    public Double orarioChiusura(String nome_negozio) {
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("str", nome_negozio);
        DBCursor cursor = orarioCollection.find(searchQuery);

        return (Double) cursor.next().get("close");
    }
}