package ds.circularLinkedList;

import java.util.Iterator;

public class CircukarLinkedListTest {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		list.add("H");
		list.add("I");
		list.add("j");
		System.out.println(list);
		Iterator<Object> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next()+ " ");
		}
		System.out.println();
		System.out.println(list.remove("D"));
		System.out.println();
		Iterator<Object> itr2 = list.iterator();
		while(itr2.hasNext()) {
			System.out.print(itr2.next()+" ");
		}
	}

}
