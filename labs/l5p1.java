import java.util.*;

public class l5p1{
	public static int partition(long[] arr,int low,int high){
		long pivot = arr[high];
		int i=low-1;
		for(int j=low;j<=(high-1);j++){
			if(arr[j]<pivot){
				i++;
				long temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		long t = arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=t;
		return(i+1);
	}
	public static void sort(long[] arr,int low,int high){
		if(low<high){
			int pi = partition(arr,low,high);
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] arr = new long[n];
		for(int i=0; i<n;i++)
			arr[i]=in.nextLong();
		sort(arr,0,n-1);
		long sum=0;
		for(int i=0;i<n/2;i++){
			sum = sum+(arr[(2*i)+1]-arr[2*i]);
		}
		System.out.println(sum);

	}
}