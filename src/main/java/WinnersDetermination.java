public class WinnersDetermination {

    public boolean determinateWinner(Playfield playfield, int playerId) {
        return checkVertical(playfield, playerId) || checkHorizontal(playfield, playerId) || checkDiagonalRight(playfield, playerId) || checkDiagonalLeft(playfield, playerId);
    }



    private boolean checkHorizontal(Playfield playfield, int playerId) {
        int[][] playground = playfield.getPlayground();
        for (int spalte = 0; spalte <= 5; spalte++) //Horizontal
            for (int reihe = 0; reihe <= 3; reihe++) {
                if (playground[spalte][reihe] == playerId && playground[spalte][reihe + 1] == playerId && playground[spalte][reihe + 2] == playerId && playground[spalte][reihe + 3] == playerId) {
                return true;
                }
            }
        return false;
    }

    private boolean checkVertical(Playfield playfield, int playerId) {
        int[][] playground = playfield.getPlayground();

        for (int spalte = 0; spalte <= 2; spalte++) //vertikal
            for (int reihe = 0; reihe <= 6; reihe++) {
                if (playground[spalte][reihe] == playerId && playground[spalte + 1][reihe] == playerId && playground[spalte + 2][reihe] == playerId && playground[spalte + 3][reihe] == playerId) {
                    return true;
                }
            }
        return false;
    }

    private boolean checkDiagonalRight(Playfield playfield, int playerId) {
        int[][] playground = playfield.getPlayground();
        for (int spalte = 0; spalte <= 2; spalte++)  //Diagonal
            for (int reihe = 0; reihe <= 3; reihe++) {
                if (playground[spalte][reihe] == playerId && playground[spalte + 1][reihe + 1] == playerId && playground[spalte + 2][reihe + 2] == playerId && playground[spalte + 3][reihe + 3] == playerId) {
                    return true;

                }
            }
        return false;
    }

    private boolean checkDiagonalLeft(Playfield playfield, int playerId) {
        int[][] playground = playfield.getPlayground();


        for (int spalte = 0; spalte < 3; spalte++) {
            for (int reihe = 6; reihe > 2; reihe--) {
                if (playground[spalte][reihe] == playerId && playground[spalte + 1][reihe - 1] == playerId && playground[spalte + 2][reihe - 2] == playerId && playground[spalte + 3][reihe - 3] == playerId) {
                    return true;

                }
            }
        }
        return false;
    }
}
