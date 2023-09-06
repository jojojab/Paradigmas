package queue;

public abstract class AbstractQueue {

    static Queue True() {return new QTrue();}

    static Queue False() {return new QFalse();}

    public boolean equals(Object other) {
        return other.getClass() == getClass();
    }
    public abstract Object take();
    // TODO Auto-generated method stub

}
