import java.util.Scanner;


public class Factorial {
 public int fact(int n){
	 if(n==0 || n==1)
		 return 1;
	 else
	return n*fact(n-1); 
 }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number");
		int n=sc.nextInt();
		sc.close();
		Factorial f=new Factorial();
		for(int i=1;i<=n;i++)
		System.out.print(f.fact(i)+" ");
	}

}
