import java.util.Scanner;

public class VierGewinnt {

    static boolean playerOne = true;

    static int column = 0;

    static WinnersDetermination winnersDetermination = new WinnersDetermination();

    static Player player1 = new Player();
    static Player player2 = new Player();


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

        int playerId = playerOne ? 1 : 2;

        if (winnersDetermination.determinateWinner(playfield, playerId)) {

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
            }
            else if (newRound == 0) {

                for (int resetRow = 0; resetRow < playground.length; resetRow++) {
                    for (int resetColumn = 0; resetColumn < playground[resetRow].length; resetColumn++) {
                        playground[resetRow][resetColumn] = 0;
                        playfield.resetColumnFillLevel();
                    }
                }
            }
        }
    }
}