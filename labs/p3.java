import java.util.Scanner;

public class p3{

	public static int fibo(int x){
		if (x==1){
			return(1);
		}
		else if (x==2){
			return(1);
		}
		else{
			return(fibo(x-1)+fibo(x-2));
		}
	}

	public static void main(String[] args){
		Scanner prob = new Scanner(System.in);
		int x = prob.nextInt();
		for(int i=1; i<=x; i++){
			System.out.print(fibo(i)+" ");
		}
		System.out.println();
		
	}
}