package queue;

import java.util.List;

public abstract class StatesQueue {

    public abstract Object take(List<Object> queue);

    public abstract Object head(List<Object> queue);

}
