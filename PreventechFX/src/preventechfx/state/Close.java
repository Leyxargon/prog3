package preventechfx.state;

/**
 *
 * @author Attanasio Raffaele, Musella Dario, Venuso Raffaele
 */

/**
 * Implementa il metodo DoAction dell'interfaccia State e setta lo 
 * stato a "Chiuso".
 */
public class Close implements State {
    @Override
    public String doAction() {
        return "Chiuso";
    }
}
