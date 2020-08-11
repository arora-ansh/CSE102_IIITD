import java.util.*;

public class lpp3{
	public static int lol(long[] arr, long val,int n){
		for(int j=0;j<n;j++){
				if(arr[j]>val){
					return j;
				}
			}
		return -1;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		long[] arr = new long[n];
		for(int i=0;i<n;i++)
			arr[i]=in.nextLong();
		long[] arr2 = new long[q];
		for(int i=0;i<q;i++){
			long val = in.nextLong();
			arr2[i]=lol(arr,val,n);
		}
		for(int i=0;i<q;i++){
			System.out.println(arr2[i]);
		}
	}
}