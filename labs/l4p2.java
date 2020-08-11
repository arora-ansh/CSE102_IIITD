import java.util.*;

public class l4p2{
	static int count=0;
	public static int counter(long[] arr, int pos, long key,int prev){
		if(arr[pos]==key){
			count = count+1;
			if(pos>=prev && pos<arr.length-1)
				counter(arr,pos+1,key,pos);
			if(pos<prev && pos>0)
				counter(arr,pos-1,key,pos);
		}
		else
			return 1;
		return 1;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] arr = new long[n];
		for(int i=0;i<n;i++){
			arr[i] = in.nextLong();
		}
		int t = in.nextInt();
		for(int i=0;i<t;i++){
			long key = in.nextLong();
			int low = 0;
			int high = arr.length-1;
			int index=-1;
			while(low<high){
				//System.out.println(low+" "+high);
				int mid = (low+high)/2;
				if(arr[mid]==key){
					index=mid;
					break;
				}
				else if(key<arr[mid]){
					high=mid-1;
				}
				else if(key>arr[mid]){
					low=mid+1;
				}
			}
			count=0;
			if(index!=-1)
				counter(arr,index,key,index);
			if(index==-1)
				System.out.println(-1);
			else
				System.out.println(count);
		}

	}
}