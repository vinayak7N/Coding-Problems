import java.util.Scanner;
//     *
//    **
//   ***
//  ****   
public class Pattern_SecondHalf_Triangle {
	int n;
	String s="",s2="";
	public Pattern_SecondHalf_Triangle(){
		n=0;
	}
	public String spaces(int k){
		if(k==0)
			return s2;
		else if(k==1){
			s2=" ";
			return s2;
		}
		else{
			s2=" ";	
			return s2+spaces(k-1);
	}
		}
	public String pattern(int m){
		if(m==0)
			return s;
		else if(m==1){
			//System.out.print(spaces(n-m));
			s="*";
			return s;
		}
		else{
		//	System.out.print(spaces(n-m));
			s="*";	
			return s+pattern(m-1);
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Pattern_SecondHalf_Triangle p=new Pattern_SecondHalf_Triangle();
		System.out.println("Enter number");
		int n=sc.nextInt();
		sc.close();
		for(int i=1;i<=n;i++){
		System.out.print(p.spaces(n-i));
			System.out.println(p.pattern(i));
		}

	}

}
