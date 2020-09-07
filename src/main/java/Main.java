public class Main {
    public static void main(String[] args) {

        int column = 0;

        Player player1 = new Player();
        Player player2 = new Player();


        Playfield playfield = new Playfield();

        VierGewinnt.playerDefinition();

        while (true) {
            playfield.printField(player1, player2);
            VierGewinnt.chooseColumn(playfield);
            playfield.setToken(playerOne, column);
            playfield.printField(player1, player2);
            VierGewinnt.winCondition(playfield);

        }
    }
}
