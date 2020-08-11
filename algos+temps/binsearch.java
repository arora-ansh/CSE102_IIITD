import java.util.*;

public class binsearch{
	static int i;
	public static void search(int[] arr, int key, int start, int end){
		int mid=(start+end)/2;
		if(key==arr[mid]){
			System.out.println("Found at "+(mid+1));
			i=1;
		}
		else if(start<end){
			if (key<arr[mid])
				search(arr,key,start,end-1);
			else if(key>arr[mid])
				search(arr,key,start+1,end);
		}
		else
			i=0;
	}
	public static void main(String[] args){
		int[] arr = new int[]{0,5,13,19,22,41,55,68,72,81,98};
		Scanner in = new Scanner(System.in);
		int key = in.nextInt();
		search(arr,key,0,10);
		if(i==0)
			System.out.println("Not found");
	}
}