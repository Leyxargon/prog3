/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import preventechfx.singleton.Database;

/**
 *
 * @author Dario
 */
public class Tuple {
    private String nome;
    private double lat;
    private double lon;
    private String via;
    private String cap;
    private String citta;
    private String prov;
    private double apertura;
    private double chiusura;
    
    public Tuple(String nome, double lat, double lon, String via, String cap, String citta, String prov, double apertura, double chiusura) {
        this.nome = nome;
        this.lat = lat;
        this.lon = lon;
        this.via = via;
        this.cap = cap;
        this.citta = citta;
        this.prov = prov;
        this.apertura = apertura;
        this.chiusura = chiusura;
    }

    public String getNome() {
        return nome;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getVia() {
        return via;
    }

    public String getCap() {
        return cap;
    }

    public String getCitta() {
        return citta;
    }

    public String getProv() {
        return prov;
    }

    public double getApertura() {
        return apertura;
    }

    public double getChiusura() {
        return chiusura;
    }
    
    public void inserisciInDB() {
        if (!this.isInDB())
            Database.getCollection().insertOne(this.asDocument());
    }
    
    public void rimuoviDalDB() {
        if (this.isInDB())
            Database.getCollection().deleteOne(this.asDocument());
    }
    
    public boolean isInDB() {
        List<Document> collection = (List<Document>) Database.getCollection().find().into(new ArrayList<>());
        Director director = new Director();
        TupleBuilder builder = new TupleBuilder();
        for (Document c : collection) {
            director.constructTupleFromDocument(builder, c);
            if (this.equals(builder.getResult()))
                return true;
        }
        return false;
    }
    
    public Document asDocument() {
        Document document = new Document();
        document.append("pos", Arrays.asList(lat, lon));
        document.append("name", nome);
        document.append("indirizzo", Arrays.asList(via, cap, citta, prov));
        document.append("str", "<strong>" + nome + "</strong>" + "<br>" + via + "<br>" + cap + " " + citta + " "+ prov);
        document.append("open", apertura);
        document.append("close", chiusura);
        return document;
    }
    
    public boolean equals(Tuple tuple) {
        return this.nome.equals(tuple.nome) &&
                this.lat == tuple.lat &&
                this.lon == tuple.lon &&
                this.via.equals(tuple.via) &&
                this.cap.equals(tuple.cap) &&
                this.citta.equals(tuple.citta) &&
                this.prov.equals(tuple.prov) &&
                this.apertura == tuple.apertura &&
                this.chiusura == tuple.chiusura;
    }
}
