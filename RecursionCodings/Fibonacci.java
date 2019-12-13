public class Fibonacci {
	int n;
	int[] array;
	public Fibonacci(){
		this.n=0;
		array=new int[5];
	}
	public int input(){
		System.out.println("enter limit of series");
		java.util.Scanner sc=new java.util.Scanner(System.in);
		n=sc.nextInt();
		sc.close();
		return n;
	}
	public int calcFib(int m){
		if(m==0 || m==1)
		    return 1;
		else{
			return calcFib(m-1)+calcFib(m-2);
		}
	}
	public static void main(String[] args) {
		Fibonacci ff=new Fibonacci();
		int m=ff.input();
		System.out.print(0+" "+1+" ");
		for(int i=1;i<m-1;i++)
		System.out.print(ff.calcFib(i)+" ");
	}

}
//0 1 1 2 3 5 8 13