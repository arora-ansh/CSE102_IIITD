import java.util.*;

public class hwap2{

	public static int partition(double[] arr,int low,int high){
		double pivot = arr[high];
		int i=low-1;
		for(int j=low;j<=(high-1);j++){
			if(arr[j]<pivot){
				i++;
				double temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		double t = arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=t;
		/*for(int x=low;x<=high;x++)
            System.out.print(arr[x]+" ");
        System.out.println();*/
		return(i+1);
	}
	public static void sort(double[] arr,int low,int high){
		/*for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();*/
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
		int[][] arr = new int[n][3];
		for(int i=0;i<n;i++){
			arr[i][0] = in.nextInt();
		} 
		for(int i=0;i<n;i++){
			arr[i][1] = in.nextInt();
		}
		double[] temparr2 = new double[n];
		int count = 0;
		for(int i=0;i<n;i++){
			//System.out.println("Case "+(i+1));
			float multiplier = (float)arr[i][1]/arr[i][0];
			//System.out.println(multiplier);
			float[] temparr = new float[n];
			int c=0;
			for(int j=0;j<n;j++){
				float temp=arr[j][0]*multiplier;
				if(temp>=arr[j][1]){
					//temparr[j]=arr[j][0]*multiplier;
					temparr[c]=temp;
					//System.out.println(temparr[c]+" "+arr[j][1]);
					c=c+1;
				}
			}
			double[] tempx = new double[c];
			for(int j=0;j<c;j++){
				tempx[j]=temparr[j];
			}
			if(c>=k){
				sort(tempx,0,c-1);
				for(int j=0;j<k;j++){
					//System.out.print(tempx[j]+" ");
					//System.out.println();
					temparr2[count]=temparr2[count]+tempx[j];
				}
				count=count+1;
			}
		}
		//System.out.println(count);
		double[] temparr3 = new double[count];
		for(int i=0;i<count;i++){
			temparr3[i] = temparr2[i];
		}
		sort(temparr3,0,count-1);
		System.out.println((int)Math.ceil(temparr3[0]));
	}
}