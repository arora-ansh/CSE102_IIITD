import java.io.*;
import java.util.*;
/**
 * crushit
 */
public class l8jhu {
    static long egg_max=0;
    public long heap[];
    int size;
    int size_max;
    l8jhu(int size_max){
        this.size_max=size_max;
        this.size=0;
        heap=new long[this.size_max+1];
    }
    int parent(int position){
        return (position)/2;
    }
    int rightchild(int position){
        return (2*position)+2;
    }
    int leftchild(int position){
        return (2*position)+1;
    }
    void swap_places(int position_1,int position_2){
        long temp=0;
        temp=heap[position_1];
        heap[position_1]=heap[position_2];
        heap[position_2]=temp;
    }
    void heapify(int pos){
        boolean b=(pos>=(size/2)&&pos<=size)?true:false;
        if(!b){
            if(heap[pos]<heap[leftchild(pos)]||heap[pos]<heap[rightchild(pos)]){
                if(heap[leftchild(pos)]>heap[rightchild(pos)]){
                    swap_places(pos, leftchild(pos));
                    heapify(leftchild(pos));
                }
                else{
                    swap_places(pos, rightchild(pos));
                    heapify(rightchild(pos));
                }
            }
        }
    }
    public void insert(Long val){
        if(size>=size_max){
            return;
        }
        heap[size]=val;
        size+=1;
        int cur=size-1;
        while(heap[cur]>heap[parent(cur)]){
            swap_places(cur, parent(cur));
            cur=parent(cur);
        }
        
    }
    long delete(){
        long rem=heap[0];
        heap[0]=heap[size-1];
        size=size-1;    
        heapify(0);
        return rem;
    }
    public static void main(String[] args)throws IOException{
        InputStreamReader read=new InputStreamReader(System.in);
        BufferedReader in=new BufferedReader(read);
        Scanner sc=new Scanner(System.in);
        long k=sc.nextLong();
        int n=sc.nextInt();
        // String nn[]=in.readLine().split(" ");
        l8jhu mh=new l8jhu(n);
        for (int i = 0; i < n; i++) {
            // mh.insert(Long.parseLong(nn[i]));
            mh.insert(sc.nextLong());
        }
        long count = 0;
        while(count<k){
            long v=mh.delete();
            egg_max=egg_max+v;
            mh.insert(v/2);
            // System.out.println("value deleted: "+v);
            // for (int i = 0; i < mh.size; i++) {
            //     System.out.print(mh.heap[i]+" ");
            // }
            // System.out.println();
            count+=1;
        }
        System.out.print(egg_max);
        sc.close();
    }
}