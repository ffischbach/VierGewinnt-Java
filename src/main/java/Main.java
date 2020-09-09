import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner systemInputScanner = new Scanner(System.in);

        Playfield playfield = new Playfield();


        System.out.println("Player 1 Please type your Name:");
        String namePlayer1 = systemInputScanner.nextLine();

        System.out.println(namePlayer1 + " Please set your Token:");
        String tokenPlayer1 = systemInputScanner.nextLine();

        Player player1 = new Player(namePlayer1, tokenPlayer1);


        System.out.println("Player 2 Please type your Name:");
        String namePlayer2 = systemInputScanner.nextLine();

        System.out.println(namePlayer2 + " Please set your Token:");
        String tokenPlayer2 = systemInputScanner.nextLine();

        Player player2 = new Player(namePlayer2, tokenPlayer2);

        VierGewinnt vierGewinnt = new VierGewinnt(player1, player2);

        while (true) {
            int column = vierGewinnt.chooseColumn(playfield);
            playfield.setToken(VierGewinnt.playerOne, column);
            playfield.printField(player1, player2);
            vierGewinnt.winCondition(playfield);
            vierGewinnt.playerRotation();
        }
    }
}
