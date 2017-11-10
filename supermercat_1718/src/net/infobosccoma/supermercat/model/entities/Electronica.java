package net.infobosccoma.supermercat.model.entities;

/**
 * Classe que modela un producte de tipus electrònica
 *
 * @author Marc Nicolau
 *
 */
public class Electronica extends Producte implements Vendible {

    /* Atributs membre de la classe */
    private int diesGarantia;

    /* Constructors */
    public Electronica() {
        super();
    }

    public Electronica(String nom, String codiBarres, float preu, int diesGarantia) {
        super(nom, codiBarres, preu);
        this.diesGarantia = diesGarantia;
    }

    /* Setters i Getters */
    public int getDiesGarantia() {
        return diesGarantia;
    }

    public void setDiesGarantia(int diesGarantia) {
        this.diesGarantia = diesGarantia;
    }

    // Sobreescriptura del mètode getPreu
    public float getPreu() {
        return (float) (super.getPreu() + super.getPreu() * (this.diesGarantia / 365f) * 0.1F);
    }
    
    @Override
    public boolean prohibit() {
        return diesGarantia < 700;
    }

}
