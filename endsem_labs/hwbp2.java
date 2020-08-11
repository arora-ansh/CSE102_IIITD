import java.util.*;

public class hwbp2{

        public static void algo(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> wts,int src,int V){
            int[] dist = new int[V];
            Boolean[] listdone = new Boolean[V];
            PriorityQueue<pqelement> pq = new PriorityQueue<pqelement>(new Comp());
            pqelement pqx1 = new pqelement(src,0);
            pq.add(pqx1);
            for(int i=1;i<V;i++){
                dist[i] = Integer.MAX_VALUE;
                listdone[i] = false;
            }
            dist[src] = 0;
            while(pq.size()!=0){
                //int cur = mindist(dist,listdone,V);
                int minVal = pq.peek().distance;
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
            if(dist[V-1]<Integer.MAX_VALUE)
                System.out.println(dist[V-1]);
            else{
                System.out.println(-1);
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

        public static void addedge(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> wts,int x,int y,int w){
            adj.get(x-1).add(y-1);
            adj.get(y-1).add(x-1);
            wts.get(x-1).add(w);
            wts.get(y-1).add(w);
        }
        public static void main(String[] args){
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int m = in.nextInt();
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
            ArrayList<ArrayList<Integer>> wts = new ArrayList<ArrayList<Integer>>(n);
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<Integer>());
                wts.add(new ArrayList<Integer>());
            }
            for(int i=0;i<m;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                int c = in.nextInt();
                addedge(adj,wts,a,b,c);
            } 
            for(int i=0;i<n;i++){
                int temp = in.nextInt();
            }
            algo(adj,wts,0,n);
            //System.out.println(days);
        }
}
class pqelement{
    int vnumber;
    int distance;

    pqelement(int x,int y){
        vnumber = y;
        distance = x;
    }
}