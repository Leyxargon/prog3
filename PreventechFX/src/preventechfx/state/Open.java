/**
 * Classe Open, implementa l'interfaccia State.
 * Segue Implementazione.
 */
package preventechfx.state;

/**
 *
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */


/**
 * La classe Open implementa il metodo DoAction dell'interfaccia State e setta
 * lo stato ad "Aperto".
*/
public class Open implements State {

    @Override
    public String doAction() {
        return "Aperto";
    }
    
}
