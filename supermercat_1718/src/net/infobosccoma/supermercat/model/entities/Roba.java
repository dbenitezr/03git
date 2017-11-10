package net.infobosccoma.supermercat.model.entities;

/**
 * Classe que modela un producte de tipus roba
 *
 * @author Marc Nicolau
 *
 */
public class Roba extends Producte {

    /* Atributs membre de la classe */
    private String composicioTextil;

    /* Constructors */
    public Roba() {
        super();
    }

    public Roba(String nom, String codiBarres, float preu, String composicioTextil) {
        super(nom, codiBarres, preu);
        this.composicioTextil = composicioTextil;
    }

    /* Setters i Getters */
    public String getComposicioTextil() {
        return composicioTextil;
    }

    public void setComposicioTextil(String composicioTextil) {
        this.composicioTextil = composicioTextil;
    }

}
