import java.util.*;

public class l1p1{

	public static int matrix(String[][] mat, int i, int j, int n, int m){

		int countx = 0;
		int county = 0;

		if(i>=n || j>=m){
			/*System.out.println(i+j);*/
			return 0;
		}
		else if(Integer.valueOf(mat[i][j])==0){
			/*System.out.println(i+j);*/
			return 0;
		}
		else if(i==n-1 && j==m-1){
			/*System.out.println(i+j+" stonks");*/
			return 1;
		}

		countx=countx+matrix(mat,i+1,j,n,m);
		county=county+matrix(mat,i,j+1,n,m);
		return countx+county;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String[] qarr = new String[4];
		qarr = s.split(" ");
		int n = Integer.valueOf(qarr[0]), m = Integer.valueOf(qarr[1]), x = Integer.valueOf(qarr[2]), y = Integer.valueOf(qarr[3]);
		String[][] mat = new String[n][m];
		for(int i=0;i<n;i++){
			String temp = in.nextLine();
			mat[i] = temp.split(" ");
		}
		int a = matrix(mat,0,0,x,y);
		int b = matrix(mat,x-1,y-1,n,m);
		System.out.println(a*b);
	}
}