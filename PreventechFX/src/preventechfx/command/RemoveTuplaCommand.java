package preventechfx.command;

import java.util.Optional;
import javafx.stage.Window;
import preventechfx.builder.Tuple;

/**
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Comando di eliminazione di una tupla.
 */
public class RemoveTuplaCommand extends AbstractCommand<Tuple> {
    public RemoveTuplaCommand() {
        this(null);
    }
   
    public RemoveTuplaCommand(Window window) {
        super(window);
    }
    @Override
    public Optional<Tuple> execute() {
        return null;
    }
    /**
     * Esegue il comando di riferimento, rimuove una tupla dal database.
     * @param   tuple   tupla da rimuovere dal database remoto
     */
    public void execute(Tuple tuple) {
        tuple.rimuoviDalDB();
    }
}
