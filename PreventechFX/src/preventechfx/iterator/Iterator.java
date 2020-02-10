/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.iterator;

import preventechfx.builder.*;
/**
 *
 * @author Dario
 */
public interface Iterator {
    public boolean hasNext();
    Tuple next();
}
