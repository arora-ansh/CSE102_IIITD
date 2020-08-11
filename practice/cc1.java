import java.util.*;
public class cf1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		String[] arr = new String[100];
		in.nextLine();
		for(int i=0;i<n;i++){
			arr[i]= in.nextLine();
		}
		for(int i=0;i<n;i++){
			if(arr[i].length()<10)
				System.out.println(arr[i]);
			else
				System.out.println(arr[i].charAt(0)+(arr[i].length-2)+(arr[i].charAt(arr[i].length-1)));
		}
	}
}