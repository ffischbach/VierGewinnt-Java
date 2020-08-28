import java.util.Scanner;

public class VierGewinnt {
    static int[][] playground = new int[6][7];
    static int rows = playground.length;
    static int columns = 7;

    static int[] columnFillLevel = new int[7];

    static boolean playerOne = true;

    static int column = 0;
    static int rowCounter;
    static int columnCounter;
    static Player player1 = new Player();
    static Player player2 = new Player();


    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            playerDefinition();
        }


        while (true) {
            printField();
            chooseColumn();
            playerRotation();
            setToken();
            printField();
            winCondition();

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

        System.out.println("Player 1 Please set your Token:");
        String tokenPlayer1 = systemInputScanner.nextLine();
        player1.setToken(tokenPlayer1);

        System.out.println("Player 2 Please set your Token:");
        String tokenPlayer2 = systemInputScanner.nextLine();
        player2.setToken(tokenPlayer2);
    }


    public static void printField() {


        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        System.out.println("|___|___|___|___|___|___|___|");

        for (rowCounter = 0; rowCounter < rows; rowCounter++) {
            System.out.println("|   |   |   |   |   |   |   |");

            for (columnCounter = 0; columnCounter < columns; columnCounter++) {

                if (playground[rowCounter][columnCounter] == 0) {
                    System.out.print("| " + " " + " ");
                } else if (playground[rowCounter][columnCounter] == 1) {
                    System.out.print("| " + player1.getToken() + " ");
                } else if (playground[rowCounter][columnCounter] == 2) {
                    System.out.print("| " + player2.getToken() + " ");
                }

            }

            System.out.print("|");
            System.out.println();
            System.out.println("|___|___|___|___|___|___|___|");
        }

        System.out.println();
    }

    private static void playerRotation() {

        playerOne = !playerOne;
    }

    public static void chooseColumn() {

        Scanner systemInputScanner = new Scanner(System.in);

        String input;

        if (playerOne) {
            System.out.print(player2.getName() + " please choose your column : ");
            input = systemInputScanner.nextLine();
        } else {
            System.out.println(player1.getName() + " please choose your column : ");
            input = systemInputScanner.nextLine();
        }

        try {
            column = Integer.parseInt(input) - 1;
        } catch (NumberFormatException exception) {
            System.out.println("Letters are not allowed please choose a Number between 1 and 7!!!");
            chooseColumn();
        }


        if (column < 0 || column > 6) {
            System.out.println();
            System.out.println("Please choose a Number between 1 and 7!!!");
            chooseColumn();
        } else if (columnFillLevel[column] > 5) {
            System.out.println("Column is full!!!");
            chooseColumn();
        }
    }

    public static void setToken() {
        int startHeight = 5;
        int heightNewToken = startHeight - columnFillLevel[column];
        if (playerOne) {
            playground[heightNewToken][column] = 1;
        } else {
            playground[heightNewToken][column] = 2;
        }
        columnFillLevel[column] = columnFillLevel[column] + 1;
    }

    public static void winCondition() {
        Scanner systemInputScanner = new Scanner(System.in);

        boolean hasWon = false;
        int Player;
        if (playerOne) {
            Player = 1;
        } else {
            Player = 2;
        }

        for (int columnCheck = 0; columnCheck <= 2; columnCheck++) //vertical
            for (int rowCheck = 0; rowCheck <= 6; rowCheck++) {
                if (playground[columnCheck][rowCheck] == Player && playground[columnCheck + 1][rowCheck] == Player && playground[columnCheck + 2][rowCheck] == Player && playground[columnCheck + 3][rowCheck] == Player) {
                    hasWon = true;
                    break;
                }
            }


        for (int columnCheck = 0; columnCheck <= 5; columnCheck++) //Horizontal
            for (int rowCheck = 0; rowCheck <= 3; rowCheck++) {
                if (playground[columnCheck][rowCheck] == Player && playground[columnCheck][rowCheck + 1] == Player && playground[columnCheck][rowCheck + 2] == Player && playground[columnCheck][rowCheck + 3] == Player) {
                    hasWon = true;
                    break;
                }
            }


        for (int columnCheck = 0; columnCheck <= 2; columnCheck++)  //Diagonal
            for (int rowCheck = 0; rowCheck <= 3; rowCheck++) {
                if (playground[columnCheck][rowCheck] == Player && playground[columnCheck + 1][rowCheck + 1] == Player && playground[columnCheck + 2][rowCheck + 2] == Player && playground[columnCheck + 3][rowCheck + 3] == Player) {
                    hasWon = true;
                    break;
                }
            }


        for (int columnCheck = 0; columnCheck < 3; columnCheck++) {
            for (int rowCheck = 6; rowCheck > 2; rowCheck--) {
                if (playground[columnCheck][rowCheck] == Player && playground[columnCheck + 1][rowCheck - 1] == Player && playground[columnCheck + 2][rowCheck - 2] == Player && playground[columnCheck + 3][rowCheck - 3] == Player) {
                    hasWon = true;
                    break;
                }
            }
        }

        if (Player == 1) {
            System.out.println(player1.getName() + " has Won");
        } else {
            System.out.println(player2.getName() + " has Won");
        }

        if (hasWon) {

            System.out.println("If you wanna play again type (0) to quit type (1)");
            String inputStop = systemInputScanner.nextLine();

            int newRound;

            newRound = Integer.parseInt(inputStop);

            if (newRound == 1) {
                System.exit(0);
            } else if (newRound == 0) {

                for (int resetRow = 0; resetRow < playground.length; resetRow++) {
                    for (int resetColumn = 0; resetColumn < playground[resetRow].length; resetColumn++) {
                        playground[resetRow][resetColumn] = 0;
                        columnFillLevel[resetColumn] = 0;
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
