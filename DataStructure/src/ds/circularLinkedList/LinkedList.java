package ds.circularLinkedList;

import java.util.Iterator;

public class LinkedList implements Iterator<Object>{
	
	private Node head;
	private Node tail;
	private int size;
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
		size++;
	}

	public Object getFirst() {
		return head.value;
	}
	
	public Object getLast() {
		return tail.value;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int indexOf(Object obj) {
		Node node = head;
		int i = 0;
		while (i<size) {
			if (node.value.equals(obj)) {
				return i;
			}
			node = node.next;
			i++;
		}
		return -1;
	}
	
	public Object get(int index) {
		this.checkListIndex(index);
		return this.getIndexedNode(index).value;
	}
	
	private Node getIndexedNode(int index) {
		Node node = head;
		int i = 0;
		while (i <= index) {
			node = node.next;
			i++;
		}
		return node;
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
		while (i<size) {
			if(node.value.equals(obj)) {
				return node;
			}
			node = node.next;
			i++;
		}
		throw new RuntimeException("Given value is not found in list");
	}
	
	private boolean isIndexOfList(int index) {
		return index >= 0 && index < size;
	}
	
	private void checkListIndex(int index) {
		if(!this.isIndexOfList(index)) {
			throw new ArrayIndexOutOfBoundsException("List index is out of bounds");
		}
	}
	
	public Object remove(Object obj) {
		Node node = this.getDesiredNode(obj);
		node.previous.next = node.next;
		node.next.previous = node.previous;
		size--;
		return obj;
	}
	
	public Iterator<Object> iterator() {
		this.itrSize = size;
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
	
	private static class Node {
		Node next;
		Node previous;
		Object value;
	}
}
