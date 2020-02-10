/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.builder;

import java.util.Arrays;
import org.bson.Document;

/**
 *
 * @author Dario
 */
public class Director {
    public void constructTupleFromDocument(Builder builder, Document document) {
        builder.setNome(document);
        builder.setPos(document);
        builder.setIndirizzo(document);
        builder.setOrario(document);
    }
    
    public void constructTupleFromData(Builder builder, String nome, double lat, double lon, String via, String cap, String citta, String prov, double apertura, double chiusura) {
        Document document = Director.toDocument(nome, lat, lon, via, cap, citta, prov, apertura, chiusura);
        builder.setNome(document);
        builder.setPos(document);
        builder.setIndirizzo(document);
        builder.setOrario(document);
    }
    
    private static Document toDocument(String nome, double lat, double lon, String via, String cap, String citta, String prov, double apertura, double chiusura) {
        Document document = new Document();
        document.append("pos", Arrays.asList(lat, lon));
        document.append("name", nome);
        document.append("indirizzo", Arrays.asList(via, cap, citta, prov));
        document.append("str", "<strong>" + nome + "</strong>" + "<br>" + via + "<br>" + cap + " " + citta + " "+ prov);
        document.append("open", apertura);
        document.append("close", chiusura);
        return document;
    }
}
