package ds.circularLinkedList;

import java.util.Iterator;

public class LinkedList implements Iterator<Object>{
	
	private Node head;
	private Node tail;
	private int length;
	private Node itObj;
	private int itrSize;
	
	public void add(Object obj) {
		Node node = new Node();
		node.value = obj;
		node.previous = tail;
		if (head == null) {
			tail = head = node;
		} else {
			tail = tail.next = node;
			head.previous = tail;
			tail.next = head;
		}
		length++;
	}

	public Object getFirst() {
		return head.value;
	}
	
	public Object getLast() {
		return tail.value;
	}
	
	public boolean isEmpty() {
		return length == 0;
	}
	
	public int indexOf() {
		
		return -1;
	}
	
	public Object get(int index) {
		if(index >= length) {
			return new ArrayIndexOutOfBoundsException("List index is out of bounds");
		}
		Node node = head;
		int i = 0;
		while (i<length) {
			node = node.next;
			i++;
		}
		return node.value;
	}
	
	public boolean contains(Object obj) {
		Node node = this.getDesiredNode(obj);
		if (node != null) {
			return true;
		}
		return false;
	}
	
	private Node getDesiredNode(Object obj) {
		Node node = head;
		int i = 0;
		while (i<length) {
			if(node.value.equals(obj)) {
				return node;
			}
			node = node.next;
			i++;
		}
		return null;
	}
	
	public Object remove(Object obj) {
		Node node = this.getDesiredNode(obj);
		if (node == null) {
			throw new ArrayIndexOutOfBoundsException("List index is out of bounds");
		}
		node.previous.next = node.next;
		node.next.previous = node.previous;
		length--;
		return obj;
	}
	
	public Iterator<Object> iterator() {
		this.itrSize = length;
		this.itObj = head;
		return this;
	}

	@Override
	public boolean hasNext() {
		
		return this.itrSize > 0;
	}

	@Override
	public Object next() {
		Object value = this.itObj.value;
		this.itObj = this.itObj.next;
		itrSize--;
		return value;
	}
}
