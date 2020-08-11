import java.util.*;

public class hwbp7{

    public static void addedge(ArrayList<ArrayList<Integer>> adj,int x,int y){
		adj.get(x).add(y);
		adj.get(y).add(x);
    }

    public static int[] BFSnew(int v,int n,ArrayList<ArrayList<Integer>> adj, boolean[] visited,int[] dist_arr,boolean[] hot){
        //int distance = 0;
        //int lastvisit=0;
        //int[] dist_arr = new int[n];
		ArrayList<Integer> list = new ArrayList<Integer>();
        visited[v]=true;
        dist_arr[v]=0;
        //distance+=1;
		list.add(v);
		while(list.size()!=0){
			//System.out.println("Level ");
			int u = list.get(0);
			//System.out.print(u+" ");
            list.remove(0);
            /*if(visited[u]==true && hot[u]==true && u!=v){
                //System.out.println("Hotspot at "+u);
                lastvisit = u;
            }*/
            for(int i=0; i<adj.get(u).size(); i++){
                int b = adj.get(u).get(i);
                //System.out.print(b+" ");
                if(visited[b]==false){
                    list.add(b);
                    visited[b]=true;
                    dist_arr[b]=dist_arr[u]+1;
                    //System.out.println("Updating distance of "+ b +" to "+dist_arr[b]);
                }
                
            }
            //System.out.println(list.size());
        }
        /*for(int i=0;i<n;i++){
            System.out.println(i+" "+dist_arr[i]);
        }*/
        return dist_arr;
    
    }
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();//number of cities
        int h = in.nextInt();//no of hotspots
        int x = in.nextInt();//max dist
        int[] hotlist = new int[h];//array of hotspots
        boolean[] hot = new boolean[n];
        for(int i=0;i<h;i++){
            hotlist[i]=in.nextInt()-1;
            hot[hotlist[i]]=true;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(n);
		for(int i=0;i<n;i++){
			adj.add(new ArrayList<Integer>());
		}
        for(int i=0;i<n-1;i++){
            int a1 = in.nextInt()-1;
            int a2 = in.nextInt()-1;
            addedge(adj,a1,a2);
        }
        //BFSnew(0,5,adj,x);
        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];
        boolean[] visited3 = new boolean[n];
        /*for(int i=0;i<h;i++){
            visited1[hotlist[i]]=true;
            visited2[hotlist[i]]=true;
            visited3[hotlist[i]]=true;
        }*/
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int[] arrx = BFSnew(0,n,adj,visited1,arr1,hot);
        int x1=-1;
        int maxdist1 = -1;
        for(int i=0;i<h;i++){
            if(maxdist1<arrx[hotlist[i]]){
                x1=hotlist[i];
                maxdist1=arrx[hotlist[i]];
            }
        }
        //System.out.println("x1="+x1);
        int[] arry = BFSnew(x1,n,adj,visited2,arr2,hot);
        int x2=-1;
        int maxdist2 = -1;
        for(int i=0;i<h;i++){
            if(maxdist2<arry[hotlist[i]]){
                x2=hotlist[i];
                maxdist2=arry[hotlist[i]];
            }
        }
        //System.out.println("x2="+x2);
        int[] arrz = BFSnew(x2,n,adj,visited3,arr3,hot);
        //arr2[x1]=0;
        // arr3[x2]=0;
        /*for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
        for(int i=0;i<arr3.length;i++){
            System.out.print(arr3[i]+" ");
        }
        System.out.println();*/
        int y=0;
        for(int i=0;i<n;i++){
            if(arry[i]<=x && arrz[i]<=x){
                y=y+1;
            }
        }
        System.out.println(y);

    }
}