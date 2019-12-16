package Test;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = Stream.of(1, 6, 7).collect(Collectors.toList()); 
		if(list.contains(Calendar.getInstance().get(Calendar.DAY_OF_WEEK))) {
			System.out.println("Hollyday");
		}
	}
}
