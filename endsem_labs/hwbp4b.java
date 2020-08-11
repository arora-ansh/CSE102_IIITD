import java.util.*;

public class hwbp4b{

        public static int search(ArrayList<Long> arr, int start, int end, long key){
            if(end>=start){
                int mid = start + (end-start)/2;
                if(arr.get(mid)==key){
                    return mid;
                }
                else if(arr.get(mid)>key){
                    return search(arr,start,mid-1,key);
                }
                else{
                    return search(arr,mid+1,end,key);
                }
            }
            return -1;
        }
        public static int binsearch(ArrayList<Long> arr, long key){
            int start = 0;
            int end = arr.size()-1;
            return search(arr,start,end,key); 
        }
        public static void algo(ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Long>> wts,int src,int V, ArrayList<ArrayList<Long>> ptimes){
            long[] dist = new long[V];
            Boolean[] listdone = new Boolean[V];
            PriorityQueue<pqelement> pq = new PriorityQueue<pqelement>(new Comp());
           
            for(int i=0;i<V;i++){
                dist[i] = Long.MAX_VALUE;
                listdone[i] = false;
            }
            dist[src] = 0;
            int sour=binsearch(ptimes.get(0), 0);
            if(sour!=-1){
                while(sour<ptimes.get(0).size() && ptimes.get(0).get(sour)==dist[src]){
                    dist[src]++;
                    sour++;
                }  
            }
            pqelement pqx1 = new pqelement(dist[src],src);
            pq.add(pqx1);
            while(pq.size()!=0){
                //int cur = mindist(dist,listdone,V);
                int cur = pq.poll().vnumber;
                listdone[cur]=true;
                for(int j=0;j<adj.get(cur).size();j++){
                    int x = adj.get(cur).get(j);
                    if(listdone[x]==false){
                        long wtadd = wts.get(cur).get(j);
                        long d = dist[cur]+wtadd;
                        if(x==adj.size()-1){
                            if(d<dist[x]){
                                dist[x] = d;
                                //System.out.println(dist[x]);
                                pqelement temp = new pqelement(dist[x],x);
                                pq.add(temp);
                            }
                            continue;
                        }
                        int k=binsearch(ptimes.get(x), d);
                        if(k!=-1){
                            while(k<ptimes.get(x).size() && ptimes.get(x).get(k)==d){
                                d++;
                                k++;
                            }   
                        }
                        //System.out.println(wtadd);
                        if(d<dist[x]){
                            dist[x] = d;
                            //System.out.println(dist[x]);
                            pqelement temp = new pqelement(dist[x],x);
                            pq.add(temp);
                        }
                    }
                }
            }
            if(dist[V-1]<Long.MAX_VALUE)
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
            else if(x.distance<y.distance){
                return -1;
            }
            return 0;
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