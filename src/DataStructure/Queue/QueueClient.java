//TODO 

package DataStructure.Queue;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Queue q1 = new Queue();

		q1.enqueue(1);
		displayQueueInfo(q1);

		q1.enqueue(2);
		displayQueueInfo(q1);

		q1.enqueue(3);
		displayQueueInfo(q1);

		q1.enqueue(4);
		displayQueueInfo(q1);

		q1.enqueue(5);
		displayQueueInfo(q1);

		q1.dequeue();
		displayQueueInfo(q1);

		q1.dequeue();
		displayQueueInfo(q1);

		q1.dequeue();
		displayQueueInfo(q1);

		q1.dequeue();
		displayQueueInfo(q1);

		q1.dequeue();
		displayQueueInfo(q1);

	}

	public static void displayQueueInfo(Queue q1) {

		q1.size();
		q1.isEmpty();
		q1.display();

	}

}
