import java.util.Scanner;
public class fbp3{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String[] arr1 = s1.split(" ");
		String s2 = in.nextLine();
		String[] arr2 = s2.split(" ");
		int num = 0;
		int n = Integer.valueOf(arr1[0]);
		for(int i=0;i<n-1;i++){
			for(int j=i+1;j<n;j++){
				if(Integer.valueOf(arr2[i])>=Integer.valueOf(arr1[1]) || Integer.valueOf(arr2[j])>=Integer.valueOf(arr1[1])){
					num=num+1;
				}
				else if(Integer.valueOf(arr2[i])+Integer.valueOf(arr2[j])>=Integer.valueOf(arr1[1])){
					num=num+1;
				}
			}
		}
		System.out.println(num);
	}
}