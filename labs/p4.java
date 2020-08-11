import java.util.Scanner;

public class p4{

	public static void main(String[] args){
		System.out.print("Enter number of Rows: ");
		Scanner prob1 = new Scanner(System.in);
		int m = prob1.nextInt();
		System.out.print("Enter number of Columns: ");
		Scanner prob2 = new Scanner(System.in);
		int n = prob2.nextInt();
		System.out.println("Enter elements for Matrix 1: ");
		int[][] a1 = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print("Enter element for "+(i+1)+","+(j+1)+" : ");
				Scanner temp = new Scanner(System.in);
				a1[i][j]=temp.nextInt();
			}
		}
		System.out.println("Enter elements for Matrix 2: ");
		int[][] a2 = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print("Enter element for "+(i+1)+","+(j+1)+" : ");
				Scanner temp = new Scanner(System.in);
				a2[i][j]=temp.nextInt();
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(a1[i][j]+a2[i][j]+" ");
			}
			System.out.println();
		}
	}
}