
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestNemo {

    @Test
    public void initialPositionNemo() {
        assertEquals( initialPosition() , new Nemo().position());
    }

    @Test
    public void initialDirectionNemo() {
        assertEquals( initialDirection() , new Nemo().direction());
    }

    @Test
    public void initialStatusBrownie() { assertEquals( brownieNotReleased() , new Nemo().statusBrownie()); }

    @Test
    public void noMove() {
        Nemo nemo = new Nemo();
        nemo.move("");
        assertEquals( initialPosition() , nemo.position());
        assertEquals( initialDirection() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void moveForward(){
        Nemo nemo = new Nemo();
        nemo.move("f");
        assertEquals( Arrays.asList(1,0,0) , nemo.position());
        assertEquals( initialDirection() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void turnRight(){
        Nemo nemo = new Nemo();
        nemo.move("r");
        assertEquals( initialPosition() , nemo.position());
        assertEquals( oneTurnRight() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void turnLeft(){
        Nemo nemo = new Nemo();
        nemo.move("l");
        assertEquals( initialPosition() , nemo.position());
        assertEquals( oneTurnLeft() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void goDown() {
        Nemo nemo = new Nemo();
        nemo.move("d");
        assertEquals(oneDown(), nemo.position());
        assertEquals(initialDirection(), nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void goUp(){
        Nemo nemo = new Nemo();
        nemo.move("u");
        assertEquals(initialPosition(), nemo.position());
        assertEquals(initialDirection(), nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void succesFullReleaseOfBrownie(){
        Nemo nemo = new Nemo();
        nemo.move("m");
        assertEquals(initialPosition(), nemo.position());
        assertEquals(initialDirection(), nemo.direction());
        assertEquals(succesfullReleaseBrownie(), nemo.statusBrownie());
    }

    @Test
    public void moveForwadAndUpwardsWithoutBeingAboveTheSurface(){
        Nemo nemo = new Nemo();
        nemo.move("fuuu");
        assertEquals(Arrays.asList(1,0,0), nemo.position());
        assertEquals(initialDirection(), nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void moveTwiceForward(){
        Nemo nemo = new Nemo();
        nemo.move("ff");
        assertEquals( Arrays.asList(2,0,0) , nemo.position());
        assertEquals( initialDirection() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void turnRightThenMoveForward(){
        Nemo nemo = new Nemo();
        nemo.move("rf");
        assertEquals( Arrays.asList(0,-1,0) , nemo.position());
        assertEquals( oneTurnRight() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void moveDownAndTurnLeft(){
        Nemo nemo = new Nemo();
        nemo.move("dl");
        assertEquals( oneDown() , nemo.position());
        assertEquals( oneTurnLeft() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void releaseBrownieInFirstLevel(){
        Nemo nemo = new Nemo();
        nemo.move("dm");
        assertEquals( oneDown() , nemo.position());
        assertEquals( initialDirection() , nemo.direction());
        assertEquals(succesfullReleaseBrownie(), nemo.statusBrownie());
    }
    @Test
    public void turnRightThenLeft(){
        Nemo nemo = new Nemo();
        nemo.move("rl");
        assertEquals( initialPosition() , nemo.position());
        assertEquals( initialDirection() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }
    @Test
    public void moveDownThenUp(){
        Nemo nemo = new Nemo();
        nemo.move("du");
        assertEquals( initialPosition() , nemo.position());
        assertEquals( initialDirection() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }
    @Test
    public void moveUpThenDown(){
        Nemo nemo = new Nemo();
        nemo.move("ud");
        assertEquals( oneDown() , nemo.position());
        assertEquals( initialDirection() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }
    @Test
    public void nemoExplodesWhenTryingToReleaseBrownie(){
        Nemo nemo = new Nemo();
        assertThrowsLike( () -> nemo.move("ddm"), unsuccessfulReleaseBrownie());
    }

    private void assertThrowsLike(Executable executable, String message ) {

        Assertions.assertEquals( message,
                assertThrows( Exception.class, executable ).getMessage() );
    }

    private static String succesfullReleaseBrownie() {
        return "Incredible Chocolate Brownie Moment has been released unharmed";
    }

    private static String brownieNotReleased() {
        return "Brownie not released";
    }

    private static String unsuccessfulReleaseBrownie() {
        return "Nemo has been destroyed, Reason: trying to release brownie below the first level";
    }

    private List<Integer> initialPosition() {
        return Arrays.asList(0,0,0);
    }
    private Integer initialDirection() {
        return 0;
    }
    private Integer oneTurnRight(){
        return 270;
    }
    private Integer oneTurnLeft(){
        return 90;
    }
    private List<Integer> oneDown(){
        return Arrays.asList(0,0,-1);
    }
}
