package ds.stack;

public class SatckTest {

	public static void main(String[] args) {
		
		Stack<String> arr = new Stack<String>();
		for (int i = 0; i < 100; i++) {
			arr.push("str" + i);
		}

		for (int i = 0; i < 100; i++) {
			System.out.println(arr.peek());
			System.out.println(arr.pop());
			System.out.println(arr.size());
		}
		

	}

}
