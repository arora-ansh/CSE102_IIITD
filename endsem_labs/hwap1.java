import java.util.*;

public class hwap1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String x = in.nextLine();
		int n = x.length();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			if(x.charAt(i)=='L')
				arr[i]=1;
			else
				arr[i]=2;
		}
		if(n==1){
			if(arr[0]==1){
				System.out.println("No");
			}
			else{
				System.out.println("Yes");
			}
		}
		else if(n==2){
			if(arr[0]!=arr[1]){
				System.out.println("No");
			}
			else{
				System.out.println("Yes");
			}
		}
		else{
			int c=0;
			for(int i=0;i<n-2;i++){
				if(arr[i]==arr[i+2] && arr[i]!=arr[i+1]){
					c=1;
					break;
				}
			}
			if(c==0){
				System.out.println("Yes");
			}
			else{
				System.out.println("No");
			}
		}
	}
}