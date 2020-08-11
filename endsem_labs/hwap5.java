import java.util.*;

public class hwap5{

	public static tunnel[] tunarr = new tunarr[n-1];
	public static bunker[] bunk = new bunker[n];
	public static long distance = 0;
	public static int checker(int[] options){
		if(options.length==1){
			return options[0];
		}
		else{
			for(int i=0;i<options.length;i++){
				int check = options[i];
				if(tunarr[check].pa==e||tunarr[check].pb==e){
					return check;
				}
				else if(bunk[(tunarr[check].pa)-1].supplies||bunk[(tunarr[check].pb)-1].supplies){
					return check;
				}
			}
		}
		return -1;
	}

	public static int solver(){
		if(cur==e){
			System.out.println("escaped");
			return 0;
		}
		else if(bunk[cur-1].supplies){
			System.out.println(distance);
			return 0;
		}
		else{
			int opcount = 0;
			int[] options = new int[n-1];
			for(int i=0;i<n-1;i++){
				if(tunarr[i].pa==cur || tunarr[i].pb==cur){
					options[opcount]=i;
				}
			}
			int cur
		}

	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();//number of bunkers
		int s = in.nextInt();//number of bunkers with supplies
		int q = in.nextInt();//number of queries
		int e = in.nextInt();//escape tunnel 
		for(int i=0;i<n;i++){
			tunarr[i].pa = in.nextInt();
			tunarr[i].pb = in.nextInt();
			tunarr[i].d = in.nextLong();
		}
		for(int i=0;i<s;i++){
			int num = in.nextInt();
			bunk[num-1].supplies=true;
		}
		for(int i=0;i<q;i++){
			int tbomb = in.nextInt();
			int cur = in.nextInt();
		}
	}
}
class tunnel{
	int pa;
	int pb;
	long d;
}
class bunker{
	boolean supplies;
}