// Auteur : Olivier Nadeau, IFT1170 A, Automne 2024

package Classe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Personne {
    private String naissance; // format "jj/mm/aaaa", ex : "25/12/1990"
    private int nbCafe; // nb de tasses de café consommé par jour

    //  . . . Constructeurs à écrire . . .

    public Personne(String naissance) {
        this.naissance = naissance;
        this.nbCafe = 1;
    }

    public Personne(String naissance, int nbCafe) {
        this.naissance = naissance;
        this.nbCafe = nbCafe;
    }

    //  . . . Autres méthodes à écrire . . .

    public LocalDate getNaissance() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(naissance, formatter);
    }

    public int getNbCafe() {
        return nbCafe;
    }

    /*
    public int comparerParDateNaissance(Personne personne) {
        return this.getNaissance().compareTo(personne.getNaissance());
    }
    */

}
