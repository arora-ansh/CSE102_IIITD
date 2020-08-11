import java.util.*;

public class ms1{
	public static int partition(int[] arr,int low,int high){
		int pivot = arr[high];
		int i=low-1;
		for(int j=low;j<=(high-1);j++){
			if(arr[j]<pivot){
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int t = arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=t;
		return(i+1);
	}
	public static void sort(int[] arr,int low,int high){
		if(low<high){
			int pi = partition(arr,low,high);
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=in.nextInt();
		}
		sort(arr,0,n-1);
		for(int i=0;i<q;i++){
			int h = in.nextInt();
			System.out.println(arr[n-h]);
		}
	}
}