package queue;

import java.util.List;

public class EmptyQueue extends StatesQueue {

    public Object take(List<Object> queue) {
        throw new Error ( "Queue is empty" );
    }

    public Object head(List<Object> queue) {
        throw new Error ( "Queue is empty" );
    }
}
