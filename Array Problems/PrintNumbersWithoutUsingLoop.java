
/*
 * @author Vinayak Nair$
 *
 */
public class PrintNumbersWithoutUsingLoop {

	static void printNumberRecursively(int n) {
		
		if(n<=100) {
			System.out.print(n+" ");
			printNumberRecursively(n+1);
		}
	}
	
	public static void main(String[] args) {
		
		printNumberRecursively(1);
	}

}
