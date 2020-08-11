import java.util.*;

public class l8p2{

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
			if(a[i]>a[parent(i)] && i>=1){
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
			long temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			heapify(a,largest);
		}
	}
	public static int count = 0;
	public static long[] b = new long[100000];
	public static void heapsort(long[] a){
		count = 0;
		while(heapsize>0){
			long max = a[0];
			b[count] = max;
			count = count+1;
			long temp = a[0];
			a[0] = a[heapsize];
			a[heapsize]=a[0];
			heapsize=heapsize-1;
			heapify(a,0);
		}
		b[count] = a[0];
		count = count+1;
	}

	public static long sum(long[] arr,int i, int j){
		/*System.out.print("i = "+i+" j = "+j+" ");
		for(int l=0;l<arr.length;l++){
			System.out.print(arr[l]+" ");
		}
		System.out.println();
		for(int l=i;l<=j;l++){
			System.out.print(arr[l]+" ");
		}
		System.out.println();*/
		long x = 0;
		for(int l=i;l<=j;l++){
			x=x+arr[l];
		}
		return x;
	}
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
			int n = in.nextInt();
			int k = in.nextInt();
			long[] arr = new long[n];
			for(int j=0;j<n;j++){
				arr[j] = in.nextLong();
			}
			long[] a = new long[n+1];
			long[] b = new long[100000];
			heapsize=-1;
			a[0] = 0;
			a[1] = arr[0];
			for(int j=2;j<=n;j++){
				a[j]=a[j-1]+arr[j-1];
			}
			long min;
			for(int j=n;j>1;j--){
				for(int m=n-1;m>0;m--){
					long temp = arr[j-1]-arr[m-1];
					insert(b,temp);
					/*if(j==n && m==n-1){
						min = temp;
					}
					else if(temp<min){
						min = temp;
					}*/

					if(heapsize>=100000){
						break;
					}
				}
			}
			for(int j=0;j<=heapsize;j++){
				System.out.print(b[j]+" ");
			}
			/*int c = 0;
			heapsize = -1;
			for(int j=0;j<n;j++){
				for(int m=j;m<n;m++){
					if(c>=100000){
						break;
					}
					long x = sum(arr,j,m);
					a[c] = x;
					c = c+1;
				}
			}*/
			for(int j=0;j<k;j++){
				System.out.print(delete(b)+" ");
			}
			System.out.println();
			/*long[] arrx = new long[c];
			for(int j=0;j<c;j++){
				arrx[j] = a[j];
			}*/
			/*heapsize = c-1;
			heapbuilder(arrx);
			heapsort(arrx);
			for(int j=0;j<k;j++){
				System.out.print(b[j]+" ");
			}
			System.out.println();*/
			/*Arrays.sort(arrx);
			for(int j=arrx.length-1;j>arrx.length-k-1;j--){
				System.out.print(arrx[j]+" ");
			}
			System.out.println();*/
			/*for(int j=0;j<c;j++){
				System.out.print(a[j]+" ");
			}
			heapbuilder(a);*/
			//heapsort(a);
			//heapsize=c-1;
			//System.out.println();
			/*Arrays.sort(a);
			for(int j=c-1;j>c-k-1;j--){
				System.out.print(a[j]+" ");
			}
			System.out.println();*/
		}
		
	}
}