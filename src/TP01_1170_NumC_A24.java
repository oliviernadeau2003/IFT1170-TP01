// Auteur : Olivier Nadeau, IFT1170 A, Automne 2024

import Classe.Personne;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

public class TP01_1170_NumC_A24 {

    public static void AfficherNumC() {
        Personne[] pers = {new Personne("16/05/1992", 2), new Personne("02/01/1990"), new Personne("23/05/1990", 5), new Personne("19/02/1985", 0), new Personne("30/05/1991", 2), new Personne("31/01/1990", 4)};
        AfficherTableau(pers);

        System.out.println("\nPersonne qui consomme le moins de café :");
        System.out.println("\n       Indice              Personne       ");
        System.out.println("-----------------------------------------------");
        AfficherPersConsMoinsCafe(pers);

        System.out.println("\nPersonne qui consomme au moins 1 café :");
        AfficherPersConsoMin(pers, 1);

        System.out.println("\nAprès avoir trié le tableau :");
        TrierParDateNaissance(pers);
        AfficherTableau(pers);

        System.out.printf("\nPersonne née en 1990  (%d) :\n", CompterPersonne(pers, 1990));
        System.out.println("\n       Indice              Personne       ");
        System.out.println("-----------------------------------------------");
        AfficherNbPersonneNeeAvant(pers, 1990);
    }

    private static void AfficherTableau(Personne[] pers) {
        int i = 0;
        System.out.println("\n       Indice              Personne       ");
        System.out.println("-----------------------------------------------");
        for (Personne personne : pers) {
            AfficherUnePersonne(personne, i);
            i++;
        }
    }

    private static void AfficherUnePersonne(Personne personne, int indice) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = personne.getNaissance().format(formatter);
        String tasseWord = personne.getNbCafe() > 1 ? "tasses" : "tasse";  // Pluralize if necessary
        System.out.printf("         %d           \"%s\" %d %s\n", indice, formattedDate, personne.getNbCafe(), tasseWord);
    }

    public static void AfficherPersConsMoinsCafe(Personne[] pers) {
        Personne personne = getPersConsMoin(pers);
        AfficherUnePersonne(personne, Arrays.asList(pers).indexOf(personne));
    }

    private static Personne getPersConsMoin(Personne[] pers) {
        int consoMin = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < pers.length; i++) {
            if (pers[i].getNbCafe() < consoMin) {
                consoMin = pers[i].getNbCafe();
                index = i;
            }
        }
        return pers[index];
    }

    private static void AfficherPersConsoMin(Personne[] pers, int min) {
        int i = 0;
        System.out.println("\n       Indice              Personne       ");
        System.out.println("-----------------------------------------------");
        for (Personne personne : pers) {
            if (personne.getNbCafe() >= min) {
                AfficherUnePersonne(personne, i);
            }
            i++;
        }
    }

    private static void TrierParDateNaissance(Personne[] pers) {
        Arrays.sort(pers, Comparator.comparing(Personne::getNaissance));
    }

    private static void AfficherNbPersonneNeeAvant(Personne[] pers, int annee) {
        for (int i = 0; i < pers.length; i++)
            if (pers[i].getNaissance().getYear() == annee) AfficherUnePersonne(pers[i], i);
    }

    private static int CompterPersonne(Personne[] pers, int annee) {
        int compteur = 0;
        for (Personne per : pers) if (per.getNaissance().getYear() == annee) compteur++;
        return compteur;
    }

}

/*

--- NUMÉRO C ---

       Indice              Personne
-----------------------------------------------
         0           "16/05/1992" 2 tasses
         1           "02/01/1990" 1 tasse
         2           "23/05/1990" 5 tasses
         3           "19/02/1985" 0 tasse
         4           "30/05/1991" 2 tasses
         5           "31/01/1990" 4 tasses

Personne qui consomme le moins de café :

       Indice              Personne
-----------------------------------------------
         3           "19/02/1985" 0 tasse

Personne qui consomme au moins 1 café :

       Indice              Personne
-----------------------------------------------
         0           "16/05/1992" 2 tasses
         1           "02/01/1990" 1 tasse
         2           "23/05/1990" 5 tasses
         4           "30/05/1991" 2 tasses
         5           "31/01/1990" 4 tasses

Après avoir trié le tableau :

       Indice              Personne
-----------------------------------------------
         0           "19/02/1985" 0 tasse
         1           "02/01/1990" 1 tasse
         2           "31/01/1990" 4 tasses
         3           "23/05/1990" 5 tasses
         4           "30/05/1991" 2 tasses
         5           "16/05/1992" 2 tasses

Personne née en 1990  (3) :

       Indice              Personne
-----------------------------------------------
         1           "02/01/1990" 1 tasse
         2           "31/01/1990" 4 tasses
         3           "23/05/1990" 5 tasses

 */