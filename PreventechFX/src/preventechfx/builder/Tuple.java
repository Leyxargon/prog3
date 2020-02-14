package preventechfx.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import preventechfx.singleton.Database;
import preventechfx.state.Context;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Contiene le informazioni inerenti ad una farmacia.
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
    
    /**
     * Costuisce una tupla a partire da singoli dati.
     * @param nome
     * @param lat
     * @param lon
     * @param via
     * @param cap
     * @param citta
     * @param prov
     * @param apertura
     * @param chiusura 
     */
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
    
    /**
     * Inserisce la tupla nel database.
     */
    public void inserisciInDB() {
        if (!this.isInDB())
            Database.getCollection().insertOne(this.asDocument());
    }
    
    /**
     * Rimuove la tupla dal database.
     */
    public void rimuoviDalDB() {
        if (this.isInDB())
            Database.getCollection().deleteOne(this.asDocument());
    }
    
    /**
     * Verifica se una copia della tupla è presente nel database remoto.
     * @return  true se è presente, false se è assente
     */
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
    
    /**
     * Genera un oggetto di tipo Document contenente i dati della tupla.
     * @return  oggetto Document contenente i dati della tupla
     */
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
    
    /**
     * Confronta due tuple.
     * @param   tuple   tupla da confrontare
     * @return  true se le due tuple sono uguali, false se non sono uguali
     */
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
    
    /**
     * Verifica se la farmacia sia aperta o chiusa.
     * @return  stato del servizio
     */
    public String getServizio(){
        Context x = new Context();
        return x.controlState(this);
    }
}
