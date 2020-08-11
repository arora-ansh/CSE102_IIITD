import java.util.*;

public class lpp1{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		String[] arr = new String[n];
		for(int i=0;i<n;i++){
			int t =  in.nextInt();
			int key = 0;
			for(int j=0;j<t;j++){
				int temp = in.nextInt();
				if(temp%d==0 && key!=1){
					key=1;
					arr[i]="True";
				}
			}
			if(key==0)
				arr[i]="False";
		}
		for(int i=0;i<n;i++){
			System.out.println(arr[i]);
		}
	}
}