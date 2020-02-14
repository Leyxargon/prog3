package preventechfx.iterator;

import preventechfx.builder.*;
/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */


/**
 * Definiamo l’interfaccia dell’Iteratore che prevede i metodi di interrogazione 
 * hasNext() ed il puntatore all’elemento successivo next().
 */
public interface Iterator {
    public boolean hasNext();
    Tuple next();
}
