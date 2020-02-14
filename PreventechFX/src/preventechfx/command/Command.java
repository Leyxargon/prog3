package preventechfx.command;

import java.util.Optional;
/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Offre un prototipo del pattern Command.
 * @param   <R> tipo generico
 */
public interface Command<R> {
    public Optional<R> execute();
}
