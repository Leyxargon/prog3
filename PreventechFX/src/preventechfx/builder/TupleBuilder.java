/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.builder;

import java.util.List;
import org.bson.Document;

/**
 *
 * @author Dario
 */
public class TupleBuilder implements Builder {
    private String nome;
    private double lat;
    private double lon;
    private String via;
    private String cap;
    private String citta;
    private String prov;
    private double apertura;
    private double chiusura;
    
    @Override
    public void setNome(Document document) {
        this.nome = (String) document.get("name");
    }

    @Override
    public void setPos(Document document) {
        List<Document> pos = (List<Document>) document.get("pos");
        this.lat = (double) (Object) pos.get(0);
        this.lon = (double) (Object) pos.get(1);
    }

    @Override
    public void setIndirizzo(Document document) {
        List<Document> indirizzo = (List<Document>) document.get("indirizzo");
        this.via = (String) (Object) indirizzo.get(0);
        this.cap = (String) (Object) indirizzo.get(1);
        this.citta = (String) (Object) indirizzo.get(2);
        this.prov = (String) (Object) indirizzo.get(3);
    }
    
    
    @Override
    public void setOrario(Document document) {
        this.apertura = (double) (Object) document.get("open");
        this.chiusura = (double) (Object) document.get("close");
    }
    
    public Tuple getResult() {
        return new Tuple(nome, lat, lon, via, cap, citta, prov, apertura, chiusura);
    }
    
}
