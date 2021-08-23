public class Playfield {

    final int ROWS = 6;
    final int COLUMNS = 7;

    int[][] playground = new int[ROWS][COLUMNS];
    int[] columnFillLevel = new int[COLUMNS];


    int startHeight = 5;
    static int rowCounter;
    public static int columnCounter;


    public int[][] getPlayground() {
        return playground;
    }

    public boolean isColumnFull(int column) {
        return columnFillLevel[column] > 5;
    }

    public void setToken(boolean playerOne, int column) {
        int heightNewToken = startHeight - columnFillLevel[column];
        if (playerOne) {
            playground[heightNewToken][column] = 1;
        } else {
            playground[heightNewToken][column] = 2;
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

                if (playground[rowCounter][columnCounter] == 0) {
                    System.out.print("| " + " " + " ");
                } else if (playground[rowCounter][columnCounter] == 1) {
                    System.out.print("| " + player1.token + " ");
                } else if (playground[rowCounter][columnCounter] == 2) {
                    System.out.print("| " + player2.token + " ");
                }

            }

            System.out.print("|");
            System.out.println();
            System.out.println("|___|___|___|___|___|___|___|");
        }

        System.out.println();
    }
    public void resetColumnFillLevel(){

        columnFillLevel = new int[COLUMNS];
    }
}
