
package net.infobosccoma.supermercat.view.ui.console;

import java.time.LocalDate;
import net.infobosccoma.supermercat.model.entities.Producte;
import net.infobosccoma.supermercat.model.entities.Aliment;
import net.infobosccoma.supermercat.model.entities.Electronica;
import net.infobosccoma.supermercat.model.entities.Vendible;
/**
 *
 * @author noot noot
 */
public class TestSuper {
    public static void main(String[] args) {
        Producte[] llista = new Producte[5];
        
        llista[0] = new Aliment("Doritos", "CODIBARRES", 1.20f, LocalDate.of(2017,12,12));
        llista[1] = new Aliment("Sukonbu", "CODIBARRES", 0.99f, LocalDate.of(2010,02,11));
        llista[2] = new Electronica("Televisor", "CODIBARRES", 699.99f, 365);
        llista[3] = new Electronica("iPhone X", "CODIBARRES", 1329.00f, 900);
        llista[4] = new Electronica("iPad", "CODIBARRES", 399.99f, 900);
        
        for(int i= 0;i<llista.length;i++) {
            if(llista[i] instanceof Vendible) {
                if(((Vendible) llista[i]).prohibit() ) {
                    System.out.println(llista[i].getNom());
                }
            }
        }
    }
}
