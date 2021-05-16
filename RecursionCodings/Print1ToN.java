
public class Print1ToN {

	/*
	 * Print 1 to n for the given n number.
	 */

	public static void main(String[] args) {

		int n = 100;
		print1ToN(n);
	}

	private static void print1ToN(int n) {

		if (n == 1) {
			System.out.println(n);
			return;
		}
		
		print1ToN(n - 1);
		System.out.println(n);
	}

}
