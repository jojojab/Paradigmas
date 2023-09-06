package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Queue extends AbstractQueue{

	public List<Object> queue = new ArrayList<>();
  public boolean isEmpty() {
		// TODO Auto-generated method stub
      return queue.isEmpty();
  }

	public Queue add( Object  cargo ) {
		// TODO Auto-generated method stub
		queue.add( cargo );
		return this;
	}

	public Object take();
    // TODO Auto-generated method stub
	//	if (!queue.isEmpty())
	//		return queue.remove( 0 );
	//	else {
	//		throw new Error( "Queue is empty");
	//	}
	//}

	public Object head() {
		// TODO Auto-generated method stub
		if (!queue.isEmpty())
	  		return queue.get( 0 );
		else {
			throw new Error( "Queue is empty");
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}
}
