import java.util.Scanner;

public class p1{
	public static void prime(int x, int y) {
		int i=x, key=0;
		while (i<=y) {
			for(int j=2;j<i;j++) {
				if(i%j==0){
					key=key+1;
				}
			}
			if (key==0){
				System.out.print(i+" ");
			}
			key=0;
			i=i+1;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner x1 = new Scanner(System.in);
		int x = x1.nextInt();
		Scanner y1 = new Scanner(System.in);
		int y = y1.nextInt();
		prime(x,y);

	}
}
