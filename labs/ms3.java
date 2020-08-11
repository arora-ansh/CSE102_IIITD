import java.util.*;

public class ms3{
	public static long summer(int[] arr, long val){
		long sum = 0;
		for(int i=0;i<arr.length;i++){
			sum = sum + (val/arr[i]);
		}
		return sum;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long t = in.nextLong();
		int[] arr = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}
		long min = 0;
		long max = 1000000000;
		long[][] arr2 = new long[500][2];
		long ans=0;
		int count=0;
		while(min<max){
			long mid = (min+max)/2;
			long temp = summer(arr, mid);
			arr2[count][0]=temp;
			arr2[count][1]=mid;
			count=count+1;
			//System.out.println(mid+" "+temp);
			if(t==temp){
				ans = mid;
				break;
			}
			else if(t>temp){
				min=mid+1;
			}
			else{
				//ans=temp;
				max=mid-1;
			}
		}
		//Arrays.sort(arr2);
		long tempval = 0;
		if(ans==0){
			for(int i=0;i<count;i++){
				if(arr2[i][0]<=t){
					tempval = arr2[i][1];
				}
			}
			System.out.println(tempval);
		}
		else
			System.out.println(ans);
}
}