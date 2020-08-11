import java.util.*;

public class l3p3{

	static long sum;
	public static int lol(long x,int k){
		if(x==0){
			return 1;
		}
		else{
			long a = x%10;
			sum=sum+(long)Math.pow(a,k);
			x=(x-a)/10;
			lol(x,k);
		}
		return 0;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
			long n = in.nextLong();
			sum=0;
			int k = (String.valueOf(n)).length();
			lol(n,k);
			if (sum==n){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}

		}
	}
}