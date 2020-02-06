/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author raffa
 */
public class Tupla {

    final private Database database = Database.getInstance();
    private static Document nuovaTupla = new Document();
    private static String nome;
    private static double lat;
    private static double lon;
    private static String indirizzo;

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
        database.getCollection().insertOne(nuovaTupla);
        System.out.println("tupla inserita");
    }

    public void removeTupla(String nome, double lat, double lon, String indirizzo, double open, double close) {
        nuovaTupla.append("pos", Arrays.asList(lat, lon));
        nuovaTupla.append("name", indirizzo);
        nuovaTupla.append("str", "<strong>" + nome + "</strong>" + "<br>" + indirizzo);
        nuovaTupla.append("open", open);
        nuovaTupla.append("close", close);
        database.getCollection().deleteOne(nuovaTupla);
        System.out.println("tupla inserita");
    }


    public List<String> castLista() {
        List<String> cast = new ArrayList<>();
        Director x = new Director();
        for (Document o : database.getFoundDocument()) {
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
        Document searchQuery = new Document();
        searchQuery.put("str", nome_negozio);
        MongoCollection<Document> collection = database.getCollection();
        FindIterable<Document> findIterable = collection.find(searchQuery);
        findIterable.limit(1);
        MongoCursor<Document> cursor = findIterable.iterator();

        return (Double) cursor.next().get("open");
    }

    public Double orarioChiusura(String nome_negozio) {
        Document searchQuery = new Document();
        searchQuery.put("str", nome_negozio);
        MongoCollection<Document> collection = database.getCollection();
        FindIterable<Document> findIterable = collection.find(searchQuery);
        findIterable.limit(1);
        MongoCursor<Document> cursor = findIterable.iterator();

        return (Double) cursor.next().get("close");
    }
}