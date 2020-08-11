import java.util.*;
public class msl1{
	public static void merge(int[] arr, int low, int mid, int high){
        int n1 = mid-low+1;
        int n2 = high-mid;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(int i=0;i<n1;i++){
            arr1[i]=arr[low+i];
        }
        for(int j=0;j<n2;j++){
            arr2[j]=arr[mid+1+j];
        }
        int i=0,j=0;
        int k = low;
        while(i<n1 && j<n2){
            if(arr1[i] <= arr2[j]){
                arr[k]=arr1[i];
                i=i+1;
            }
            else{
                arr[k]=arr2[j];
                j=j+1;
            }
            k=k+1;
        }
        while(i<n1){
            arr[k]=arr1[i];
            i=i+1;
            k=k+1;
        }
        while(j<n2){
            arr[k]=arr2[j];
            j=j+1;
            k=k+1;
        }
    }
    
    public static void sort(int[] arr, int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		sort(arr,0,n-1);
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");

	}
}