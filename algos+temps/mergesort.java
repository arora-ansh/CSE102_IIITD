import java.util.* ;

public class mergesort{

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
        /*for(int x=low;x<=high;x++)
            System.out.print(arr[x]+" ");
        System.out.println();*/
    }
    
    public static void sort(int[] arr, int low, int high){
        /*for(int i=0;i<arr.length;i++)
                System.out.print(arr[i]+" ");
            System.out.println();*/
        if(low<high){
            int mid = (low+high)/2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public static void main(String[] args){
        int[] arr = {23, 4, 65, 9, 37, 50, 12, 82, 46};
        sort(arr,0,arr.length-1);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

}
