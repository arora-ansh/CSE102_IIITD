import java.util.*;

public class lpp2{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++){
			arr[i][0]=in.nextInt();
			arr[i][1]=in.nextInt();
		}
		double max=0;
		double temp;
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				int x1 = arr[i][0];
				int x2 = arr[j][0];
				int y1 = arr[i][1];
				int y2 = arr[j][1];
				temp = Math.pow(((Math.pow((x1-x2),2))+(Math.pow((y1-y2),2))),0.5);
				//System.out.println(x1+" "+x2+" "+y1+" "+y2+" "+i+" "+j+" "+temp);
				if (temp>max)
					max=temp;
			}
		}
		System.out.println(Math.round(max*100.0)/100.0);
	}
}