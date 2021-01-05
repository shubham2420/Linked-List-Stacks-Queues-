/**
 * Description: List class that implements the inner class nodes 
 * @author shubhamkamboj
 *Pre:Node class must be defined within 
 *Post: none 
 */
public class List {
	private Node head; 
	/**
	 * Description: Node class that contains an object item, node next and node previous
	 * @author shubhamkamboj
	 *Pre: none 
	 *Post: none 
	 */
	private class Node{
		private Object item; //stores object as an item
		private Node next; //node for next
		private Node previous; //node for previous 
		/**
		 * Decription: constructor for node 
		 * @param item
		 * @param next
		 * Pre: none 
		 * Post: none 
		 */
		private Node(Object item , Node next) {
			this.item = item;
			this.next = next;
			this.previous = null;
		}
		/**
		 * Description: constructor for node with 3 arguments 
		 * @param item
		 * @param next
		 * @param previous
		 * Pre: none 
		 * Post: none 
		 */
		private Node(Object item, Node next, Node previous) {
			this.item = item;
			this.next = next;
			this.previous = previous;
		}
	}
	/**
	 * Description: main method that runs tests for the list class 
	 * @param args
	 * @throws LinkedListException
	 * Pre: none 
	 * Post: none 
	 */
	public static void main(String[] args) throws LinkedListException {
		List newList = new List(); //constructs new list 
		try {
			newList.remove(0);
		}catch(LinkedListException e) {
			System.out.println("Cant remove from an empty list");
		}
		System.out.println(newList.isEmpty()); // runs multiple tests for list 
		newList.insert(7, 0);
		System.out.println(newList);
		newList.insert(8, 1);
		System.out.println(newList);
		newList.insert(9, 2);
		System.out.println(newList);
		newList.insert(10, 3);
		System.out.println(newList);
		System.out.println(newList.isEmpty());
		newList.insert(11, 4);
		System.out.println(newList);
		newList.insert(12, 5);
		System.out.println(newList);
		newList.insert(3, 6);
		System.out.println(newList);
		newList.insert(2, 7);
		System.out.println(newList);
		newList.insert(7, 2);
		System.out.println(newList);
		try {
			newList.remove(19);
		}catch(LinkedListException e) {
			System.out.println("Cant remove elements past the size of the list");
		}
		try {
			newList.insert(20000, 29);
		}catch(LinkedListException e) {
			System.out.println("Cant insert at element greater than the size of the list");
		}
		System.out.println(newList);
		System.out.println(newList.size());
		System.out.println(newList.remove(8));
		System.out.println(newList);
		System.out.println(newList.remove(4));
		System.out.println(newList);
		System.out.println(newList.remove(3));
		System.out.println(newList);
		newList.delete(3);
		System.out.println(newList);
		newList.delete(4);
		System.out.println(newList);
		newList.delete(0);
		System.out.println(newList);
		newList.append(100);
		System.out.println(newList);
		newList.append(200);
		System.out.println(newList);
		System.out.println(newList.indexOf(200));
		List newList2 = new List();
		newList2.append(8);
		newList2.append(7);
		newList2.append(12);
		newList2.append(100);
		newList2.append(200);
		newList2.remove(1);
		System.out.println(newList2);
		System.out.println(newList.equals(newList2));
		newList2.insert(7, 1);
		System.out.println(newList2);
		System.out.println(newList.equals(newList2));
	}
	/**
	 * Description: constructor for list class 
	 * Pre: none 
	 * Post: none 
	 */
	public List() {
		this.head = null; 
	}
	/**
	 * Description: insert method that inserts the object at the desired index 
	 * @param newData
	 * @param index
	 * @throws LinkedListException
	 * Pre: none 
	 * Post: none 
	 */
	public void insert(Object newData, int index) throws LinkedListException {
		if(this.size() < index) { //throws exception if trying to add at an index greater than size 
			throw new LinkedListException();
		}else {
			if(this.size() == 0) { // if size is 0
				Node newNode = new Node(newData, null);
				this.head = newNode;
			}else if(index == 0 && this.size() > 0) { // inserting at the head 
				Node prev = head;
				Node newNode = new Node(newData, head.next);
				this.head = newNode;
				prev.previous = newNode;
				newNode.next = prev;
			}else if(index > 0 && index < this.size()-1) { // inserting in the middle of the list 
				Node prev = head;  
				for(int i = 0; i < index -1; i++) {
					prev = prev.next;
				}
				Node newNode = new Node(newData, prev.next, prev);
				prev.next = newNode;
				prev.next.previous = newNode;
			}else if(index == this.size()-1) { //inserting at the end of the list 
				Node prev = head;
				for(int i = 0; i < this.size()-1; i ++) {
					prev = prev.next;
				}
				Node newNode = new Node(newData, null);
				prev.next = newNode;
				newNode.previous = prev;
			}else {
		Node newNode = new Node(newData, null); // creates a new node with new data 
		Node prev = head;
		for(int i =0; i < this.size()-1; i ++) { // finds previous node
			prev = prev.next;
		}
		prev.next = newNode;
		newNode.previous = prev;
			}
		}
	}
	/**
	 * Description: removes the object at the desired index 
	 * @param index
	 * @return object at the desired index 
	 * @throws LinkedListException
	 * Pre: none 
	 * Post: none 
	 */
	public Object remove(int index) throws LinkedListException {
		if(this.size() == 0 || this.size() < index) { // if trying to remove from an empty list or removing at
			throw new LinkedListException();			//an index greater than size 
		}
		if(this.size() == 1 && index == 0) { //removes the head if size is 1
			Object retVal = head.item;
			this.head = null;
			return retVal;
		}
		if(this.size() > 1) { // if size is greater than 1
			Object retVal = null;
			if(index == 0) { // removes the object at index 0 
				Node ahead = head;
				for(int i = 0; i < 1; i++ ) {
					ahead = ahead.next;
				}
				retVal = head.item;
				ahead.previous = null;
				head = ahead;
				return retVal;
			}
			if(index == this.size() - 1) { // removes the last element of the list 
				Node current = head;
				for(int i = 0; i < this.size()-1; i ++) {
					current = current.next;
				}
				retVal = current.item;
				current.previous.next = null;
				current.previous = null;
				return retVal;
			}
			Node current = head; //removes element in the middle of the list 
			for(int i = 0; i < index; i ++) {
				current = current.next;
			}
			Node prev = head;
			for(int i = 0; i < index -1; i ++) {
				prev = prev.next;
			}
			retVal = current.item;
			prev.next = current.next;
			current.next.previous  = prev;
			current.next = null;
			current.previous = null;
			return retVal;
		}
		return null;
		
	}
	/**\
	 * Description: append method that inserts the desired object at the end of list
	 * @param newData
	 * @throws LinkedListException
	 * Pre: none 
	 * Post: none 
	 */
	public void append(Object newData) throws LinkedListException {
		this.insert(newData, this.size()); // redirects to insert method 
	}
	/**
	 * Description: delete method that deletes the object at the desired index
	 * @param index
	 * @throws LinkedListException
	 * Pre: none 
	 * Post: none 
	 */
	public void delete(int index) throws LinkedListException {
		if(this.size() == 0 || this.size() < index) { //throws exceptions 
			throw new LinkedListException();
		}
		if(this.size() == 1 && index == 0) {
			this.head = null;
		}
		if(this.size() > 1) { // if size is greater than 1 
			if(index == 0) {
				Node ahead = head;
				for(int i = 0; i < 1; i++ ) {
					ahead = ahead.next;
				}
				ahead.previous = null;
				head = ahead;
			}else if(index == this.size() - 1) { //deletes object at the end of the list 
				Node current = head;
				for(int i = 0; i < this.size()-1; i ++) {
					current = current.next;
				}
				current.previous.next = null;
				current.previous = null;
			}else {
			Node current = head;
			for(int i = 0; i < index; i ++) {
				current = current.next;
			}
			Node prev = head;
			for(int i = 0; i < index -1; i ++) {
				prev = prev.next;
			}
			prev.next = current.next;
			current.next.previous  = prev;
			current.next = null;
			current.previous = null;
			}
		}
	}
	/**
	 * Description: to string method that returns the list in a string form 
	 * Pre: none 
	 * Post: none 
	 */
	public String toString() {
		String retVal = ""; //returns string 
		Node currentPos = head;
		while(currentPos != null) { //adds the items to a string 
			retVal += currentPos.item + ",";
			currentPos = currentPos.next;
		}
		return retVal;
	}
	/**
	 * Description:a method that determines if a list is empty 
	 * @return boolean 
	 * Pre: none 
	 * Post: none 
	 */
	public boolean isEmpty() {
		if(this.size() == 0) {
			return true;
		}
		return false;
	}
	/**
	 * Description: finds the index of the desired object 
	 * @param target
	 * @return integer 
	 * Pre:none 
	 * Post: none 
	 */
	public int indexOf(Object target) {
		int retVal = -1; //returns -1 if object not found 
		int count = 0;
		Node currentPos = head;
		while(currentPos != null) { //searches for the object 
			if(currentPos.item.equals(target)) {
				retVal = count;
			}
			count++;
			currentPos = currentPos.next;
		}
		return retVal;
	}
	/**
	 * Description: equals method for the list 
	 * Pre: none 
	 * Post: none 
	 */
	public boolean equals(Object other) {
		if(other == null) { // if other is null
			return false;
		}
		else if(this.getClass() != other.getClass()) { //checks the classes of the objects 
			return false;
		}else {
			List toCompare = (List)other; //casts the object to a list 
			Node thisPos = this.head;
			Node otherPos = toCompare.head;
			while(thisPos != null && otherPos != null) {
				if(!(thisPos.item.equals(otherPos.item))) { //implements equals method for the object 
					return false;
				}else {
					thisPos = thisPos.next;
					otherPos = otherPos.next;
				}
			}
			if(thisPos == null && otherPos != null) {
				return false;
			}else if(thisPos != null && otherPos == null) {
				return false;
			}else {
				return true;
			}
		}
	}
	/**
	 * Description: calculates the size of the list 
	 * @return int 
	 * Pre: none 
	 * Post: None 
	 */
	public int size() {
		int retVal = 0; //default size 
		Node currentPos = head;
		while(currentPos != null) {
			retVal++; //increments size 
			currentPos = currentPos.next; //goes to the next node 
		}
		return retVal;
	}
}
