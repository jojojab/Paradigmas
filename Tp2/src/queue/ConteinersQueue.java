package queue;

import java.util.List;

public abstract class ConteinersQueue {

    public abstract Object take(List<Object> queue);

    public abstract Object head(List<Object> queue);

}
