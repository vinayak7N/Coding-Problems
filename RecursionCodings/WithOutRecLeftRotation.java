import java.util.Scanner;


public class WithOutRecLeftRotation {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int d=sc.nextInt();
		int[] array=new int[n];
		for(int i=0;i<n;i++)
			array[i]=sc.nextInt();
		sc.close();  
		for(int i=0;i<d;i++){
			int temp=array[0];
			for(int j=0;j<n-1;j++){
				array[j]=array[j+1];
			}
			array[n-1]=temp;
		}
		for(int m:array)
			System.out.print(m+" ");

	}

}
