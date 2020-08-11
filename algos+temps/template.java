import java.util.*;

public class Solution{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long [] arr = new int[n];
		for (int i=0; i < n;i++){
			int k = in.nextInt();
			long time = in.nextLong();
			double x = time/k;
			int temp = 0;
			long n = 1;
			while(temp=0){
				long y = n*Math.log10(n);
				if(y>x){
					temp=1;
				} 
				n=n+1;
			}
			arr[i]=n;
		}
		for(int i=0; i<n; i++){
			System.out.println(arr[i]);
		}
	}
}