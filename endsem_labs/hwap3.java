import java.util.*;

public class hwap3{

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
		//System.out.println(a[0]);
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

	public static int partition(heapel[] arr,int low,int high){
		double pivot = arr[high].r;
		int i=low-1;
		for(int j=low;j<=(high-1);j++){
			if(arr[j].r<pivot){
				i++;
				heapel temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		heapel t = arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=t;
		/*for(int x=low;x<=high;x++)
            System.out.print(arr[x]+" ");
        System.out.println();*/
		return(i+1);
	}
	public static void sort(heapel[] arr,int low,int high){
		
		if(low<high){
			int pi = partition(arr,low,high);
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}
		

	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		heapel[] arr = new heapel[n];
		for(int i=0;i<n;i++){
			int x = in.nextInt();
			arr[i] = new heapel(x);
		}
		for(int i=0;i<n;i++){
			arr[i].c=in.nextInt();
		}
		for(int i=0;i<n;i++){
			arr[i].r = (double)arr[i].c/arr[i].s;
		}
		sort(arr,0,n-1);
		/*for(int i=0;i<arr.length;i++)
            System.out.print(arr[i].r+" ");
        System.out.println();
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i].c+" ");
        System.out.println();
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i].s+" ");
        System.out.println();*/

        double mc = 0;

        if(k==1){
        	double mincost = arr[0].c;
        	for(int i=1;i<n;i++){
        		if(mincost>arr[i].c){
        			mincost = arr[i].c;
        		}
        	}
        	mc = mincost;
        }
        else if(k>=2){
		int[] heaparr = new int[k-1];
		heapsize = -1;
		double sum=0;
		for(int i=0;i<k-1;i++){
			insert(heaparr,arr[i].s);
			sum = sum + arr[i].s;
		}
		double mincost;
		double multiplier = arr[k-1].r;
		mincost = multiplier*(sum)+arr[k-1].c;
		//System.out.println(multiplier+" "+sum+" "+arr[k-1].c+" "+mincost);
		sum = sum - heaparr[0]+arr[k-1].s;
		delete(heaparr);
		insert(heaparr,arr[k-1].s);
		for(int i=k;i<n;i++){

			double mul = arr[i].r;
			double val = mul*(sum)+arr[i].c;
			//System.out.println(mul+" "+sum+" "+arr[i].c+" "+val);
			if(val<mincost){
				mincost = val;
			}
			sum = sum-heaparr[0];
			delete(heaparr);
			sum = sum + arr[i].s;
			insert(heaparr,arr[i].s);
		}
		mc = mincost;
		}
		System.out.println((int)Math.ceil(mc));

	}
}

class heapel{
	int s;//skill
	int c;//cost
	double r;//cost/skill ratio

	heapel(int x){
		s=x;
		c=0;
		r=0;
	}
}