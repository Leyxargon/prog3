/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;

import org.bson.Document;

/**
 *
 * @author Dario
 */
public class Director {
    public void constructFarmaciaTuple(Builder builder, Document document) {
        builder.setNome(document);
        builder.setPos(document);
        builder.setIndirizzo(document);
        builder.setOrario(document);
    }
    
    public void constructDistributoreTuple(Builder builder, Document document) {
        builder.setNome(document);
        builder.setPos(document);
        builder.setIndirizzo(document);
    }
}
