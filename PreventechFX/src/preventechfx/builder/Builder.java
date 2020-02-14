package preventechfx.builder;

import org.bson.Document;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Costruttore di tuple con metodi che prevedono il trattamento di un oggetto
 * di tipo Document. 
 */
public interface Builder {
    public void setNome(Document document);
    public void setPos(Document document);
    public void setIndirizzo(Document document);
    public void setOrario(Document document);
}