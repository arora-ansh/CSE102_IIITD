import java.util.*;

public class hwap6{

	public static void addedge(ArrayList<ArrayList<Integer>> adj,int x,int y,int tno){
		adj.get(x).add(y);
		adj.get(y).add(x);
		//adjmat[x][y]=tno;
		//adjmat[y][x]=tno;
	}

	public static void graphprint(int n, int[][] adjmat, ArrayList<ArrayList<Integer>> adj){
		for(int i=0;i<adj.size();i++){
			System.out.print(i);
			for(int j=0;j<adj.get(i).size();j++){
				System.out.print("->"+adj.get(i).get(j));
			}
			System.out.println();
		}
		System.out.println();
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(adjmat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int time = 1;
	public static void dfshelper(int v, boolean[] visited,ArrayList<ArrayList<Integer>> adj,int[] pre, int[] post){
		pre[v]=time;
		visited[v]=true;
		time++;
		//System.out.print(v+" ");
		int nnbrs = adj.get(v).size();
		int[] vnbrs = new int[nnbrs];
		for(int i=0;i<nnbrs;i++){
			vnbrs[i]=adj.get(v).get(i);
			//System.out.print(vnbrs[i]+" ");
		}
		//System.out.println();
		int i=0;
		while(i<nnbrs){
			int n = vnbrs[i];
			if(!visited[n]){
				dfshelper(n,visited,adj,pre,post);
			}
			i=i+1;
		}
		post[v]=time;
		time++;
	}

	public static void DFS(int v,int n,ArrayList<ArrayList<Integer>> adj,int[] pre,int[] post){
		boolean[] visited = new boolean[n];
		dfshelper(v,visited,adj,pre,post);
	}


	

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();//number of bunkers
		int s = in.nextInt();//number of bunkers with supplies
		int q = in.nextInt();//number of queries
		int target = in.nextInt();//escape tunnel which
		//In this problem, we essentially have to find if one tunnel is reachable from the other or not
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
		for(int i=0;i<n;i++){
			adj.add(new ArrayList<Integer>());
		}
		//int[][] adjmat = new int[n][n];
		int[][] tunnels = new int[n-1][2];
		int tcount = 1;
		for(int i=0;i<n-1;i++){
			int ta = in.nextInt()-1;
			int tb = in.nextInt()-1;
			long tl = in.nextLong();
			addedge(adj,ta,tb,i+1);
			tunnels[i][0]=(ta);
			tunnels[i][1]=(tb);
		}
		int[] extras = new int[s];
		for(int i=0;i<s;i++){
			extras[i] = in.nextInt();//tunnel with supplies 
		}
		int[] pre = new int[n];
		int[] post = new int[n];
		//graphprint(n,adjmat,adj);
		DFS(target-1,n,adj,pre,post);
		/*for (int i = 0; i < n; i++) 
            System.out.println("Node " + (i+1) + " Pre number " + pre[i] + " Post number " + post[i]);
		*/
		for(int i=0;i<q;i++){
			int tbomb = in.nextInt();
			int cur = in.nextInt();
			if(cur==target){
				System.out.println("escaped");
			}
			else if(pre[target-1]<pre[cur-1]&&post[target-1]>post[cur-1]){
				int ta=tunnels[tbomb-1][0];
				int tb=tunnels[tbomb-1][1];
				//System.out.println(ta+" "+tb);
				if((pre[ta]<=pre[cur-1]&&post[ta]>=pre[cur-1])&&(pre[tb]<=pre[cur-1]&&post[tb]>=pre[cur-1])){
					System.out.println(0);
				}
				else{
					System.out.println("escaped");
				}
			}
			else{
				System.out.println(0);
			}
			
		}


	}
}