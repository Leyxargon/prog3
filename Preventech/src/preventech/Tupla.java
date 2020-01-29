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
    public Tupla(String nome, double pos1, double pos2, String indirizzo) {
        nuovaTupla.append("name", nome);
        nuovaTupla.append("pos",Arrays.asList(pos1,pos2));
        nuovaTupla.append("str",indirizzo);
        collection.insertOne(nuovaTupla);
    }
    
    
}
