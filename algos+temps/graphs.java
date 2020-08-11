import java.util.*;


public class graphs{

	public static void addedge(ArrayList<ArrayList<Integer>> adj,int[][] adjmat,int x,int y){
		adj.get(x).add(y);
		adj.get(y).add(x);
		adjmat[x][y]=1;
		adjmat[y][x]=1;
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
	}

	public static int d=0;

	public static void dfshelper(int v, boolean[] visited,ArrayList<ArrayList<Integer>> adj,int idx){
		d=d+1;
		System.out.print("Level"+d+" ");
		visited[v]=true;
		//System.out.print(v+" ");
		int nnbrs = adj.get(v).size();
		int[] vnbrs = new int[nnbrs];
		for(int i=0;i<nnbrs;i++){
			vnbrs[i]=adj.get(v).get(i);
			//System.out.println("Level");
			if(vnbrs[i]==idx){
				return;
			}
			System.out.print(vnbrs[i]+" ");
		}
		System.out.println();
		int i=0;
		while(i<nnbrs){
			int n = vnbrs[i];
			if(!visited[n]){
				//System.out.print(n+" ");
				dfshelper(n,visited,adj,idx);
			}
			i=i+1;
		}
		
	}

	public static void DFS(int v,int n,ArrayList<ArrayList<Integer>> adj,int idx){
		boolean[] visited = new boolean[n];
		dfshelper(v,visited,adj,idx);
	}

	public static void BFS(int v,int n,ArrayList<ArrayList<Integer>> adj){
		boolean visited[] = new boolean[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
		visited[v]=true;
		list.add(v);
		while(list.size()!=0){
			//System.out.println("Level ");
			int u = list.get(0);
			System.out.print(u+" ");
			list.remove(0);
			int nnbrs = adj.get(u).size();
			int[] vnbrs = new int[nnbrs];
			for(int i=0;i<nnbrs;i++){
				vnbrs[i]=adj.get(u).get(i);
				//System.out.print(vnbrs[i]+" ");
			}
			int i=0;
			while(i<nnbrs){
				int x = vnbrs[i];
				if(!visited[x]){
					visited[x]=true;
					list.add(x);
				}
				i=i+1;
			}
		}
	}

	public static void main(String[] args){
		int n=7;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
		int[][] adjmat = new int[n][n];
		for(int i=0;i<n;i++){
			adj.add(new ArrayList<Integer>());
		}
		addedge(adj,adjmat,0,1);
		addedge(adj,adjmat,1,2);
		addedge(adj,adjmat,2,3);
		addedge(adj,adjmat,3,1);
		addedge(adj,adjmat,3,4);
		addedge(adj,adjmat,4,5);
		addedge(adj,adjmat,5,6);
		//graphprint(n,adjmat,adj);
		//DFS(0,n,adj,4);
		System.out.println();
		BFS(0,n,adj);
		//System.out.println();
	}
}