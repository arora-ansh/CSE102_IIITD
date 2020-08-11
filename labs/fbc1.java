import java.lang.Math;
import java.util.*;
public class fbc1{
    public static int[] solution(int area) {
        // Your code here
        int[] arr = new int[1000];
        int i = 0;
        while (true){
            double t = Math.sqrt(area);
            //System.out.println(t);
            int u = (int)Math.floor(t);
            //System.out.println(u);
            arr[i]=u*u;
            i=i+1;
            area = area - (u*u);
            if(area<=0){
                break;
            }
        }
        System.out.print("    ");
        for(int j=0;j<i;j++){
            if(j<i-1)
                System.out.print(arr[j]+",");
            else
                System.out.print(arr[j]);
        }
        System.out.println();
        return arr;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        solution(n);
    }
    
}