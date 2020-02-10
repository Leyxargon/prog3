/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.command;

import java.util.Optional;
import javafx.stage.Window;
import preventechfx.builder.Tuple;

/**
 *
 * @author Dario
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
    
    public Optional<Tuple> execute(Tuple tuple) {
        tuple.rimuoviDalDB();
        return null;
    }
}
