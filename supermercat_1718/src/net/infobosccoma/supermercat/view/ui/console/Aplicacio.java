package net.infobosccoma.supermercat.view.ui.console;

import java.time.LocalDate;
import java.util.Scanner;
import net.infobosccoma.supermercat.model.entities.Aliment;
import net.infobosccoma.supermercat.model.entities.CarroCompra;
import net.infobosccoma.supermercat.model.entities.Electronica;
import net.infobosccoma.supermercat.model.entities.Producte;
import net.infobosccoma.supermercat.model.entities.Roba;

/**
 * Classe que conté el main() de l'aplicació del supermercat
 *
 * @author Marc Nicolau
 *
 */
public class Aplicacio {

    public static void main(String[] args) {
        int opcio = 0;
        CarroCompra carro = new CarroCompra(100);

        do {
            mostrarMenuPrincipal();
            opcio = llegirOpcio();
            switch (opcio) {
                case 1:
                    productes(carro);
                    break;
                case 2:
                    carro.generarTiquet();
                    carro.buidar();
                    break;
                case 3:
                    carro.mostrarCarro();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no correcta");
                    break;
            }
        } while (opcio != 0);
    }

    static void mostrarMenuPrincipal() {
        System.out.println("1. Introduir producte");
        System.out.println("2. Passar per caixa");
        System.out.println("3. Mostrar carro de la compra");
        System.out.println("0. Sortir");
        System.out.println("\nOpcio: ");
    }

    static void mostrarMenuProductes() {
        System.out.println("1. Afegir un aliment");
        System.out.println("2. Afegir un producte de vestir");
        System.out.println("3. Afegir un producte d'electrònica");
        System.out.println("0. Tornar al menú princpal");
        System.out.println("\nOpcio: ");
    }

    static int llegirOpcio() {
        Scanner lector = new Scanner(System.in);

        return Integer.parseInt(lector.nextLine());
    }

    static void productes(CarroCompra carro) {
        int opcio = 0;

        do {
            mostrarMenuProductes();
            opcio = llegirOpcio();
            switch (opcio) {
                case 1:
                    afegirAliment(carro);
                    break;
                case 2:
                    afegirElectronica(carro);
                    break;
                case 3:
                    afegirTextil(carro);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opció no correcta");
                    break;
            }
        } while (opcio != 0);
    }

    static LocalDate llegirData() {
        int dia, mes, any;
        Scanner lector = new Scanner(System.in);

        System.out.print("Dia: ");
        dia = Integer.parseInt(lector.nextLine());
        System.out.print("Mes: ");
        mes = Integer.parseInt(lector.nextLine());
        System.out.print("Any: ");
        any = Integer.parseInt(lector.nextLine());

        return LocalDate.of(any, mes, dia);

    }

    static void afegirAliment(CarroCompra carro) {
        String nom, codiBarres;
        float preu;
        Scanner lector = new Scanner(System.in);

        System.out.print("Nom: ");
        nom = lector.nextLine();
        System.out.print("Codi de barres: ");
        codiBarres = lector.nextLine();
        System.out.print("Preu: ");
        preu = Float.parseFloat(lector.nextLine());
        System.out.println("Data de caducitat");

        carro.afegirProducte(new Aliment(nom, codiBarres, preu, llegirData()));
    }

    static void afegirElectronica(CarroCompra carro) {
        String nom, codiBarres;
        float preu;
        int dies;
        Scanner lector = new Scanner(System.in);

        System.out.print("Nom: ");
        nom = lector.nextLine();
        System.out.print("Codi de barres: ");
        codiBarres = lector.nextLine();
        System.out.print("Preu: ");
        preu = Float.parseFloat(lector.nextLine());;
        System.out.println("Dies de garantia: ");
        dies = Integer.parseInt(lector.nextLine());

        carro.afegirProducte(new Electronica(nom, codiBarres, preu, dies));

    }

    static void afegirTextil(CarroCompra carro) {
        String nom, codiBarres, textil;
        float preu;
        Scanner lector = new Scanner(System.in);

        System.out.print("Nom: ");
        nom = lector.nextLine();
        System.out.print("Codi de barres: ");
        codiBarres = lector.nextLine();
        System.out.print("Preu: ");
        preu = Float.parseFloat(lector.nextLine());
        System.out.print("Composició tèxtil: ");
        textil = lector.nextLine();

        carro.afegirProducte(new Roba(nom, codiBarres, preu, textil));

    }
}
