import java.util.* ; 

public class fbp1{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		String s = input.nextLine();
		String[] arr  = s.split(" ");
		int sum=0;
		for(int k=0; k<n;k++){
			int temp = Integer.valueOf(arr[k]);
			int temp2=0;
			if(k>0 && Integer.valueOf(arr[k])>Integer.valueOf(arr[k-1])){
			if(1<=temp && temp<=10)
				temp2=2;
			else if(11<=temp && temp<=20)
				temp2=3;
			else if(21<=temp && temp<=30)
				temp2=4;
			else if(31<=temp && temp<=40)
				temp2=5;
			else if(41<=temp && temp<=50)
				temp2=6;
			sum = sum + temp2;
			System.out.println(sum);
			}
		}
		System.out.println(sum);
	}
}