import java.util.Scanner;

public class VierGewinnt {
    static int[][] spielFeld = new int[6][7]; // 6 Zeilen, 7 Spalten
    static int zeilen = spielFeld.length;
    static int spalten = 7;

    static int[] spalteFuellstand = new int[7];

    static boolean spielerEins = true;

    static int spalte = 0;
    static int zeilenCounter;
    static int spaltenCounter;

    public static void main(String[] args) {
        do {
            printfield();
            spalteneingabe();
            spielerwechsel();
            spielsteinSetzen();
            printfield();
            Gewinnbedingung();

        } while (true);
    }

    private static void printfield() {
        // Ausgabe des Spielfelds


        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        System.out.println("|___|___|___|___|___|___|___|");

        for (zeilenCounter = 0; zeilenCounter < zeilen; zeilenCounter++) {
            System.out.println("|   |   |   |   |   |   |   |");

            for (spaltenCounter = 0; spaltenCounter < spalten; spaltenCounter++) {

                if (spielFeld[zeilenCounter][spaltenCounter] == 0) {
                    System.out.print("| " + " " + " ");
                } else if (spielFeld[zeilenCounter][spaltenCounter] == 1) {
                    System.out.print("| " + "X" + " ");
                } else if (spielFeld[zeilenCounter][spaltenCounter] == 2) {
                    System.out.print("| " + "O" + " ");
                }

            }

            System.out.print("|");
            System.out.println();
            System.out.println("|___|___|___|___|___|___|___|");
        }

        System.out.println();
    }

    private static void spielerwechsel() {
        // Spielerwechsel
        spielerEins = !spielerEins;

    } // end of private static void Spielerwechsel

    private static void spalteneingabe() {

        Scanner systemInputScanner = new Scanner(System.in);

        // Spalteneingabe durch Spieler eins oder zwei
        String EingabeA;

        if (spielerEins == true) {
            System.out.print("Spieler 1: Bitte Spaltennummer angeben: ");
            EingabeA = systemInputScanner.nextLine();
        } // end of if
        else {
            System.out.println("Spieler 2: Bitte Spaltennummer angeben: ");
            EingabeA = systemInputScanner.nextLine();
        } // end of if-else

        // Prüfen der Eingabe auf einen Wert zwischen 1 und 7
        spalte = Integer.parseInt(EingabeA) - 1;


        if (spalte < 0 || spalte > 6) {
            System.out.println();
            System.out.println("Die eingegebene Spaltennummer muss zwischen 1 und 7 liegen!");
            spalteneingabe();
        } else if (spalteFuellstand[spalte] > 5) {
            System.out.println("Spalte voll!!!!");
            spalteneingabe();
        }
    }

    private static void spielsteinSetzen() {
        int startHöhe = 5;
        int höheNeuerSpielstein = startHöhe - spalteFuellstand[spalte];
        if (spielerEins == true) {
            spielFeld[höheNeuerSpielstein][spalte] = 1;
        } else {
            spielFeld[höheNeuerSpielstein][spalte] = 2;
        }
        spalteFuellstand[spalte] = spalteFuellstand[spalte] + 1;
    }

    private static void Gewinnbedingung() {
        Scanner systemInputScanner = new Scanner(System.in);
        boolean a = false;
        int s;
        if (spielerEins == true) {
            s = 1;
        } else {
            s = 2;
        }

        for (int i = 0; i <= 2; i++) //vertikal
            for (int j = 0; j <= 6; j++) {
                if (spielFeld[i][j] == s && spielFeld[i + 1][j] == s && spielFeld[i + 2][j] == s && spielFeld[i + 3][j] == s) {
                    a = true;
                }
            }


        for (int i = 0; i <= 5; i++) //Horizontal
            for (int j = 0; j <= 3; j++) {
                if (spielFeld[i][j] == s && spielFeld[i][j + 1] == s && spielFeld[i][j + 2] == s && spielFeld[i][j + 3] == s) {
                    a = true;
                }
            }


        for (int i = 0; i <= 2; i++)  //Diagonal
            for (int j = 0; j <= 3; j++) {
                if (spielFeld[i][j] == s && spielFeld[i + 1][j + 1] == s && spielFeld[i + 2][j + 2] == s && spielFeld[i + 3][j + 3] == s) {
                    a = true;
                }
            }


        for (int i = 0; i < 3; i++) {
            for (int j = 6; j > 2; j--) {
                if (spielFeld[i][j] == s && spielFeld[i + 1][j - 1] == s && spielFeld[i + 2][j - 2] == s && spielFeld[i + 3][j - 3] == s) {
                    a = true;
                }
            }
        }

        if (a == true) {
            System.out.println("Gewonnen hat Spieler " + s);
            System.out.println("Weiterspielen (0) oder Beenden (1)");
            String EingabeEnde = systemInputScanner.nextLine();
            int Eingabe = Integer.parseInt(EingabeEnde);
            if (Eingabe == 1) {
                System.exit(0);
            } else if (Eingabe == 0) {

                printfield();
            }
        }
    }
}