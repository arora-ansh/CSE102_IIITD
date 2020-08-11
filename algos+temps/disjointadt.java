import java.util.*;
public class disjointadt{
    public static void main(String[] args){
        int n=10;
        disjointset set = new disjointset(n);
        set.union(0,1);
        set.union(2,3);
        set.union(3,4);
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
    void union(int x, int y){
        int xparent = find(x);//We find dono ke parents after which we will compare and put them in the same set based on index
        int yparent = find(y);//basically join the tree
        if(xroot == yroot){
            return; //already same mei hain
        }
        else if(rank[xparent]<rank[yparent]){
            parent[xparent]=yparent;
        }
        else if(rank[yparent]<rank[xparent]){
            parent[yparent]=xparent;
        }
        else{
            parent[yparent] = xparent;
            rank[xparent] = rank[xparent]+1;//Number of objects under it
        }
    }
}