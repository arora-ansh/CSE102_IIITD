import java.util.Scanner;

public class p2{
	public static int pow(int a, int n){
		int fin=1;
		for(int i=1;i<=n;i++){
			fin=fin*a;
		}
		return fin;
	}
	public static void main(String[] args){
		Scanner prob = new Scanner(System.in);
		int x = prob.nextInt();
		String y = Integer.toString(x);
		int n=y.length();
		int sum=0;
		int temp1, temp2;
		String temp;
		for(int i=0;i<n;i++){
			temp = y.substring(i,i+1);
			temp1= Integer.valueOf(temp);
			temp2=pow(temp1 ,n);
			sum=sum+temp2;
		}
		if(x==sum){
			System.out.println("Yus");
		}
		else{
			System.out.println("Nope");
		}
	}
}