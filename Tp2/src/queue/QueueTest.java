package queue;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class QueueTest {

  private String something = "Something";
  private String firstAddedObject = "First";
  private String secondAddedObject = "Second";

  @Test
  public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue(new Queue().isEmpty());
  }

  @Test
  public void test02AddElementsToTheQueue() {
    assertFalse(new Queue().add(something).isEmpty());
  }

  @Test
  public void test03AddedElementsIsAtHead() {
    assertEquals(something, new Queue().add(something).head());
  }

  @Test
  public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = new Queue().add(something);
    queue.take();

    assertTrue(queue.isEmpty());
  }

  @Test
  public void test05TakeReturnsLastAddedObject() {
    Queue queue = new Queue();
    queue.add(something);

    assertEquals(something, queue.take());
  }

  @Test
  public void test06QueueBehavesFIFO() {
    Queue queue = new Queue();

    queue.add(firstAddedObject);
    queue.add(secondAddedObject);

    assertEquals(queue.take(), firstAddedObject);
    assertEquals(queue.take(), secondAddedObject);
    assertTrue(queue.isEmpty());
  }

  @Test
  public void test07HeadReturnsFirstAddedObject() {
    Queue queue = new Queue();

    queue.add(firstAddedObject);
    queue.add(secondAddedObject);

    assertEquals(queue.head(), firstAddedObject);
  }

  @Test
  public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = new Queue();
    queue.add(something);
    assertEquals(1, queue.size());
    queue.head();
    assertEquals(1, queue.size());
  }

  @Test
  public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals(2, new Queue().add(firstAddedObject).add(secondAddedObject).size());
  }

  @Test
  public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    assertEquals("Queue is empty",
            assertThrows(Error.class, () -> queue.take()).getMessage());
  }

  @Test
  public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = new Queue();
    queue.add(something);
    queue.take();
    assertEquals("Queue is empty",
            assertThrows(Error.class, () -> queue.take()).getMessage());
  }

  @Test
  public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = new Queue();
    assertEquals("Queue is empty",
            assertThrows(Error.class, () -> queue.head()).getMessage());
  }
}
