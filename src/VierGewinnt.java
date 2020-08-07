import java.util.Scanner;

public class VierGewinnt {
    public static void main(String[] arguments) {

        int[][] spielfeld = new int[6][7];


        //scanner import für die Terminal eingabe

        Scanner systemInputScanner = new Scanner(System.in);

        do {


            String eingabe = systemInputScanner.next();

            int ausgabespalte = Integer.valueOf(eingabe);

            spielfeld[5][ausgabespalte] = 3;

            printfield(spielfeld);

        } while (5 <= 6);

    }

    public static void printfield(int[][] fieldtoprint) {


        //1 for-schleife

        for (int i = 0; i < fieldtoprint.length; i = i + 1) {


            //2 for-schleife

            for (int j = 0; j < fieldtoprint.length; j = j + 1) {

                System.out.print("[" + fieldtoprint[i][j] + "]");
            }


            //println für Zeilenumbrüche

            System.out.println("  ");
        }
    }
}