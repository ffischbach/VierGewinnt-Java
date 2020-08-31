public class Playfield {

    final int ROWS = 6;
    final int COLUMNS = 7;

    int[][] playgroundSize = new int[ROWS][COLUMNS];
    int[] columnFillLevel = new int[COLUMNS];
    static int rowCounter;

    static int columnCounter;

    public void setToken(boolean playerOne, int column) {
        int startHeight = 5;
        int heightNewToken = startHeight - columnFillLevel[column];
        if (playerOne) {
            playgroundSize[heightNewToken][column] = 1;
        } else {
            playgroundSize[heightNewToken][column] = 2;
        }
        columnFillLevel[column] = columnFillLevel[column] + 1;
    }

    public void printField(Player player1, Player player2) {


        System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        System.out.println("|___|___|___|___|___|___|___|");

        for (rowCounter = 0; rowCounter < ROWS; rowCounter++) {
            System.out.println("|   |   |   |   |   |   |   |");

            for (columnCounter = 0; columnCounter < COLUMNS; columnCounter++) {

                if (playgroundSize[rowCounter][columnCounter] == 0) {
                    System.out.print("| " + " " + " ");
                } else if (playgroundSize[rowCounter][columnCounter] == 1) {
                    System.out.print("| " + player1.getToken() + " ");
                } else if (playgroundSize[rowCounter][columnCounter] == 2) {
                    System.out.print("| " + player2.getToken() + " ");
                }

            }

            System.out.print("|");
            System.out.println();
            System.out.println("|___|___|___|___|___|___|___|");
        }

        System.out.println();
    }
}
