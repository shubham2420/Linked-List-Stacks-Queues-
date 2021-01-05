/**
 * Description: Queue class that has queue specific methods
 * @author shubhamkamboj
 * Pre: List must be in the same package 
 * Post: none 
 */
public class Queue extends List{
	/**
	 * Description: constructor for the queue class 
	 * Pre: none 
	 * Post: none 
	 */
	public Queue() {
		super(); //calls the super constructor 
	}
	
	/**
	 * Description: main method that tests boundary condiitons for the queue class 
	 * @param args
	 * @throws LinkedListException
	 * Pre: none
	 * Post: none 
	 */
	public static void main(String[] args) throws LinkedListException {
		Queue newQueue = new Queue(); //constructs a empty queue 
		System.out.println(newQueue.isEmpty());
		try {
			newQueue.dequeue();
		}catch(LinkedListException e) { //catches linked list exception 
			System.out.println("Cant dequeue from an empty queue");
		}
		newQueue.enqueue(1);
		System.out.println(newQueue.isEmpty());
		System.out.println(newQueue);
		newQueue.enqueue(2);
		System.out.println(newQueue);
		newQueue.enqueue(3);
		System.out.println(newQueue.dequeue());
		System.out.println(newQueue);
		newQueue.enqueue(4);
		System.out.println(newQueue.dequeue());
		System.out.println(newQueue);
		newQueue.enqueue(5);
		System.out.println(newQueue);
		newQueue.enqueue("Joe");
		System.out.println(newQueue);
		Queue newQueue2 = new Queue();
		newQueue2.enqueue(1);
		System.out.println(newQueue2);
		newQueue2.enqueue(2);
		System.out.println(newQueue2);
		newQueue2.enqueue(3);
		System.out.println(newQueue2);
		newQueue2.enqueue(4);
		System.out.println(newQueue2);
		newQueue2.enqueue(5);
		System.out.println(newQueue2);
		newQueue2.enqueue("Joe");
		System.out.println(newQueue.equals(newQueue2));
		newQueue2.dequeue();
		newQueue2.dequeue();
		System.out.println(newQueue2);
		System.out.println(newQueue.equals(newQueue2));
		Queue newQueue3 = new Queue();
		System.out.println(newQueue2.equals(newQueue3));
		
	}
	/**
	 * Description: adds the object to the end of the queue
	 * @param next
	 * @throws LinkedListException
	 * Pre: none 
	 * Post: none 
	 */
	public void enqueue(Object next) throws LinkedListException {
		super.insert(next, this.size()); //calls the parent classes insert method 
	}
	/**
	 * Description: removes the first object in the list 
	 * @return object in the beginning of the queue 
	 * @throws LinkedListException
	 * Pre: none 
	 * Post: none 
	 */
	public Object dequeue() throws LinkedListException {
		return super.remove(0); //calls the parent classes dequeue method 
	}
	/**
	 * Description: overrides the remove method in super so it cannot be used in queue
	 * Pre: none 
	 * Post: none 
	 */
	public Object remove(int index) throws LinkedListException {
		throw new LinkedListException("Method not valid");
	}
	/**
	 * Description: overrides the insert method in super so it cannot be used in queue
	 * Pre: none 
	 * Post: none 
	 */
	public void insert(Object newData, int index) throws LinkedListException{
		throw new LinkedListException("Method not valid");
	}
	/**
	 * Description: overrides the delete method in super so it cannot be used in queue
	 * Pre: none 
	 * Post: none 
	 */
	public void delete(int index) throws LinkedListException{
		throw new LinkedListException("Method not valid");
	}
	/**
	 * Description: overrides the append method in super so it cannot be used in queue
	 * Pre: none 
	 * Post: none 
	 */
	public void append(int index) throws LinkedListException{
		throw new LinkedListException("Method not Valid");
	}
}
