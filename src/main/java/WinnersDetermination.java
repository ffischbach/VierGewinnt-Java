public class WinnersDetermination {
    static boolean hasWon = false;

    public boolean determinateWinner(PlayField playfield, int playerId) {
        return checkVertical(playfield, playerId) || checkHorizontal(playfield, playerId) || checkDiagonalRight(playfield, playerId) || checkDiagonalLeft(playfield, playerId);
    }

    public boolean checkHorizontal(PlayField playfield, int playerId) {
        int[][] playground = playfield.getPlayground();
        for (int spalte = 0; spalte <= 5; spalte++)
            for (int reihe = 0; reihe <= 3; reihe++) {
                if (playground[spalte][reihe] == playerId && playground[spalte][reihe + 1] == playerId && playground[spalte][reihe + 2] == playerId && playground[spalte][reihe + 3] == playerId) {
                    hasWon = true;
                    return true;
                }
            }
        return false;
    }

    public boolean checkVertical(PlayField playfield, int playerId) {
        int[][] playground = playfield.getPlayground();

        for (int spalte = 0; spalte <= 2; spalte++)
            for (int reihe = 0; reihe <= 6; reihe++) {
                if (playground[spalte][reihe] == playerId && playground[spalte + 1][reihe] == playerId && playground[spalte + 2][reihe] == playerId && playground[spalte + 3][reihe] == playerId) {
                    hasWon = true;
                    return true;
                }
            }
        return false;
    }

    public boolean checkDiagonalRight(PlayField playfield, int playerId) {
        int[][] playground = playfield.getPlayground();
        for (int spalte = 0; spalte <= 2; spalte++)  //Diagonal
            for (int reihe = 0; reihe <= 3; reihe++) {
                if (playground[spalte][reihe] == playerId && playground[spalte + 1][reihe + 1] == playerId && playground[spalte + 2][reihe + 2] == playerId && playground[spalte + 3][reihe + 3] == playerId) {
                    hasWon = true;
                    return true;

                }
            }
        return false;
    }

    public boolean checkDiagonalLeft(PlayField playfield, int playerId) {
        int[][] playground = playfield.getPlayground();


        for (int spalte = 0; spalte < 3; spalte++) {
            for (int reihe = 6; reihe > 2; reihe--) {
                if (playground[spalte][reihe] == playerId && playground[spalte + 1][reihe - 1] == playerId && playground[spalte + 2][reihe - 2] == playerId && playground[spalte + 3][reihe - 3] == playerId) {
                    hasWon = true;
                    return true;
                }
            }
        }
        return false;
    }
}
