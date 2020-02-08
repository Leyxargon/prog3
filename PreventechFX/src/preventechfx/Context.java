/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preventechfx;
import java.time.LocalDateTime;
import java.time.LocalTime;
/**
 *
 * @author info
 */
public class Context implements State {

    @Override
    public String doAction() {
        return null;
        
    }
    
    
    
    

    /*public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();        
        Tupla x= new Tupla ();
        Double y;

        //x.trovaOrario(x.getFoundDocument(), "<strong>NEW LIFE</strong><br>Piazza Vittorio Emanuele III, 1<br>80049 Somma Vesuviana NA");
        y=x.trovaOrario("<strong>NEW LIFE</strong><br>Piazza Vittorio Emanuele III, 1<br>80049 Somma Vesuviana NA");
        String prova= new String(now.getHour() +"." +now.getMinute());
        double d = Double.parseDouble(prova);
        System.out.println(prova);
        System.out.println(y);
    }*/

   
    public String controlState(String nome_negozio, Tupla open) {
        LocalDateTime now = LocalDateTime.now();        
        Double timeopen,timeclose;
        State openState = new Open();
        State closeState = new Close();
        String state=null;
        
        
        timeopen=open.trovaOrario(nome_negozio);
        timeclose=open.orarioChiusura(nome_negozio);
        String prova= now.getHour() +"." +now.getMinute();
        double d = Double.parseDouble(prova);
        if(d>timeclose || d<timeopen)
            return closeState.doAction();
        else
            return openState.doAction();
    }
    
    
}
