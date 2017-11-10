package net.infobosccoma.supermercat.model.entities;

import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.GregorianCalendar;

/**
 * Classe que modela un aliment
 *
 * @author Marc Nicolau
 *
 */
public class Aliment extends Producte implements Vendible {

    /* Atributs membre de la classe */
    private LocalDate dataCaducitat;

    /* Constructors */
    public Aliment() {
        super();
    }

    public Aliment(String nom, String codiBarres, float preu, LocalDate dataCaducitat) {
        super(nom, codiBarres, preu);
        this.dataCaducitat = dataCaducitat;
    }

    /* Setters i Getters */
    public LocalDate getDataCaducitat() {
        return dataCaducitat;
    }

    public void setDataCaducitat(LocalDate dataCaducitat) {
        this.dataCaducitat = dataCaducitat;
    }

    // Sobreescriptura del m�tode getPreu
    public float getPreu() {
        return (float) (super.getPreu() - super.getPreu() * (1.0 / DAYS.between(this.dataCaducitat, LocalDate.now())) + super.getPreu() * 0.1f);
    }
    
    
    @Override
    public boolean prohibit() {
        return dataCaducitat.isBefore(LocalDate.now());
    }

}
