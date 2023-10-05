
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

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
    }

    @Test
    public void moveForward(){
        Nemo nemo = new Nemo();
        nemo.move("f");
        assertEquals( Arrays.asList(1,0) , nemo.position());
        assertEquals( initialAltitude() , nemo.altitude());
        assertEquals( initialDirection() , nemo.direction());
    }

    @Test
    public void turnRight(){
        Nemo nemo = new Nemo();
        nemo.move("r");
        assertEquals( initialPosition() , nemo.position());
        assertEquals( initialAltitude() , nemo.altitude());
        assertEquals( oneTurnRight() , nemo.direction());
    }

    @Test
    public void turnLeft(){
        Nemo nemo = new Nemo();
        nemo.move("l");
        assertEquals( initialPosition() , nemo.position());
        assertEquals( initialAltitude() , nemo.altitude());
        assertEquals( oneTurnLeft() , nemo.direction());
    }

    @Test
    public void goDown() {
        Nemo nemo = new Nemo();
        nemo.move("d");
        assertEquals(initialPosition(), nemo.position());
        assertEquals(oneDown(), nemo.altitude());
        assertEquals(initialDirection(), nemo.direction());
    }

    @Test
    public void goUp(){
        Nemo nemo = new Nemo();
        nemo.move("u");
        assertEquals(initialPosition(), nemo.position());
        assertEquals(oneUpOnSurface(), nemo.altitude());
        assertEquals(initialDirection(), nemo.direction());
    }

    public List<Integer> initialPosition() {
        return Arrays.asList(0,0);
    }
    public Integer initialAltitude() {
        return 0;
    }
    public Integer initialDirection() {
        return 0;
    }
    public Integer oneTurnRight(){
        return 270;
    }
    public Integer oneTurnLeft(){
        return 90;
    }
    public Integer oneDown(){
        return -1;
    }
    public Integer oneUpOnSurface(){
        return 0;
    }
}
