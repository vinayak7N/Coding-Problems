import java.util.Scanner;
public class LeftRotation {
	public static int[] rotate(int[] array,int d,int n){
		if(d==0)
			return array;
		else{
			int temp=array[0];
			array=leftRotate(array,n);
			array[n-1]=temp;
			return rotate(array,d--,n);
		} 
	}
	private static int[] leftRotate(int[] array,int n) {
		int j=array.length;
		if(n==0 || n==1)
			return array;
		else{
			array[j-n]=array[j-n+1];
			return leftRotate(array,--n);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int d=sc.nextInt();
		int[] array=new int[n];
		for(int i=0;i<n;i++)
			array[i]=sc.nextInt();
		sc.close();
		int[] a=rotate(array,d,n);
		for(int m:a)
			System.out.print(m);
	}
}
