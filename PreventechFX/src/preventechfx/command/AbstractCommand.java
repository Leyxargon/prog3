package preventechfx.command;

import javafx.stage.Window;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Definisce i comportamenti base dell'interazione con l'interfaccia
 * grafica.
 * @param   <R> tipo di dato generico
 */
public abstract class AbstractCommand<R> implements Command<R> {
    Window window;
    
    public AbstractCommand(Window window) {
        this.window = window;
    }
    
    public Window getWindow() {
        return this.window;
    }
}
