import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestNemo {

    private static String succesfullReleaseBrownie() {
        return "Incredible Chocolate Brownie Moment has been released unharmed";
    }

    private static String brownieNotReleased() {
        return "Brownie not released";
    }

    private static String unsuccessfulReleaseBrownie() {
        return "Nemo has been destroyed, Reason: trying to release brownie below the first level";
    }

    private static List<Integer> initialPosition() {
        return Arrays.asList(0, 0, 0);
    }

    private static String east() {
        return "East";
    }

    private static String south() {
        return "South";
    }

    private static String north() {
        return "North";
    }

    private static String west() {
        return "West";
    }

    @Test
    public void initialPositionNemo() {
        assertEquals(initialPosition(), new Nemo().position());
    }

    @Test
    public void initialDirectionNemo() {
        assertEquals(east(), new Nemo().direction());
    }

    @Test
    public void initialStatusBrownie() {
        assertEquals(brownieNotReleased(), new Nemo().statusBrownie());
    }

    @Test
    public void noMove() {
        Nemo nemo = new Nemo();
        nemo.move("");
        equalsPositionDirectionAndBrownie(nemo, initialPosition(), east(), brownieNotReleased());
    }

    @Test
    public void moveForward() {
        Nemo nemo = new Nemo();
        nemo.move("f");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(1, 0, 0), east(), brownieNotReleased());
    }

    @Test
    public void turnRight() {
        Nemo nemo = new Nemo();
        nemo.move("r");
        equalsPositionDirectionAndBrownie(nemo, initialPosition(), south(), brownieNotReleased());
    }

    @Test
    public void turnLeft() {
        Nemo nemo = new Nemo();
        nemo.move("l");
        equalsPositionDirectionAndBrownie(nemo, initialPosition(), north(), brownieNotReleased());
    }

    @Test
    public void goDown() {
        Nemo nemo = new Nemo();
        nemo.move("d");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(0, 0, -1), east(), brownieNotReleased());
    }

    @Test
    public void goUp() {
        Nemo nemo = new Nemo();
        nemo.move("u");
        equalsPositionDirectionAndBrownie(nemo, initialPosition(), east(), brownieNotReleased());
    }

    @Test
    public void succesFullReleaseOfBrownie() {
        Nemo nemo = new Nemo();
        nemo.move("m");
        equalsPositionDirectionAndBrownie(nemo, initialPosition(), east(), succesfullReleaseBrownie());
    }

    @Test
    public void moveForwadAndUpwardsWithoutBeingAboveTheSurface() {
        Nemo nemo = new Nemo();
        nemo.move("fuuu");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(1, 0, 0), east(), brownieNotReleased());
    }

    @Test
    public void moveTwiceForward() {
        Nemo nemo = new Nemo();
        nemo.move("ff");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(2, 0, 0), east(), brownieNotReleased());
    }

    @Test
    public void turnRightThenMoveForward() {
        Nemo nemo = new Nemo();
        nemo.move("rf");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(0, -1, 0), south(), brownieNotReleased());
    }

    @Test
    public void moveDownAndTurnLeft() {
        Nemo nemo = new Nemo();
        nemo.move("dl");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(0, 0, -1), north(), brownieNotReleased());
    }

    @Test
    public void releaseBrownieInFirstLevel() {
        Nemo nemo = new Nemo();
        nemo.move("dm");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(0, 0, -1), east(), succesfullReleaseBrownie());
    }

    @Test
    public void turnRightThenLeft() {
        Nemo nemo = new Nemo();
        nemo.move("rl");
        equalsPositionDirectionAndBrownie(nemo, initialPosition(), east(), brownieNotReleased());
    }

    @Test
    public void moveDownThenUp() {
        Nemo nemo = new Nemo();
        nemo.move("du");
        equalsPositionDirectionAndBrownie(nemo, initialPosition(), east(), brownieNotReleased());
    }

    @Test
    public void moveUpThenDown() {
        Nemo nemo = new Nemo();
        nemo.move("ud");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(0, 0, -1), east(), brownieNotReleased());
    }

    @Test
    public void nemoExplodesWhenTryingToReleaseBrownie() {
        Nemo nemo = new Nemo();
        assertThrowsLike(() -> nemo.move("ddm"), unsuccessfulReleaseBrownie());
    }

    @Test
    public void moveDownMultipleTimesThenTryToReleaseBrownie() {
        Nemo nemo = new Nemo();
        assertThrowsLike(() -> nemo.move("ddddddm"), unsuccessfulReleaseBrownie());
    }

    @Test
    public void moveDownToAbyssThenGoUpAndReleaseBrownie() {
        Nemo nemo = new Nemo();
        nemo.move("ddum");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(0, 0, -1), east(), succesfullReleaseBrownie());
    }

    @Test
    public void moveForwardAndReleaseMultipleBrownies() {
        Nemo nemo = new Nemo();
        nemo.move("mfmdmfrfm");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(2, -1, -1), south(), succesfullReleaseBrownie());
    }

    @Test
    public void moveAround() {
        Nemo nemo = new Nemo();
        nemo.move("fflfdfmufrfrrffmdm");
        equalsPositionDirectionAndBrownie(nemo, Arrays.asList(1, 3, -1), west(), succesfullReleaseBrownie());
    }

    private void assertThrowsLike(Executable executable, String message) {
        Assertions.assertEquals(message,
                assertThrows(Exception.class, executable).getMessage());
    }

    private void equalsPositionDirectionAndBrownie(Nemo nemo, List<Integer> position, String direction, String brownie) {
        assertEquals(position, nemo.position());
        assertEquals(direction, nemo.direction());
        assertEquals(brownie, nemo.statusBrownie());
    }
}
