package ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackArray {

	private Object[] elementData;
	private int size;
	private int modCount = 16;
	
	public StackArray() {
		this.elementData = new Object[16];
	}
	
	public void add(Object obj) {
		if(size < modCount) {
			elementData[size] = obj;
			size++;
		} else {
			grow(elementData, modCount);
		}
	}

	private void grow(Object[] elementData2, int modCount2) {
		//elementData = 
	}
}
