/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.command;

import java.util.Optional;
/**
 *
 * @author Dario
 */
public interface Command<R> {
    public Optional<R> execute();
}
