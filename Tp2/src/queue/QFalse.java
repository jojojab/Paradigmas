package queue;

public class QFalse extends Queue{
    public QFalse(){
        super();
    }

    public Object take() {
        // TODO Auto-generated method stub
            throw new Error( "Queue is empty");
    }
}

