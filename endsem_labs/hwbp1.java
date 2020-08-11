import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwbp1{

    public static long days = -1;

    public static void addedge(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> wts,int x,int y,int w,int[][] adjmat){
		adj.get(x-1).add(y-1);
        adj.get(y-1).add(x-1);
        wts.get(x-1).add(w);
        wts.get(y-1).add(w);
        adjmat[x-1][y-1]=w;
		adjmat[y-1][x-1]=w;
    }

    /*public static int mindist(long[] dist,Boolean[] listdone,int V){
        long min = Long.MAX_VALUE;
        int idx = -1;
        for(int i=0;i<V;i++){
            if(listdone[i]==false && dist[i]<=min){
                min = dist[i];
                idx = i;
            }
        }
        return idx;
    }*/
    
    public static void algo(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> wts,int src,int V,int[][] adjmat){
        days = -1;
        long[] dist = new long[V];
        Boolean[] listdone = new Boolean[V];
        //PriorityQueue<Integer[]> pq = new PriorityQueue<Integer[]>();
        PriorityQueue<pqelement> pq = new PriorityQueue<pqelement>(new Comp());
        pqelement pqx1 = new pqelement(src,0);
        pq.add(pqx1);
        for(int i=1;i<V;i++){
            dist[i] = Long.MAX_VALUE;
            listdone[i] = false;
        }
        dist[src] = 0;
        while(pq.size()!=0){
            //int cur = mindist(dist,listdone,V);
            long minVal = pq.peek().distance;
            int cur = pq.poll().vnumber;
            listdone[cur]=true;
            if(dist[cur]<minVal){
                continue;
            }
            for(int j=0;j<adj.get(cur).size();j++){
                int x = adj.get(cur).get(j);
                if(dist[cur]!=Integer.MAX_VALUE && listdone[x]==false && dist[cur]+adjmat[cur][x]<dist[x]){
                    dist[x] = dist[cur] + adjmat[cur][x];
                    pqelement temp = new pqelement(dist[x],x);
                    pq.add(temp);
                }
            }
        }
        for (int i = 0; i < V; i++){ 
            if(dist[i]>days){
                days=dist[i];
            }
        }
    }

    public static class Comp implements Comparator<pqelement>{
        public int compare(pqelement x, pqelement y){
        if(x.distance>y.distance){
            return 1;
        }
        else{
            return -1;
        }
        }
    }

    public static void main(String[] args) throws IOException{
        Reader in = new Reader(System.in);
        int t = in.nextInt();//test cases
        for(int j=0;j<t;j++){
            int n = in.nextInt();//no of services
            int l = in.nextInt();//no of locality markers
            int k = in.nextInt();//Operational constraints
            int[][] locarr = new int[n][2];
            int[][] adjmat = new int[n][n];
            for(int i=0;i<l;i++){
                locarr[i][0]=in.nextInt()-1;
                locarr[i][1]=in.nextInt()-1;
            }
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
            ArrayList<ArrayList<Integer>> wts = new ArrayList<ArrayList<Integer>>(n);
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<Integer>());
                wts.add(new ArrayList<Integer>());
            }
            for(int i=0;i<k;i++){
                int a1 = in.nextInt();
                int a2 = in.nextInt();
                int d = in.nextInt();
                addedge(adj,wts,a1,a2,d,adjmat);
            }
            for(int i=0;i<l;i++){
                
                int x1 = locarr[i][0];
                int x2 = locarr[i][1];
                adjmat[x1][x2]=0;
                adjmat[x2][x1]=0;
                /*int r1 = -1;
                int r2 = -1;
                for(int r=0;r<adj.get(x1).size();r++){
                    if(adj.get(x1).get(r)==x2)
                        r1 = r;
                }
                for(int r=0;r<adj.get(x2).size();r++){
                    if(adj.get(x2).get(r)==x1)
                        r2 = r;
                }
                wts.get(x1).set(r2,0);
                wts.get(x2).set(r1,0);*/
                
            }
            algo(adj,wts,0,n,adjmat);
            System.out.println(days);
        }
    }
}

class pqelement{
    int vnumber;
    long distance;

    pqelement(long x,int y){
        vnumber = y;
        distance = x;
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