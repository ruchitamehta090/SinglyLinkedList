package rv.test.list;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import rv.list.SinglyLinkedList;

public class SinglyLinkedListTest {
    @Test public void testSize() {
    	SinglyLinkedList list = new SinglyLinkedList();
    	System.out.println("\nSingly Linked List insertAtEnd test\n");

		System.out.println("add 1");
		list.insertAtEnd(1);
		System.out.println("add 3");
		list.insertAtEnd(3);
		System.out.println("add 5");
		list.insertAtEnd(5);
		System.out.println("add 7");
		list.insertAtEnd(7);
		System.out.println("add 9");
		list.insertAtEnd(9);
		System.out.println("add 11");
		list.insertAtEnd(11);
		System.out.println("Result:"+list.toString());
        assertTrue("list size should be 6 ", list.size()==6);
    }
    
    @Test public void testHigherElementRemoval() {
    	SinglyLinkedList list = new SinglyLinkedList();
    	System.out.println("\nSingly Linked List remove higher elements test\n");
		list.insertAtEnd(1);
		list.insertAtEnd(3);
		list.insertAtEnd(5);
		list.insertAtEnd(7);
		list.insertAtEnd(9);
		list.insertAtEnd(11);
		System.out.println(list.toString());
		
		list.deleteHigherNodes(4);
		System.out.println("Result:"+list.toString());
        assertTrue("Remove all element great than 4 ", "[1,3]".equals(list.toString()));
    }
    
    @Test public void testRemoveLastElement() {
    	SinglyLinkedList list = new SinglyLinkedList();
    	System.out.println("\nSingly Linked List remove last element test\n");
		list.insertAtEnd(1);
		list.insertAtEnd(3);
		list.insertAtEnd(5);
		list.insertAtEnd(7);
		list.insertAtEnd(9);
		list.insertAtEnd(11);
		System.out.println(list.toString());
		
		list.deleteHigherNodes(4);
		System.out.println("Result:"+list.toString());
        assertTrue("Remove last element ", list.getLast()!=11);
    }
}
