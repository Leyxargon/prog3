package preventechfx.state;

/**
* Importiamo i package per il builder in modo da avere in input una tupla;
* Importiamo LocalDateTime in modo da avere in ogni momento l'orario locale.
*/
import java.time.LocalDateTime;
import preventechfx.builder.Tuple;
/**
 *
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Context è la classe che istanzia un oggetto di tipo State e in base a
 * determinate circostanza setta lo "Stato".
 */
public class Context {
    
    /**
     * Control State è una funzione che in base all'orario effettua una
     * comparazione con le variabili Apertura e Chiusura di una Tuple e
     * ritorna lo stato (Aperto/a o Chiuso/a) della Farmacia o Distributore. 
     * @param input Tuple
     * @return Close || Open
    */
    
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
