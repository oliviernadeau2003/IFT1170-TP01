// Auteur : Olivier Nadeau, IFT1170 A, Automne 2024

public class TP01_1170_NumB_A24 {

    static String[] phrase = {"Laval1234", "Mont567real",
            "Tu l'as trop ecrase, Cesar, ce Port Salut!",
            "Et la marine va, papa, venir a Malte"};

    public static void Afficher(String phrase) {
        System.out.printf("\nLa phrase telle quelle : %s\n", phrase);
        System.out.printf("La phrase transformée : %s\n", transformerPhrase(phrase));
        if (estPalindrome(transformerPhrase(phrase)))
            System.out.println("La phrase examinée est palindrome");
        else
            System.out.println("La phrase examinée n'est pas un palindrome");
    }

    public static String transformerPhrase(String phrase) {
        String phraseTransformee = phrase.toUpperCase();
        for (char c : phraseTransformee.toCharArray()) {
            if (!Character.isLetter(c))
                phraseTransformee = phraseTransformee.replaceFirst(String.valueOf(c), "");
        }
        return phraseTransformee;
    }

    public static boolean estPalindrome(String phrase) {
        return new StringBuilder(phrase).reverse().toString().equals(phrase);
    }

    public static void AfficherNumB() {
        int lenght = phrase.length;
        for (int i = 0; i < lenght; i++) {
            Afficher(phrase[i]);
        }
    }

}

/*

--- NUMÉRO B ---

La phrase telle quelle : Laval1234
La phrase transformée : LAVAL
La phrase examinée est palindrome

La phrase telle quelle : Mont567real
La phrase transformée : MONTREAL
La phrase examinée n'est pas un palindrome

La phrase telle quelle : Tu l'as trop ecrase, Cesar, ce Port Salut!
La phrase transformée : TULASTROPECRASECESARCEPORTSALUT
La phrase examinée est palindrome

La phrase telle quelle : Et la marine va, papa, venir a Malte
La phrase transformée : ETLAMARINEVAPAPAVENIRAMALTE
La phrase examinée est palindrome

 */