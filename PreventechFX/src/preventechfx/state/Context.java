/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx.state;

import java.time.LocalDateTime;
import preventechfx.builder.Tuple;
/**
 *
 * @author info
 */
public class Context {

   /*public String controlState(String nome_negozio, Tupla open) {
        LocalDateTime now = LocalDateTime.now();
        Double timeopen, timeclose;
        State openState = new Open();
        State closeState = new Close();
        String state = null;
        timeopen = open.trovaOrario(nome_negozio);
        timeclose = open.orarioChiusura(nome_negozio);
        String prova = now.getHour() + "." + now.getMinute();
        double d = Double.parseDouble(prova);
        if (d > timeclose || d < timeopen) {
            return closeState.doAction();
        } else {
            return openState.doAction();
        }
    }*/
    
    public String controlState(Tuple input){
       LocalDateTime now = LocalDateTime.now();
       String cast = now.getHour() + "." + now.getMinute();
       double orario = Double.parseDouble(cast);
       if(orario > input.getChiusura() || orario < input.getApertura())
           return new Close().doAction();
       else
           return new Open().doAction();
    }
}
