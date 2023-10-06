
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestNemo {

    @Test
    public void initialPositionNemo() {
        assertEquals( initialPosition() , new Nemo().position());
    }

    @Test
    public void initialAltitudeNemo() {
        assertEquals( initialAltitude() , new Nemo().altitude());
    }

    @Test
    public void initialDirectionNemo() {
        assertEquals( initialDirection() , new Nemo().direction());
    }

    @Test
    public void noMove() {
        Nemo nemo = new Nemo();
        nemo.move("");
        assertEquals( initialPosition() , nemo.position());
        assertEquals( initialAltitude() , nemo.altitude());
        assertEquals( initialDirection() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void moveForward(){
        Nemo nemo = new Nemo();
        nemo.move("f");
        assertEquals( Arrays.asList(1,0) , nemo.position());
        assertEquals( initialAltitude() , nemo.altitude());
        assertEquals( initialDirection() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void turnRight(){
        Nemo nemo = new Nemo();
        nemo.move("r");
        assertEquals( initialPosition() , nemo.position());
        assertEquals( initialAltitude() , nemo.altitude());
        assertEquals( oneTurnRight() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void turnLeft(){
        Nemo nemo = new Nemo();
        nemo.move("l");
        assertEquals( initialPosition() , nemo.position());
        assertEquals( initialAltitude() , nemo.altitude());
        assertEquals( oneTurnLeft() , nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void goDown() {
        Nemo nemo = new Nemo();
        nemo.move("d");
        assertEquals(initialPosition(), nemo.position());
        assertEquals(oneDown(), nemo.altitude());
        assertEquals(initialDirection(), nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void goUp(){
        Nemo nemo = new Nemo();
        nemo.move("u");
        assertEquals(initialPosition(), nemo.position());
        assertEquals(oneUpOnSurface(), nemo.altitude());
        assertEquals(initialDirection(), nemo.direction());
        assertEquals(brownieNotReleased(), nemo.statusBrownie());
    }

    @Test
    public void succesFullReleaseOfBrownie(){
        Nemo nemo = new Nemo();
        nemo.move("m");
        assertEquals(initialPosition(), nemo.position());
        assertEquals(initialAltitude(), nemo.altitude());
        assertEquals(initialDirection(), nemo.direction());
        assertEquals(succesfullReleaseBrownie(), nemo.statusBrownie());
    }

    @Test
    public void moveTwiceForward(){
        Nemo nemo = new Nemo();
        nemo.move("ff");
        assertEquals( Arrays.asList(2,0) , nemo.position());
        assertEquals( initialAltitude() , nemo.altitude());
        assertEquals( initialDirection() , nemo.direction());
    }

    private static String succesfullReleaseBrownie() {
        return "Incredible Chocolate Brownie Moment has been released unharmed";
    }

    private static String brownieNotReleased() {
        return "Brownie not released";
    }

    private static String unsuccessfulReleaseBrownie() {
        return "Incredible Chocolate Brownie Moment has been released but is damaged";
    }

    private List<Integer> initialPosition() {
        return Arrays.asList(0,0);
    }
    private Integer initialAltitude() {
        return 0;
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
    private Integer oneDown(){
        return -1;
    }
    private Integer oneUpOnSurface(){
        return 0;
    }
}
