public class quicksort{
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
		/*for(int x=low;x<=high;x++)
            System.out.print(arr[x]+" ");
        System.out.println();*/
		return(i+1);
	}
	public static void sort(int[] arr,int low,int high){
		/*for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();*/
		if(low<high){
			int pi = partition(arr,low,high);
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}

	}
	public static void main(String[] args){
		int[] a = {7,4,9,8,3,10,6,4,2,3,1,11,5};
		sort(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
			System.out.println();
	}
}