import java.util.*;
public class l3p4{
	static int count=0;
	public static int lol(int a,int b){
		if(a==b){
			count=count+1;
			return 1;
		}
		else if(a>b){
			return 1;
		}
		else{
			lol(a+1,b);
			lol(a+2,b);
			lol(a+3,b);
		}
		return 0;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		lol(0,n);
		System.out.println(count);
	}
}