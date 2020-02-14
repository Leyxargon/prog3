package preventechfx.iterator;

import preventechfx.builder.*;
/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */


/**
 * Prevede i metodi hasNext() e next().
 */
public interface Iterator {
    public boolean hasNext();
    public Tuple next();
}
