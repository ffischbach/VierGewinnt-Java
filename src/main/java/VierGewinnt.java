import java.util.Scanner;

public class VierGewinnt {

    static boolean playerOne = true;

    static int column = 0;

    static Player player1 = new Player();
    static Player player2 = new Player();


    public static void main(String[] args) {

        new Playfield ();
        Playfield playfield = new Playfield();

        for (int i = 0; i < 1; i++) {
            playerDefinition();
        }

        while (true) {
            playfield.printField(player1, player2);
            chooseColumn(playfield);
            playfield.setToken(playerOne, column);
            playfield.printField(player1, player2);
            winCondition(playfield);
            playerRotation();
        }
    }

    public static void playerDefinition() {
        Scanner systemInputScanner = new Scanner(System.in);
        System.out.println("Player 1 Please type your Name:");
        String namePlayer1 = systemInputScanner.nextLine();
        player1.setName(namePlayer1);

        System.out.println("Player 2 Please type your Name:");
        String namePlayer2 = systemInputScanner.nextLine();
        player2.setName(namePlayer2);

        System.out.println(player1.getName() + " Please set your Token:");
        String tokenPlayer1 = systemInputScanner.nextLine();
        player1.setToken(tokenPlayer1);

        System.out.println(player2.getName() + " Please set your Token:");
        String tokenPlayer2 = systemInputScanner.nextLine();
        player2.setToken(tokenPlayer2);
    }

    private static void playerRotation() {

        playerOne = !playerOne;
    }

    public static void chooseColumn(Playfield playfield) {

        Scanner systemInputScanner = new Scanner(System.in);

        String input;

        if (playerOne) {
            System.out.print(player1.getName() + " please choose your column : ");
            input = systemInputScanner.nextLine();
        } else {
            System.out.println(player2.getName() + " please choose your column : ");
            input = systemInputScanner.nextLine();
        }

        try {
            column = Integer.parseInt(input) - 1;
        } catch (NumberFormatException exception) {
            System.out.println("Letters are not allowed please choose a Number between 1 and 7!!!");
            chooseColumn(playfield);
        }


        if (column < 0 || column > 6) {
            System.out.println();
            System.out.println("Please choose a Number between 1 and 7!!!");
            chooseColumn(playfield);
        } else if (playfield.isColumnFull(column)) {
            System.out.println("Column is full!!!");
            chooseColumn(playfield);
        }
    }


    public static void winCondition(Playfield playfield) {
        int[][] playground = playfield.getPlayground();

        Scanner systemInputScanner = new Scanner(System.in);

        boolean hasWon = false;
        int playerId;
        if (playerOne) {
            playerId = 1;
        }
        else {
            playerId = 2;
        }

        for (int spalte = 0; spalte <= 2; spalte++) //vertikal
            for (int reihe = 0; reihe <= 6; reihe++) {
                if (playground[spalte][reihe] == playerId && playground[spalte + 1][reihe] == playerId && playground[spalte + 2][reihe] == playerId && playground[spalte + 3][reihe] == playerId) {
                    hasWon = true;
                    break;
                }
            }


        for (int spalte = 0; spalte <= 5; spalte++) //Horizontal
            for (int reihe = 0; reihe <= 3; reihe++) {
                if (playground[spalte][reihe] == playerId && playground[spalte][reihe + 1] == playerId && playground[spalte][reihe + 2] == playerId && playground[spalte][reihe + 3] == playerId) {
                    hasWon = true;
                    break;
                }
            }


        for (int spalte = 0; spalte <= 2; spalte++)  //Diagonal
            for (int reihe = 0; reihe <= 3; reihe++) {
                if (playground[spalte][reihe] == playerId && playground[spalte + 1][reihe + 1] == playerId && playground[spalte + 2][reihe + 2] == playerId && playground[spalte + 3][reihe + 3] == playerId) {
                    hasWon = true;
                    break;
                }
            }


        for (int spalte = 0; spalte < 3; spalte++) {
            for (int reihe = 6; reihe > 2; reihe--) {
                if (playground[spalte][reihe] == playerId && playground[spalte + 1][reihe - 1] == playerId && playground[spalte + 2][reihe - 2] == playerId && playground[spalte + 3][reihe - 3] == playerId) {
                    hasWon = true;
                    break;
                }
            }
        }


        if (hasWon) {

            if (playerId == 1) {
                System.out.println(player1.getName() + " has Won");
            } else {
                System.out.println(player2.getName() + " has Won");
            }

            System.out.println("If you wanna play again type (0) to quit type (1)");
            String inputStop = systemInputScanner.nextLine();

            int newRound = Integer.parseInt(inputStop);

            if (newRound == 1) {
                System.exit(0);
            } else if (newRound == 0) {

                for (int resetRow = 0; resetRow < playground.length; resetRow++) {
                    for (int resetColumn = 0; resetColumn < playground[resetRow].length; resetColumn++) {
                        playground[resetRow][resetColumn] = 0;
                        Playfield.columnCounter = 0;
                    }
                }
                column = 0;
            } else {
                System.out.println();
                System.out.println(" If you wanna play again type (0) to quit type (1)!!!");
            }
        }
    }
}