import java.util.*;

public class dijkstra{

    public static void addedge(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> wts,int x,int y,int w){
		adj.get(x-1).add(y-1);
        //adj.get(y).add(x);
        wts.get(x-1).add(w);
        //wts.get(y).add(w);
    }

    /* public static int mindist(long[] dist,Boolean[] listdone,int V){
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
    
    public static void algo(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> wts,int src,int V){
        long[] dist = new long[V];
        Boolean[] listdone = new Boolean[V];
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
                if(dist[cur]!=Integer.MAX_VALUE && listdone[x]==false && dist[cur]+wts.get(cur).get(j)<dist[x]){
                    dist[x] = dist[cur] + wts.get(cur).get(j);
                    pqelement temp = new pqelement(dist[x],x);
                    pq.add(temp);
                }
            }
        }
        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + " \t\t " + dist[i]);
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

    public static void main(String[] args){
        int n=6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
        ArrayList<ArrayList<Integer>> wts = new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
            wts.add(new ArrayList<Integer>());
		}
        addedge(adj,wts,1,4,10);
        addedge(adj,wts,4,1,10);
        addedge(adj,wts,1,2,50);
        addedge(adj,wts,2,4,15);
        addedge(adj,wts,4,5,15);
        addedge(adj,wts,5,2,20);
        addedge(adj,wts,2,3,10);
        addedge(adj,wts,5,3,35);
        addedge(adj,wts,3,5,30);
        addedge(adj,wts,6,5,3);
        addedge(adj,wts,1,3,45);
        algo(adj,wts,0,6);
        
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