import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WinnersDeterminationTest {


    @Test
    void testEmptyPlayfieldShouldHasNoWinner() {
        WinnersDetermination winnersDetermination = new WinnersDetermination();
        assertFalse(winnersDetermination.determinateWinner(new Playfield(), 1));
    }
    @Test
    void fourHorizontalShouldHasWinner() {
        WinnersDetermination winnersDetermination = new WinnersDetermination();
        Playfield playfield = new Playfield();
        playfield.setToken(true, 0);
        playfield.setToken(true, 0);
        playfield.setToken(true, 0);
        playfield.setToken(true, 0);

        assertTrue(winnersDetermination.determinateWinner(playfield, 1));
    }

    @Test
    void fourVerikalShouldHasWinner() {
        WinnersDetermination winnersDetermination = new WinnersDetermination();
        Playfield playfield = new Playfield();
        playfield.setToken(true, 0);
        playfield.setToken(true, 1);
        playfield.setToken(true, 2);
        playfield.setToken(true, 3);

        assertTrue(winnersDetermination.determinateWinner(playfield, 1));
    }
    @Test
    void fourDiagonalRightShouldHasWinner() {
        WinnersDetermination winnersDetermination = new WinnersDetermination();
        Playfield playfield = new Playfield();
        playfield.setToken(true, 1);
        playfield.setToken(false,2);
        playfield.setToken(true, 2);
        playfield.setToken(false,3);
        playfield.setToken(false,3);
        playfield.setToken(true, 3);
        playfield.setToken(false, 4);
        playfield.setToken(false, 4);
        playfield.setToken(false, 4);
        playfield.setToken(true, 4);

        assertTrue(winnersDetermination.determinateWinner(playfield, 1));
    }
    @Test
    void fourDiagonalLeftShouldHasWinner() {
        WinnersDetermination winnersDetermination = new WinnersDetermination();


        Playfield playfield = new Playfield();
        playfield.setToken(false, 1);
        playfield.setToken(false, 1);
        playfield.setToken(false, 1);
        playfield.setToken(true, 1);
        playfield.setToken(false, 2);
        playfield.setToken(false, 2);
        playfield.setToken(true, 2);
        playfield.setToken(false, 3);
        playfield.setToken(true, 3);
        playfield.setToken(true, 4);

        assertTrue(winnersDetermination.determinateWinner(playfield, 1));
    }
}