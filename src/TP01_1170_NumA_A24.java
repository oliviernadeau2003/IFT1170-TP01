// Auteur : Olivier Nadeau, IFT1170 A, Automne 2024

public class TP01_1170_NumA_A24 {

    public static void AfficherContenu(char[] poste, int[] nbCafe) {
        for (int i = 0; i < poste.length; i++) {
            switch (poste[i]) {
                case 'P':
                    System.out.printf("Programmeur : %s Café(s)\n", nbCafe[i]);
                    break;
                case 'O':
                    System.out.printf("Opérateur : %s Café(s)\n", nbCafe[i]);
                    break;
                case 'A':
                    System.out.printf("Analyste : %s Café(s)\n", nbCafe[i]);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + poste[i]);
            }
        }
    }

    public static void AfficherValeurNumerique(char p, char[] poste, int... nbCafe) {
        switch (p) {
            case 'O':
                System.out.printf("Il y a %d d'opérateur(s)\n", CalculerNbPoste(p, poste));
                break;
            case 'A':
                System.out.printf("Il y a %d d'analyste(s)\n", CalculerNbPoste(p, poste));
                break;
            case 'P':
                System.out.printf("Il y a %d programmeur(s) qui consomment 3 tasses ou plus\n", CalculerNbPoste(p, poste, nbCafe));
                break;
            case 'S':
                System.out.printf("Il y a %d secrétaire(s)\n", CalculerNbPoste(p, poste));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + p);
        }
    }

    public static int CalculerNbPoste(char p, char[] poste) {
        int compteur = 0;
        for (char k : poste)
            if (k == p) compteur++;
        return compteur;
    }

    // Utilise la  surcharge d'opérateurs pour ne pas avoir des paramètres inutiles
    public static int CalculerNbPoste(char p, char[] poste, int[] nbCafe) {
        int compteur = 0;
        for (int i = 0; i < poste.length; i++) if (poste[i] == p && nbCafe[i] >= 3) compteur++;
        return compteur;
    }

    public static void AfficherConsoMoyenne(char p, char[] poste, int[] nbCafe) {
        switch (p) {
            case 'O':
                System.out.printf("La consomation moyenne des opérateurs est de %.2f café(s)\n", CalculerConsoMoyenne(p, poste, nbCafe));
                break;
            case 'A':
                System.out.printf("La consomation moyenne des analystes est de %.2f café(s)\n", CalculerConsoMoyenne(p, poste, nbCafe));
                break;
            case 'P':
                System.out.printf("La consomation moyenne des programmeurs est de %.2f café(s)\n", CalculerConsoMoyenne(p, poste, nbCafe));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + p);
        }
    }

    public static float CalculerConsoMoyenne(char p, char[] poste, int[] nbCafe) {
        float sommeCafe = 0;
        float nbEmploye = 0;
        for (int i = 0; i < poste.length; i++) {
            if (poste[i] == p) {
                sommeCafe += nbCafe[i];
                nbEmploye++;
            }
        }
        return sommeCafe / nbEmploye;
    }

    public static void AfficherConsoMax(char p, char[] poste, int[] nbCafe) {
        switch (p) {
            case 'O':
                System.out.printf("La consomation maximal des opérateurs est de %d café(s)\n", CalculerConsoMax(p, poste, nbCafe));
                break;
            case 'A':
                System.out.printf("La consomation maximal des analystes est de %d café(s)\n", CalculerConsoMax(p, poste, nbCafe));
                break;
            case 'P':
                System.out.printf("La consomation maximal des programmeurs est de %d café(s)\n", CalculerConsoMax(p, poste, nbCafe));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + p);
        }
    }

    public static int CalculerConsoMax(char p, char[] poste, int[] nbCafe) {
        int consoMax = Integer.MIN_VALUE;
        for (int i = 0; i < poste.length; i++) {
            if (poste[i] == p && nbCafe[i] > consoMax) consoMax = nbCafe[i];
        }
        return consoMax;
    }

    public static void AfficherConsoMin(char p, char[] poste, int[] nbCafe) {
        switch (p) {
            case 'O':
                System.out.printf("La consomation minimal des opérateurs est de %d café(s)\n", CalculerConsoMin(p, poste, nbCafe));
                break;
            case 'A':
                System.out.printf("La consomation minimal des analystes est de %d café(s)\n", CalculerConsoMin(p, poste, nbCafe));
                break;
            case 'P':
                System.out.printf("La consomation minimal des programmeurs est de %d café(s)\n", CalculerConsoMin(p, poste, nbCafe));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + p);
        }
    }

    public static int CalculerConsoMin(char p, char[] poste, int[] nbCafe) {
        int consoMin = Integer.MAX_VALUE;
        for (int i = 0; i < poste.length; i++) {
            if (poste[i] == p && nbCafe[i] < consoMin) consoMin = nbCafe[i];
        }
        return consoMin;
    }

    public static void AfficherNumA() {
        char[] poste = {'P', 'P', 'O', 'P', 'A', 'A', 'O', 'A', 'P'};
        int[] nbCafe = {3, 1, 4, 0, 9, 2, 2, 5, 1};
        int nbEmp = poste.length;

        System.out.println("- Contenu des deux tableaux -");
        TP01_1170_NumA_A24.AfficherContenu(poste, nbCafe);

        System.out.println("\n- Nombre d'employé -");
        TP01_1170_NumA_A24.AfficherValeurNumerique('O', poste);
        TP01_1170_NumA_A24.AfficherValeurNumerique('A', poste);
        TP01_1170_NumA_A24.AfficherValeurNumerique('S', poste);
        TP01_1170_NumA_A24.AfficherValeurNumerique('P', poste, nbCafe);

        System.out.println("\n- Consomation moyenne -");
        TP01_1170_NumA_A24.AfficherConsoMoyenne('A', poste, nbCafe);

        System.out.println("\n- Consomation maximal -");
        TP01_1170_NumA_A24.AfficherConsoMax('P', poste, nbCafe);

        System.out.println("\n- Consomation minimal -");
        TP01_1170_NumA_A24.AfficherConsoMin('O', poste, nbCafe);
    }


}

/*

--- NUMÉRO A ---
- Contenu des deux tableaux -
Programmeur : 3 Café(s)
Programmeur : 1 Café(s)
Opérateur : 4 Café(s)
Programmeur : 0 Café(s)
Analyste : 9 Café(s)
Analyste : 2 Café(s)
Opérateur : 2 Café(s)
Analyste : 5 Café(s)
Programmeur : 1 Café(s)

- Nombre d'employé -
Il y a 2 d'opérateur(s)
Il y a 3 d'analyste(s)
Il y a 0 secrétaire(s)
Il y a 1 programmeur(s) qui consomment 3 tasses ou plus

- Consomation moyenne -
La consomation moyenne des analystes est de 5,33 café(s)

- Consomation maximal -
La consomation maximal des programmeurs est de 3 café(s)

- Consomation minimal -
La consomation minimal des opérateurs est de 2 café(s)

*/