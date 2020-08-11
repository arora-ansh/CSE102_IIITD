import java.util.*;

public class l4p1{
	public static long powercalc(int a, int b){
		long power = 1;
		for(int i=0; i <b ;i++)
			power=power*a;
		return power;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long [] arr = new long[n];
		for (int i=0; i < n;i++){
			int k = in.nextInt();
			long time = in.nextLong();
			double x = (double)time/(double)k;
			//System.out.println(x);
			/*int b = 1;
			while(true){
				double tem=x/powercalc(10,b);
				if(tem>=1 && tem<10){
					break;
				}
				b=b+1;
			}*/
			long m1 = 0;
			long m2 = Long.MAX_VALUE;
			long val=0;
			int hack=0;
			long mid=0;
			while (true){
				if (m1>m2) break;
				hack=0;
				//System.out.println(m1+" "+m2);
				mid = (m1+m2)/2;
				double y = mid*Math.log10(mid);
				//System.out.println(y);
				if(y>x){
					hack=1;
					m2=mid-1;
				}
				else {
					m1=mid+1;
				}	
			}
			arr[i]=mid-hack;
		}
		for(int i=0; i<n; i++){
			System.out.println(arr[i]);
		}
	}
}