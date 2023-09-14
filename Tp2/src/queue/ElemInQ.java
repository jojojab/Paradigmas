package queue;

import java.util.List;

public class ElemInQ extends ConteinersQueue {

    public Object take(List<Object> queue) { return queue.remove(0); }

    public Object head(List<Object> queue) {
        return queue.get(0);
    }
}