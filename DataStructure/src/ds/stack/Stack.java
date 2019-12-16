package ds.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
	private Object[] stackData;
	private int size;
	private int maxCapacity = 16;
	
	public Stack() {
		stackData = new Object[maxCapacity];
	}
	public boolean push(E obj) {
		addElement(obj);
		return true;
	}
	
	private void addElement(E obj) {
		size++;
		if(size >= maxCapacity - 1) {
			grow(maxCapacity += maxCapacity/2);
		}
		stackData[size-1] = obj;
		
	}
	private void grow(int nextCapacity) {
		stackData = Arrays.copyOf(stackData, nextCapacity);
		
	}
	public synchronized E pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		E element = (E) stackData[size-1];
		stackData[size-1] = null;
		size--;
		return element;
	}
	
	public synchronized E peek() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		return (E) stackData[size-1];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}

}
