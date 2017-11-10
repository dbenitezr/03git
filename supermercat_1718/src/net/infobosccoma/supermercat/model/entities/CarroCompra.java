package net.infobosccoma.supermercat.model.entities;

/**
 * Classe que model el carro de la compra on es guarden els productes
 *
 * @author Marc Nicolau
 *
 */
public class CarroCompra {

    /* constants */
    public final static int MAX_PRODUCTES = 100;

    /* Atributs membre de la classe */
    private Producte[] productes;
    private int nProductes;
    private int maxProductes;

    /* Constructors */
    public CarroCompra() {
        productes = new Producte[MAX_PRODUCTES];
        nProductes = 0;
        maxProductes = MAX_PRODUCTES;
    }

    public CarroCompra(int capacitat) {
        productes = new Producte[capacitat];
        nProductes = 0;
        maxProductes = capacitat;
    }

    /* Setters i Getters */
    public Producte[] getProductes() {
        return productes;
    }

    public void setProductes(Producte[] productes) {
        this.productes = productes;
    }

    public int getnProductes() {
        return nProductes;
    }

    public void setnProductes(int nProductes) {
        this.nProductes = nProductes;
    }

    public int getMaxProductes() {
        return maxProductes;
    }

    public void setMaxProductes(int maxProductes) {
        this.maxProductes = maxProductes;
    }

    /* Mètodes d'instància */
    /**
     * Afegir un producte al carro
     *
     * @param p Producte que es vol afegir
     */
    public void afegirProducte(Producte p) {
        // Comprovar que el carro no estigui ple
        if (this.nProductes < this.maxProductes) {
            this.productes[nProductes++] = p;
        } else {
            System.out.println("El carro està ple!");
        }
    }

    /**
     * Mostrar els productes del carro: nom de producte i quantitat
     *
     * Dos productes es consideren iguals si tenen el mateix codi de barres
     *
     */
    public void mostrarCarro() {
        int[] quantitats = new int[nProductes];
        Producte[] productesNoRepetits = new Producte[nProductes];
        int nNoRepetits = 0;
        int pos = -1;

        // trobar repetits
        for (int i = 0; i < nProductes; i++) {
            pos = cercarProducte(productes[i], productesNoRepetits, nNoRepetits, 0);
            if (pos == -1) {
                productesNoRepetits[nNoRepetits] = productes[i];
                quantitats[nNoRepetits++] = 1;
            } else {
                quantitats[pos]++;
            }
        }

        // mostrar carro
        System.out.println("NOM PRODUCTE\t\tQUANTITAT");
        System.out.println("------------\t\t---------");
        for (int i = 0; i < nNoRepetits; i++) {
            System.out.println(productesNoRepetits[i].getNom() + "\t\t" + quantitats[i]);
        }

    }

    /**
     * Generar el tiquet
     *
     * Es consideren dos productes iguals si tenen el mateix codi de barres i el
     * mateix preu unitari.
     *
     */
    public void generarTiquet() {
        int[] quantitats = new int[nProductes];
        Producte[] productesNoRepetits = new Producte[nProductes];
        int nNoRepetits = 0;
        int pos = -1;
        float importTotal = 0;

        // trobar repetits
        for (int i = 0; i < nProductes; i++) {
            pos = cercarProducte(productes[i], productesNoRepetits, nNoRepetits, 1);
            if (pos == -1) {
                productesNoRepetits[nNoRepetits] = productes[i];
                quantitats[nNoRepetits++] = 1;
            } else {
                quantitats[pos]++;
            }
        }

        // mostrar carro
        System.out.println("NOM PRODUCTE\t\tQUANTITAT\t\tPREU\t\tIMPORT");
        System.out.println("------------\t\t---------\t\t----\t\t------");
        for (int i = 0; i < nNoRepetits; i++) {
            System.out.println(productesNoRepetits[i].getNom() + "\t\t"
                    + quantitats[i] + "\t\t"
                    + productesNoRepetits[i].getPreu() + "\t\t"
                    + quantitats[i] * productesNoRepetits[i].getPreu());
            importTotal += quantitats[i] * productesNoRepetits[i].getPreu();
        }
        System.out.println("IMPORT TOTAL = " + importTotal);
    }

    /**
     * Buida el carro
     */
    public void buidar() {
        this.nProductes = 0;
    }


    /* Mètodes privats */
    /**
     * Cerca d'un producte dins un array
     *
     * @param p	El producte a cercar
     * @param dades	L'array on hi ha els productes a cercar
     * @param nDades La quantitat de dades que conté l'array
     * @param opcio si val 0, cerca per codi de barres; si val 1 cerca per codi
     * de barres i per preu unitari
     * @return la posició on troba el producte o bé -1 si no el troba
     */
    private int cercarProducte(Producte p, Producte[] dades, int nDades, int opcio) {
        int i = 0;
        boolean trobat = false;

        while (i < nDades && !trobat) {
            if (opcio == 0) {
                if (dades[i].getCodiBarres().equals(p.getCodiBarres())) {
                    trobat = true;
                } else {
                    i++;
                }
            } else if (opcio == 1) {
                if (dades[i].getCodiBarres().equals(p.getCodiBarres())
                        && dades[i].getPreu() == p.getPreu()) {
                    trobat = true;
                } else {
                    i++;
                }
            }
        }
        if (!trobat) {
            i = -1;
        }
        return i;
    }

}
