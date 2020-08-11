import java.util.*;

public class heaps{

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
	public static void insert(int[] a, int x){
		/*for(int j=0;j<=heapsize;j++){
			System.out.print(a[j]+" ");
		}*/
		heapsize = heapsize+1;
		a[heapsize] = x;
		int i = heapsize;
		while (true){
			if(a[i]>a[parent(i)] && i>=1){
				int temp = a[i];
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
	public static void delete(int[] a){
		System.out.println(a[0]);
		a[0]=a[heapsize];
		heapsize=heapsize-1;
		heapify(a,0);
	}
	public static void heapbuilder(int[] a){
		int n = (heapsize-1)/2;
		for(int i=n;i>=0;i--){
			heapify(a,i);
		}
	}
	public static void heapify(int[] a, int i){
		int l = left(i);
		int r = right(i);
		int largest = -1;
		if(l<=heapsize && a[l]>a[i]){
			largest = l;
		}
		else{
			largest = i;
		}
		if(r<=heapsize && a[r]>a[largest]){
			largest=r;
		}
		if(largest!=i){
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			heapify(a,largest);
		}
	}
	public static int count = 0;
	public static int[] b = new int[100];
	public static void heapsort(int[] a){
		count = 0;
		while(heapsize>0){
			int max = a[0];
			b[count] = max;
			count = count+1;
			int temp = a[0];
			a[0] = a[heapsize];
			a[heapsize]=a[0];
			heapsize=heapsize-1;
			heapify(a,0);
		}
		b[count] = a[0];
		count = count+1;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[100];
		for(int i=0;i<n;i++){
			arr[i] = in.nextInt();
		}
		heapsize = n-1;
		heapbuilder(arr);
		insert(arr, 15);
		delete(arr);
		delete(arr);
		heapsort(arr);
		for(int i=count-1;i>=0;i--){
			System.out.print(b[i]+" ");
		}
		System.out.println();
	}
}