package rv.list;
/**
 * Design an int type singly linkedlist class, and then implement some functions below using the self designed class.
 * Can not use Java built in List interface
 * 1. Append an element into the linkedlist
 * 2. Remove the tail element from a linkedlist
 * 3. Remove all element in the linkedlist that is great than a target value
 * 
 * @author ruchitav
 *
 */
public class SinglyLinkedList {
	private Node start;
	private Node end;
	private int size;

	public SinglyLinkedList() {
		this.start = null;
		this.end = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return this.start == null;
	}

	public int size() {
		return this.size;
	}

	/**
	 * Append an element into the linkedlist
	 * @param val
	 */
	public void insertAtEnd(int val) {
		Node node = new Node(val, null);
		this.size++;
		if (this.start == null) {
			this.start = node;
			this.end = start;
		} else {
			this.end.setNext(node);
			this.end = node;
		}
	}

	/**
	 * Remove the tail element from a linkedlist
	 */
	public void deleteLast() {
		Node s = this.start;
		Node t = this.start;
		while (s != this.end) {
			t = s;
			s = s.getNext();
		}
		this.end = t;
		this.end.setNext(null);
		this.size--;
	}

	/**
	 * Remove all element in the linkedlist that is great than a target value
	 * @param el
	 */
	public void deleteHigherNodes(int el) {
		if (!isEmpty()) {
			Node current = this.start;
			Node prev = null;
			while (current != null) {
				//If greater than given value
				if (current.getData() > el) {
					//If not last element
					if (current.getNext() != null) {
						if (current == this.start) {
							this.start = current.getNext();
							current.setNext(null);
							current = this.start;
						} else {
							if(prev !=null)
								prev.setNext(current.getNext());
							current = current.getNext();
						}
						this.size--;
					} 
					//If last element
					else {
						deleteLast();
						current = null;
					}
				} 
				//If less than given value
				else {
					prev = current;
					current = current.getNext();
				}
			}
		}
	}

	/**
	 * Print linkedlist
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		if (isEmpty()) {
			sb.append("]");
			return sb.toString();
		}
		
		Node node = this.start;
		sb.append(this.start.getData());
		if (this.start.getNext() == null) {
			sb.append("]");
			return sb.toString();
		}		
		node = this.start.getNext();

		while (node.getNext() != null) {
			sb.append(",");
			sb.append(node.getData());
			node = node.getNext();
		}
		sb.append(",");
		sb.append(node.getData());
		sb.append("]");
		return sb.toString();
	}
	
	public int getLast() {
		return this.end.getData();
	}
	
	public int getFirst() {
		return this.start.getData();
	}
	
	class Node {
		private int data;
		private Node next;

		public Node() {
			this.next = null;
			this.data = 0;
		}

		public Node(int d, Node n) {
			this.data = d;
			this.next = n;
		}

		public void setNext(Node n) {
			this.next = n;
		}

		public void setData(int d) {
			this.data = d;
		}

		public Node getNext() {
			return this.next;
		}

		public int getData() {
			return this.data;
		}
	}
}