import java.util.*;

public class l6b1{

	static Node top=null;
	static int size=0;

	public static void push(Node n){
		n.setLink(top);
		top=n;
		size = size+1;
	}

	public static long pop(){
		long x = top.data;
		top=top.link;
		size = size-1;
		return x;
	}

	public static void printstack(){
		Node ptr = top;
		System.out.println("Stack: ");
		while(ptr.link!=null){
			System.out.print(ptr.data+" ");
			ptr=ptr.link;
		}
		System.out.println(ptr.data);
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		String[] arr = s.split(" ");
		Node[] arrx = new Node[1000000];
		int count=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals("+") || arr[i].equals("-") || arr[i].equals("*")){
				if(arr[i].equals("+")){
					long temp1 = pop();
					long temp2 = pop();
					arrx[count] = new Node(temp1 + temp2,null);
					push(arrx[count]);
					count=count+1;
				}
				else if(arr[i].equals("-")){
					long temp1 = pop();
					long temp2 = pop();
					arrx[count] = new Node(temp2 - temp1,null);
					push(arrx[count]);
					count=count+1;
				}
				else if(arr[i].equals("*")){
					long temp1 = pop();
					long temp2 = pop();
					arrx[count] = new Node(temp1 * temp2,null);
					push(arrx[count]);
					count=count+1;
				}

			}
			else{
				long temp = Long.parseLong(arr[i]);
				arrx[count] = new Node(temp,null);
				push(arrx[count]);
				count=count+1;
			}
		}
		long ans = pop();
		System.out.println(ans);
	}


}

class Node{
	public long data;
	public Node link;

	Node(long n){
			data = n;
			link = null;
	}
	Node(long n, Node p){
			data = n;
			link = p;
	}
	public void setLink(Node p){
			link = p;
	}
	public long getData(){
			return data;
	}
}