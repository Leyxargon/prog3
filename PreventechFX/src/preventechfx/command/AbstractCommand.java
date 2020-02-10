/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.command;

import javafx.stage.Window;

/**
 *
 * @author Dario
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
