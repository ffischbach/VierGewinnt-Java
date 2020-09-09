import java.util.Scanner;

public class VierGewinnt {

    static boolean playerOne = true;

    static int column = 0;

    static WinnersDetermination winnersDetermination = new WinnersDetermination();

    static Player player1;
    static Player player2;

    VierGewinnt(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public static boolean playerRotation() {

        playerOne = !playerOne;
        return playerOne;
    }

    public int chooseColumn(Playfield playfield) {

        Scanner systemInputScanner = new Scanner(System.in);

        String input;

        if (playerOne) {
            System.out.print(player1.name + " please choose your column : ");
            input = systemInputScanner.nextLine();
        } else {
            System.out.println(player2.name + " please choose your column : ");
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

        return column;
    }


    public static void winCondition(Playfield playfield) {
        int[][] playground = playfield.getPlayground();

        Scanner systemInputScanner = new Scanner(System.in);

        int playerId = playerOne ? 1 : 2;

        if (winnersDetermination.determinateWinner(playfield, playerId)) {

            if (playerId == 1) {
                System.out.println(player1.name + " has Won");
            } else {
                System.out.println(player2.name + " has Won");
            }

            System.out.println("If you want to play again type (0) to quit type (1)");
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