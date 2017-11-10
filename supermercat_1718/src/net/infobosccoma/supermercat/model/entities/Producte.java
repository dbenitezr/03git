package net.infobosccoma.supermercat.model.entities;

/**
 * Classe que modela un producte. És la superclasse de la resta de productes
 *
 * @author Marc Nicolau
 *
 */
public class Producte {

    /* Atributs membre de la classe */
    private String nom;
    private String codiBarres;
    private float preu;

    /* Constructors */
    public Producte() {

    }

    public Producte(String nom, String codiBarres, float preu) {
        this.nom = nom;
        this.codiBarres = codiBarres;
        this.preu = preu;
    }

    /* Setters i Getters */
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodiBarres() {
        return codiBarres;
    }

    public void setCodiBarres(String codiBarres) {
        this.codiBarres = codiBarres;
    }

    public float getPreu() {
        return preu;
    }

    public void setPreu(float preu) {
        this.preu = preu;
    }

}
