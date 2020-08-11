import java.util.*;
public class cf1{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] arr = new String[100];
		in.nextLine();
		for(int i=0;i<n;i++){
			arr[i]= in.nextLine();
		}
		for(int i=0;i<n;i++){
			int y = arr[i].length();
			if(y<=10)
				System.out.println(arr[i]);
			else{
				System.out.print(arr[i].charAt(0));
				System.out.print(y-2);
				System.out.print(arr[i].charAt(y-1));
				System.out.println();
			}	
		}
	}
}