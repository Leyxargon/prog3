/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.builder;

import org.bson.Document;

/**
 *
 * @author Dario
 */
public interface Builder {
    public void setNome(Document document);
    public void setPos(Document document);
    public void setIndirizzo(Document document);
    public void setOrario(Document document);
}