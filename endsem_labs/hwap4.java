import java.util.*;

public class hwap4{

	public static long distance=0;
	public static int cond = 0;

	public static long system(long[][][] grid,int r,int e,int tbomb,int[] extras,int n,int s){
		System.out.println("In bunker "+r);
		if(r==e){
			System.out.println("escaped");//base condn
			return 0;
		}
		else{
			for(int i=0;i<s;i++){
				if(r==extras[i]){
					System.out.println("Supplies found");
					cond = 1;
					return distance;
				}
			}
			if(cond==0){
			for(int i=0;i<n;i++){
				if(grid[r-1][i][0]>0 && grid[r-1][i][1]!=tbomb){
					distance=distance+grid[r-1][i][0];
					System.out.println("Cond is "+cond+" Going from "+r+" to "+(i+1));
					system(grid,i+1,e,tbomb,extras,n,s);//recursive call
				}
				else if(i+2<n && grid[r-1][i+2][0]>0 && grid[r-1][i+2][1]!=tbomb){
					distance=distance+grid[r-1][i+2][0];
					System.out.println("Cond is "+cond+" Going from "+r+" to "+(i+3));
					system(grid,i+3,e,tbomb,extras,n,s);//recursive call
				}
			}
			}
		}
		return -1;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();//number of bunkers
		int s = in.nextInt();//number of bunkers with supplies
		int q = in.nextInt();//number of queries
		int e = in.nextInt();//escape tunnel which
		long[][][] grid = new long[n][n][2];
		int tcount = 1;
		for(int i=0;i<n-1;i++){
			int ta = in.nextInt()-1;
			int tb = in.nextInt()-1;
			grid[ta][tb][0] = in.nextLong();//distance b/w ta and tb
			grid[ta][tb][1] = tcount;//tunnel number
			tcount = tcount + 1;
			grid[tb][ta] = grid[ta][tb];//the ta, tb grid holds the same values  
		}
		int[] extras = new int[s];
		for(int i=0;i<s;i++){
			extras[i] = in.nextInt();//tunnel with supplies 
		}
		/*for(int i=0;i<s;i++){
			System.out.print(extras[i]+" ");
		}
		System.out.println();*/
		for(int i=0;i<q;i++){
			int tbomb = in.nextInt();//unusable tunnel
			int r = in.nextInt();//tunnel whose soldiers have to be saved
			long ans = system(grid,r,e,tbomb,extras,n,s);
			System.out.println(cond);
			if(ans==1){
				System.out.println(distance);
			}
			else if(ans==-1){
				System.out.println("oo");
			}
			distance = 0;
			cond = 0;
		}
	}
}