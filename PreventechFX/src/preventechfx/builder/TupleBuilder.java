package preventechfx.builder;

import java.util.List;
import org.bson.Document;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Costruttore di tuple che implementa l'interfaccia Builder.
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
    
    /**
     * Imposta il nome della farmacia.
     * @param   document    oggetto di tipo Document dal quale prelevare i dati
     */
    @Override
    public void setNome(Document document) {
        this.nome = (String) document.get("name");
    }
    
    /**
     * Imposta le coordinate del segnaposto.
     * @param   document    oggetto di tipo Document dal quale prelevare i dati
     */
    @Override
    public void setPos(Document document) {
        List<Document> pos = (List<Document>) document.get("pos");
        this.lat = (double) (Object) pos.get(0);
        this.lon = (double) (Object) pos.get(1);
    }
    
    /**
     * Imposta l'ubicazione della farmacia.
     * @param   document    oggetto di tipo Document dal quale prelevare i dati
     */
    @Override
    public void setIndirizzo(Document document) {
        List<Document> indirizzo = (List<Document>) document.get("indirizzo");
        this.via = (String) (Object) indirizzo.get(0);
        this.cap = (String) (Object) indirizzo.get(1);
        this.citta = (String) (Object) indirizzo.get(2);
        this.prov = (String) (Object) indirizzo.get(3);
    }

    /**
     * Imposta gli orari della farmacia.
     * @param   document    oggetto di tipo Document dal quale prelevare i dati
     */
    @Override
    public void setOrario(Document document) {
        this.apertura = (double) (Object) document.get("open");
        this.chiusura = (double) (Object) document.get("close");
    }

    /**
     * Imposta il nome della farmacia.
     * @return  tupla costruita con uno dei metodi forniti dal Director
     */
    public Tuple getResult() {
        return new Tuple(nome, lat, lon, via, cap, citta, prov, apertura, chiusura);
    }
    
}
