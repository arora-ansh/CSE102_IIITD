import java.util.*;

public class fbp2{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		int[] sum = new int[50];
		for(int i=0;i<n;i++){
			int m = in.nextInt();
			in.nextLine();
			String s = in.nextLine();
			String[] arr = s.split(" ");
			int t=0;
			for(int j=0;j<m;j++){
				t=t+(Integer.valueOf(arr[j])/3);
			}
			sum[i]=t;
		}
		for(int i=0;i<n;i++){
			System.out.println(sum[i]);
		}
	}
}