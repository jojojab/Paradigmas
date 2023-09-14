package queue;

import java.util.ArrayList;
import java.util.List;

public class Queue{

	private List<Object> queue = new ArrayList<>();
	private Object temp;
	public ArrayList<ConteinersQueue> states = new ArrayList<>();
    {
        states.add(new EmptyQ());
    }

    public boolean isEmpty() {
		// TODO Auto-generated method stub
      return queue.isEmpty();
  }

	public Queue add( Object  cargo ) {
		// TODO Auto-generated method stub
		queue.add( cargo );
		states.add(new ElemInQ());
		return this;
	}
	public Object take(){
    // TODO Auto-generated method stub
		temp = states.get(states.size() - 1 ).take(queue);
		states.remove(states.size() - 1);
		return temp;
	}

	public Object head() {
		// TODO Auto-generated method stub
		return states.get(states.size()-1).head(queue);
	}

	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}
}