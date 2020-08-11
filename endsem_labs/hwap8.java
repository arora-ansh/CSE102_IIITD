import java.util.*;

public class hwap8{

	public static void addedge(ArrayList<ArrayList<Integer>> adj,int x,int y){
		adj.get(x).add(y);
		adj.get(y).add(x);
	}
	public static void graphprint(int n, long[][][] adjmat, ArrayList<ArrayList<Integer>> adj){
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
				System.out.print(adjmat[i][j][0]+","+adjmat[i][j][1]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean e=false;
	public static boolean ml=false;
	public static long d=Long.MAX_VALUE;

	public static void dfshelper(int prev, int v, boolean[] visited,ArrayList<ArrayList<Integer>> adj,boolean[] extras,long distance,long[][][] tunnels,int target){
		if(prev!=-1){
			distance = distance + tunnels[prev][v][0];
		}
		if(v==target-1){
			e=true;
			System.out.println("escaped");
		}
		else if(extras[v]==true && distance<d){
			//System.out.println("Supplies found");
			d=distance;
			ml=true;
		}
		visited[v]=true;
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
				
				//System.out.println("Going from "+(v+1)+" to "+(n+1)+" Current distance: "+distance);
				dfshelper(v,n,visited,adj,extras,distance,tunnels,target);
			}
			i=i+1;
		}
	}

	public static void DFS(int v,int n,ArrayList<ArrayList<Integer>> adj,boolean[] extras,long[][][] tunnels,int target){
		boolean[] visited = new boolean[n];
		e=false;
		ml=false;
		d=Long.MAX_VALUE;
		dfshelper(-1,v,visited,adj,extras,0,tunnels,target);
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();//number of bunkers
		int s = in.nextInt();//number of bunkers with supplies
		int q = in.nextInt();//number of queries
		int target = in.nextInt();//escape tunnel which
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
		for(int i=0;i<n;i++){
			adj.add(new ArrayList<Integer>());
		}
		long[][][] tunnels = new long[n][n][2];
		int[][] tunx = new int[n-1][2];
		for(int i=0;i<n-1;i++){
			int ta = in.nextInt();
			int tb = in.nextInt();
			long tl = in.nextLong();
			tunnels[ta-1][tb-1][0]=tl;
			tunnels[ta-1][tb-1][1]=i+1;
			tunnels[tb-1][ta-1][0]=tl;
			tunnels[tb-1][ta-1][1]=i+1;
			tunx[i][0]=ta-1;
			tunx[i][1]=tb-1;
			addedge(adj,ta-1,tb-1);
		}
		boolean[] extras = new boolean[n];
		for(int i=0;i<s;i++){
			int x = in.nextInt();
			extras[x-1]=true;
		}
		//System.out.println();
		//graphprint(n,tunnels,adj);
		//BFS(0,n,adj);
		//System.out.println();
		for(int i=0;i<q;i++){
			int tbomb = in.nextInt();
			int cur = in.nextInt();
			int ta = tunx[tbomb-1][0];
			int tb = tunx[tbomb-1][1];
			//System.out.println(ta+" "+tb);
			for(int j=0;j<adj.get(ta).size();j++){
				if(adj.get(ta).get(j)==tb)
					adj.get(ta).remove(j);
			}
			for(int j=0;j<adj.get(tb).size();j++){
				if(adj.get(tb).get(j)==ta)
					adj.get(tb).remove(j);
			}
			//graphprint(n,tunnels,adj);
			//adj.get(ta).remove(tb);
			//adj.get(tb).remove(ta);
			DFS(cur-1,n,adj,extras,tunnels,target);
			//System.out.println(s);
			if(e==false && ml==true){
				System.out.println(d);
			}
			else if(e==false && ml==false){
				System.out.println("oo");
			}
			adj.get(ta).add(tb);
			adj.get(tb).add(ta);	
		}
	}
}