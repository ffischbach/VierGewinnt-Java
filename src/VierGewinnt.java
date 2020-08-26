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
    static Player player1 = new Player();
    static Player player2 = new Player();


    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            playerDefinition();
        }
        do {
            printfield();
            spalteneingabe();
            spielerwechsel();
            spielsteinSetzen();
            printfield();
            gewinnbedingung();

        } while (true);
    }

    public static void playerDefinition() {
        Scanner systemInputScanner = new Scanner(System.in);
        System.out.println("Spieler1 nenne deinen Namen:");
        String namePlayer1 = systemInputScanner.nextLine();
        player1.setName(namePlayer1);

        System.out.println("Spieler2 nenne deinen Namen:");
        String namePlayer2 = systemInputScanner.nextLine();
        player2.setName(namePlayer2);

        System.out.println("Spieler1 wähle einen Token:");
        String tokenPlayer1 = systemInputScanner.nextLine();
        player1.setToken(tokenPlayer1);

        System.out.println("Spieler2 wähle einen Token:");
        String tokenPlayer2 = systemInputScanner.nextLine();
        player2.setToken(tokenPlayer2);
    }


    public static void printfield() {
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
                    System.out.print("| " + player1.getToken() + " ");
                } else if (spielFeld[zeilenCounter][spaltenCounter] == 2) {
                    System.out.print("| " + player2.getToken() + " ");
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

    public static void spalteneingabe() {

        Scanner systemInputScanner = new Scanner(System.in);

        // Spalteneingabe durch Spieler eins oder zwei
        String eingabe;

        if (spielerEins) {
            System.out.print(player2.getName() + " bitte gib die Spaltennummer an: ");
            eingabe = systemInputScanner.nextLine();
        } // end of if
        else {
            System.out.println(player1.getName() + " bitte gib die Spaltennummer an: ");
            eingabe = systemInputScanner.nextLine();
        } // end of if-else

        // Prüfen der Eingabe auf einen Wert zwischen 1 und 7
        spalte = Integer.parseInt(eingabe) - 1;


        if (spalte < 0 || spalte > 6) {
            System.out.println();
            System.out.println("Die eingegebene Spaltennummer muss zwischen 1 und 7 liegen!");
            spalteneingabe();
        } else if (spalteFuellstand[spalte] > 5) {
            System.out.println("Spalte ist voll!!!!");
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

    public static void gewinnbedingung() {
        Scanner systemInputScanner = new Scanner(System.in);
        //i = spalte j = reihe
        boolean hasWon = false;
        int spieler;
        if (spielerEins) {
            spieler = 1;
        } else {
            spieler = 2;
        }

        for (int spalte = 0; spalte <= 2; spalte++) //vertikal
            for (int reihe = 0; reihe <= 6; reihe++) {
                if (spielFeld[spalte][reihe] == spieler && spielFeld[spalte + 1][reihe] == spieler && spielFeld[spalte + 2][reihe] == spieler && spielFeld[spalte + 3][reihe] == spieler) {
                    hasWon = true;
                }
            }


        for (int spalte = 0; spalte <= 5; spalte++) //Horizontal
            for (int reihe = 0; reihe <= 3; reihe++) {
                if (spielFeld[spalte][reihe] == spieler && spielFeld[spalte][reihe + 1] == spieler && spielFeld[spalte][reihe + 2] == spieler && spielFeld[spalte][reihe + 3] == spieler) {
                    hasWon = true;
                }
            }


        for (int spalte = 0; spalte <= 2; spalte++)  //Diagonal
            for (int reihe = 0; reihe <= 3; reihe++) {
                if (spielFeld[spalte][reihe] == spieler && spielFeld[spalte + 1][reihe + 1] == spieler && spielFeld[spalte + 2][reihe + 2] == spieler && spielFeld[spalte + 3][reihe + 3] == spieler) {
                    hasWon = true;
                }
            }


        for (int spalte = 0; spalte < 3; spalte++) {
            for (int reihe = 6; reihe > 2; reihe--) {
                if (spielFeld[spalte][reihe] == spieler && spielFeld[spalte + 1][reihe - 1] == spieler && spielFeld[spalte + 2][reihe - 2] == spieler && spielFeld[spalte + 3][reihe - 3] == spieler) {
                    hasWon = true;
                }
            }
        }

        if (spieler == 1 ) {
            System.out.println(player1.getName() + " hat gewonnen");
        }
        else {
            System.out.println(player2.getName() + " hat gewonnen");
        }

        if (hasWon) {

            System.out.println("Wenn du Weiterspielen möchtest drücke (0) zum Beenden drücke die (1)");
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