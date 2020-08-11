import java.util.*;

public class cfpresents{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=1;i<=n;i++){
			int temp = in.nextInt();
			arr[temp-1]=i;
		}
		for(int i=0;i<n;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}