import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwbp6{

    public static long BFSnew(int v,int n,ArrayList<ArrayList<Integer>> adj,int key){
        long[] dist_arr = new long[n];
		boolean visited[] = new boolean[n];
        //ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        visited[v]=true;
        dist_arr[v]=0;
		list.add(v);
		while(list.size()!=0){
			//System.out.println("Level ");
			int u = list.get(0);
			//System.out.print(u+" ");
            list.remove(0);
            for(int i=0; i<adj.get(u).size(); i++){
                int b = adj.get(u).get(i);
                if(visited[b]==false){
                    visited[b]=true;
                    list.add(b);
                    dist_arr[b]=dist_arr[u]+1;
                    if(b==key){
                        //System.out.println("Returning Early!");
                        return dist_arr[key];
                    }
                }
            }
        }
        //System.out.println("Returning late");
        return dist_arr[key];
    }

    public static void addedge(ArrayList<ArrayList<Integer>> adj,int x,int y){
		adj.get(x).add(y);
        adj.get(y).add(x);
    }

    public static long gcd(long a, long b){ 
        if (a == 0) 
            return b; 
        return gcd(b%a, a); 
    }

    public static void main(String[] args) throws IOException{
        Reader in = new Reader(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        Node[] objects = new Node[n];
        boolean[] locked = new boolean[n];
        for(int i=0;i<n;i++){
            long temp = in.nextLong();
            objects[i] = new Node(temp);
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++){
			adj.add(new ArrayList<Integer>());
        }
        disjointset set = new disjointset(n);
        for(int i=0;i<q;i++){
            int inst_type = in.nextInt();//1 2 or 3
            if(inst_type == 1){
                int objno = in.nextInt();
                long val = in.nextLong();
                objects[objno-1].spl_value = val;
            }
            if(inst_type == 2){
                int x1 = in.nextInt()-1;
                int x2 = in.nextInt()-1;
                int a1 = set.find(x1);
                int a2 = set.find(x2);
                if(a1!=a2){
                    set.union(x1,x2);
                    addedge(adj,x1,x2);
                    if(locked[a1]==true||locked[a2]==true){
                        locked[a1]=true;
                        locked[a2]=true;
                    }
                    /*if(objects[x1].polarity==objects[x2].polarity){
                        objects[x2].polarity = !objects[x1].polarity;
                    }*/
                }
                else if(a1==a2 && (locked[a1]==true)){
                    continue;
                }
                else{
                    long dist = BFSnew(x1,n,adj,x2);
                    if(dist%2==0){
                        locked[a1]=true;
                    }
                    /*else{
                        set.union(x1,x2);
                        addedge(adj,x1,x2);
                        if(locked[a1]==true||locked[a2]==true){
                            locked[a1]=true;
                            locked[a2]=true;
                        }
                        if(objects[x1].polarity==objects[x2].polarity){
                            objects[x2].polarity = !objects[x1].polarity;
                        }
                    }*/
                }
            }
            if(inst_type == 3){
                int x1 = in.nextInt()-1;
                int x2 = in.nextInt()-1;
                long w = in.nextLong();
                int a1 = set.find(x1);
                int a2 = set.find(x2);
                if(a1==a2 && (locked[a1]!=true)){
                    long dist = BFSnew(x1, n, adj, x2);
                    if(dist%2==0){
                        long calc1 = (long) objects[x1].spl_value * w;
                        long calc2 = (long) objects[x2].spl_value;
                        long div = gcd(calc1,calc2);
                        System.out.println((long)(calc1/div)+"/"+(long)(calc2/div));
                    }
                    else{
                        long calc1 = (long) objects[x1].spl_value * w;
                        long calc2 = (long) objects[x2].spl_value;
                        long div = gcd(calc1,calc2);
                        System.out.println("-"+(long)(calc1/div)+"/"+(long)(calc2/div));
                    }
                }
                else{
                    System.out.println(0);
                }
            }
        }

    }
}

class Node{
    long spl_value;
    boolean polarity;

    Node(long x){
        spl_value = x;
        polarity = false;
    }
}

class disjointset{
    int[] rank,parent;
    int n;
    disjointset(int n){
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        initalize();
    }
    void initalize(){
        for(int i=0;i<n;i++){
            parent[i] = i;//sab apne parents initially
        }
    }
    int find(int x){
        if (parent[x]!=x){
            parent[x] = find(parent[x]); //Tree traversal to the top
        }
        return parent[x];//Top parent on tree
    }

    /*int newfind(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = newfind(parent[x]);
    }*/
    
    void union(int x, int y){
        int xparent = find(x);//We find dono ke parents after which we will compare and put them in the same set based on index
        int yparent = find(y);//basically join the tree
        if(rank[xparent]<=rank[yparent]){
            parent[xparent]=yparent;
        }
        else if(rank[yparent]<rank[xparent]){
            parent[yparent]=xparent;
        }
        else{
            parent[xparent] = yparent;
            rank[yparent] = rank[yparent]+1;//Number of objects under it
        }
    }
}

class Reader {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	Reader(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}
}