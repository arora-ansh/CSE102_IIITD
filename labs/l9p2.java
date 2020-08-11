import java.util.*;
	
public class l9p2{

	public static int heapsize;

	public static int left(int i){
		return 2*i+1;
	}

	public static int right(int i){
		return 2*i+2;
	}

	public static int parent(int i){
		return (i-1)/2;
	}
	public static void insert(long[] a, long x){
		/*for(int j=0;j<=heapsize;j++){
			System.out.print(a[j]+" ");
		}*/
		heapsize = heapsize+1;
		a[heapsize] = x;
		int i = heapsize;
		while (true){
			if(a[i]<a[parent(i)] && i>=1){
				long temp = a[i];
				a[i] = a[parent(i)];
				a[parent(i)] = temp;
				i = parent(i);
			}
			else
				break;
		}
		/*System.out.println(heapsize);
		for(int j=0;j<=heapsize;j++){
			System.out.print(a[j]+" ");
		}
		System.out.println();*/
	}
	public static long delete(long[] a){
		long temp = a[0];
		a[0]=a[heapsize];
		heapsize=heapsize-1;
		heapify(a,0);
		return temp;
	}
	public static void heapbuilder(long[] a){
		int n = (heapsize-1)/2;
		for(int i=n;i>=0;i--){
			heapify(a,i);
		}
	}
	public static void heapify(long[] a, int i){
		int l = left(i);
		int r = right(i);
		int smallest = -1;
		if(l<=heapsize && a[l]<a[i]){
			smallest = l;
		}
		else{
			smallest = i;
		}
		if(r<=heapsize && a[r]<a[smallest]){
			smallest=r;
		}
		if(smallest!=i){
			long temp = a[i];
			a[i] = a[smallest];
			a[smallest] = temp;
			heapify(a,smallest);
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] arr = new long[n];
		arr[0] = in.nextLong();
		arr[1] = in.nextLong();
		long[] arrx = new long[n];
		arrx[0] = -1;
		arrx[1] = -1;
		heapsize = 1;
		for(int i=2;i<n;i++){
			long x = in.nextLong();
			insert(arr,x);
			long t1 = delete(arr);
			long t2 = delete(arr);
			long t3 = delete(arr);
			//System.out.print(t1+" "+t2+" "+t3+"     ");
			arrx[i] = ((t1^t2)^t3);
			insert(arr,t1);
			insert(arr,t2);
			insert(arr,t3);
			/*for(int j=0;j<=heapsize;j++){
				System.out.print(arr[j]+" ");
			}
			System.out.println();*/
		}
		/*for(int j=0;j<n;j++){
			System.out.print(arrx[j]+" ");
		}
		System.out.println();*/
		int q = in.nextInt();
		for(int i=0;i<q;i++){
			int k = in.nextInt();
			System.out.println(arrx[k-1]);
		}
	}
}