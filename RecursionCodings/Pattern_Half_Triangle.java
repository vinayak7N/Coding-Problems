import java.util.Scanner;


public class Pattern_Half_Triangle {
	int n;
	String s="";
	public Pattern_Half_Triangle(){
		n=0;
	}
	public String pattern(int m){
		if(m==0)
			return s;
		else if(m==1){
			s="*";
			return s;
		}
		else{
			s="*";	
			return s+pattern(m-1);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Pattern_Half_Triangle p=new Pattern_Half_Triangle();
		int n=sc.nextInt();
		sc.close();
		for(int i=1;i<=n;i++)
			System.out.println(p.pattern(i));

	}

}
