import java.util.*;

public class hwbp3{

        public static boolean search(ArrayList<Long> arr, int start, int end, long key){
            if(end>=start){
                int mid = start + (end-start)/2;
                if(arr.get(mid)==key){
                    return true;
                }
                else if(arr.get(mid)>key){
                    return search(arr,start,mid-1,key);
                }
                else{
                    return search(arr,mid+1,end,key);
                }
            }
            return false;
        }
        public static boolean binsearch(ArrayList<Long> arr, long key){
            int start = 0;
            int end = arr.size()-1;
            return search(arr,start,end,key); 
        }
        public static void algo(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Long>> wts,int src,int V, ArrayList<ArrayList<Long>> ptimes){
            long[] dist = new long[V];
            Boolean[] listdone = new Boolean[V];
            PriorityQueue<pqelement> pq = new PriorityQueue<pqelement>(new Comp());
           
            for(int i=1;i<V;i++){
                dist[i] = Long.MAX_VALUE;
                listdone[i] = false;
            }
            int k1=0;
            long w1=0;
            while(k1!=1){
                if(!binsearch(ptimes.get(src),w1)){
                    k1=1;
                }
                else{
                    w1=w1+1;
                }
            }
            dist[src] = w1;
            pqelement pqx1 = new pqelement(w1,src);
            pq.add(pqx1);
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
                    long wtadd =wts.get(cur).get(j);
                    int k=0;
                    while(k!=1){
                        if(!binsearch(ptimes.get(x), dist[cur]+wtadd)){
                            k=1;
                        }
                        else{
                            wtadd=wtadd+1;
                        }
                    }
                    //System.out.println(wtadd);
                    if(dist[cur]!=Long.MAX_VALUE && listdone[x]==false && dist[cur]+wtadd<dist[x]){
                        dist[x] = dist[cur] + wtadd;
                        //System.out.println(dist[x]);
                        pqelement temp = new pqelement(dist[x],x);
                        pq.add(temp);
                    }
                }
            }
            //if(dist[V-1]<Long.MAX_VALUE)
            if(listdone[V-1]==true)
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

        public static void addedge(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Long>> wts,int x,int y,long w){
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
            ArrayList<ArrayList<Long>> wts = new ArrayList<ArrayList<Long>>(n);
            ArrayList<ArrayList<Long>> ptimes = new ArrayList<ArrayList<Long>>(n);
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<Integer>());
                wts.add(new ArrayList<Long>());
                ptimes.add(new ArrayList<Long>());
            }
            for(int i=0;i<m;i++){
                int a = in.nextInt();
                int b = in.nextInt();
                long c = in.nextLong();
                addedge(adj,wts,a,b,c);
            } 
            for(int i=0;i<n;i++){//Array list storing the time at which patrol-ing is made
                int psize = in.nextInt();
                for(int j=0;j<psize;j++){
                    long indtime = in.nextLong();
                    ptimes.get(i).add(indtime);
                }
            }
            /*for(int i=0;i<n;i++){
                System.out.println(ptimes.get(i));
            }*/
            algo(adj,wts,0,n,ptimes);
            //System.out.println(days);
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