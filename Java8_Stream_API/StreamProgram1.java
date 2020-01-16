import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamProgram1 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

		System.out.println("Printing elements using for loop...");

		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println("\nPrinting elements using forEach...");
		list.forEach(i -> System.out.print(i + " "));

		System.out.println("\nFiltering out odd number using stream...");

		list.stream().filter(i -> i % 2 == 0).forEach(i -> System.out.print(i + " "));

		System.out.println("\nFiltering out even number using stream...");
		Consumer<Integer> consume = new MyConsumer();
		list.stream().forEach(consume);

		System.out.println("\nPrinting using method reference...");
		list.forEach(System.out::println);

		System.out.println("\nMethod reference using user defined object...");
		list.forEach(new MyConsumer()::accept);

		System.out.println("\nDoubling each value and adding result...");
		System.out.println("Doubled sum is: " + list.stream().map(i -> i * 2).reduce(0, (c, e) -> c + e));

		// Decoding above lambda expression...

		// 1. Similar to list.stream()
		Stream<Integer> s1 = list.stream();

		// 2.Similar to i->i*2 in map
		Function<Integer, Integer> f = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer i) {
				return i * 2;
			}
		};

		s1 = s1.map(f);

		// 3.Similar to (0, (c,e)-> c+e) in reduce
		BinaryOperator<Integer> op = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		};
		Integer result = (Integer) s1.reduce(0, op);
		System.out.println("Doubled sum is: " + result);

	}

}

class MyConsumer implements Consumer<Integer> {

	@Override
	public void accept(Integer i) {
		if (i % 2 != 0)
			System.out.print(i + " ");
	}
}
