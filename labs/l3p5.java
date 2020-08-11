import java.util.*;
public class l3p5{
	static long count;
	public static int lol(long a, long b, long c){
		if(a==b){
			System.out.println(a+" "+b+" "+c);
			return 1;
		}
		else if(a<b){
			a=a*c;
			count = count+1;
			System.out.println(a+" "+b+" "+c);
			lol(a,b,c);
		}
		else if(a>b && (a%2)!=(b%2)){
			a=a-1;
			count=count+1;
			System.out.println(a+" "+b+" "+c);
			lol(a,b,c);
		}
		else if(a>b && (a%2)==(b%2)){
			a=a-2;
			count=count+1;
			System.out.println(a+" "+b+" "+c);
			lol(a,b,c);
		}
		return 0;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		long[] arr = new long[t];
		int j = 0;
		for(int i=0;i<t;i++){
			long a = in.nextLong();
			long b = in.nextLong();
			long c = in.nextLong();
			count = 0;
			lol(a,b,c);
			arr[j]=count;
			j=j+1;
		}
		for(int i=0;i<t;i++){
			System.out.println(arr[i]);
		}
	}
}