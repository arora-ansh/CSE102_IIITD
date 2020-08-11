import java.util.*;

public class l3p2{

	static int key = 0;
	public static int board (int cx, int cy, int m, int n, int count){
		if((cx==m && cy==n) && count>(-1)){
			key=1;
			return 1;
		}
		if(count==-1)
			return 0;
		else if((cx>8 || cy>8) || (cx<1 || cy<1))
			return 0;
	

		board(cx+2,cy+1,m,n,count-1);
		board(cx+1,cy+2,m,n,count-1);
		board(cx-2,cy-1,m,n,count-1);
		board(cx-1,cy-2,m,n,count-1);
		board(cx+1,cy-2,m,n,count-1);
		board(cx-1,cy+2,m,n,count-1);
		board(cx+2,cy-1,m,n,count-1);
		board(cx-2,cy+1,m,n,count-1);
		return 0;
		
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		int K = in.nextInt();
		board(1,1,M,N,K);
		if(key==1)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}	
		