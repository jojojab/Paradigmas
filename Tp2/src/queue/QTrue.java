package queue;

public class QTrue extends Queue {
    public QTrue(){
        super();
    }
    public Object take() {
        // TODO Auto-generated method stub
            return queue.remove( 0 );

    }
}
