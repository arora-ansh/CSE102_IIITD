import java.util.*;

public class l3p1{

	public static int fibo(int x){
		if(x==0)
			return 0;
		else if(x==1)
			return 1;
		else if(x==2)
			return 1;
		else
			return fibo(x-3)+fibo(x-2)+fibo(x-1);
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(fibo(n-1));
	}
}