/**
 * Description: Stack class that shares the same functionality as stack 
 * @author shubhamkamboj
 * Pre: none  
 *Post: none 
 */
public class Stack extends List{
	/**
	 * Description: constructor for stack 
	 * Pre: none 
	 * Post: none 
	 */
	public Stack() {
		super(); // calls the parents constructor 
	}
	/**
	 * Description: main method that runs tests for the stack class
	 * @param args
	 * @throws LinkedListException
	 * Pre: none 
	 * Post: none 
	 */
	public static void main(String[] args) throws LinkedListException {
		Stack newStack = new Stack(); //creates a new stack 
		System.out.println(newStack.isEmpty());
		try {
			newStack.pop();
		}catch(LinkedListException e) {
			System.out.println("Cant pop from a empty Stack");
		}
		newStack.push("hi");
		System.out.println(newStack.isEmpty());
		System.out.println(newStack);
		newStack.push("hello");
		System.out.println(newStack.pop());
		System.out.println(newStack);
		newStack.push("joe");
		System.out.println(newStack);
		newStack.push("Seth");
		System.out.println(newStack.pop());
		System.out.println(newStack);
		newStack.push("Logan");
		System.out.println(newStack);
		Stack newStack2 = new Stack();
		newStack2.push("hi");
		newStack2.push("hello");
		newStack2.push("joe");
		newStack2.push("Seth");
		System.out.println(newStack.equals(newStack2));
		System.out.println(newStack2.pop());
		System.out.println(newStack2.pop());
		System.out.println(newStack2.pop());
		newStack2.push("joe");
		newStack2.push("Logan");
		System.out.println(newStack.equals(newStack2));
		Stack newStack3 = new Stack();
		System.out.println(newStack.equals(newStack3));
	}
	/**
	 * Description: pushes the desired object to the end of the list
	 * @param next
	 * @throws LinkedListException
	 * Pre: none 
	 * Post: none 
	 */
	public void push(Object next) throws LinkedListException {
		super.insert(next, this.size()); //calls the parent classes insert method 
	}
	/**
	 * Description: pops the object at the end of the stack 
	 * @return object 
	 * @throws LinkedListException
	 * Pre: none 
	 * Post:none 
	 */
	public Object pop() throws LinkedListException {
		return super.remove(super.size()-1); //calls the parent classes remove method 
	}
	/**
	 * Description: overrides the insert method in super so it cannot be used in stack
	 * Pre: none 
	 * Post: none 
	 */
	public void insert(Object newData, int index) throws LinkedListException {
		throw new LinkedListException("Method not valid");
	}
	/**
	 * Description: overrides the remove method in super so it cannot be used in stack
	 * Pre: none 
	 * Post: none 
	 */
	public Object remove(int index) throws LinkedListException{
		throw new LinkedListException("Method not valid");
	}
	/**
	 * Description: overrides the delete method in super so it cannot be used in stack
	 * Pre: none 
	 * Post: none 
	 */
	public void delete(int index) throws LinkedListException{
		throw new LinkedListException("Method not valid");
	}
	/**
	 * Description: overrides the append method in super so it cannot be used in stack
	 * Pre: none 
	 * Post: none 
	 */
	public void append(int index) throws LinkedListException{
		throw new LinkedListException("Method not Valid");
	}
}
