package preventechfx.builder;

import java.util.Arrays;
import org.bson.Document;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Fornisce un punto di accesso alla costruzione di tuple a partire da
 * diversi tipi di input.
 */
public class Director {
    /**
     * Costruisce una tupla a partire da un documento.
     * @param   builder     costruttore di tuple
     * @param   document    documento da convertire in Tuple
     */
    public void constructTupleFromDocument(Builder builder, Document document) {
        builder.setNome(document);
        builder.setPos(document);
        builder.setIndirizzo(document);
        builder.setOrario(document);
    }
    
    /**
     * Costruisce una tupla a partire da un documento.
     * @param   builder     costruttore di tuple
     * @param   nome        nome della farmacia
     * @param   lat         latitudine del segnaposto
     * @param   lon         longitudine del segnaposto
     * @param   via         via di ubicazione della farmacia
     * @param   cap         codice di avviamento postale del comune di ubicazione
     * @param   citta       comune di ubicazione della farmacia
     * @param   prov        provincia del comune di ubicazione della farmacia
     * @param   apertura    orario di apertura della farmacia
     * @param   chiusura    orario di chiusura della farmacia
     */
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
