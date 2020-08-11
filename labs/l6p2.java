import java.util.*;

public class l6p2{
	static Node top=null;
	static int size=0;

	public static void push(Node n){
		n.setLink(top);
		top=n;
		size = size+1;
	}

	public static void pop(){
		//System.out.println(top.data);
		top=top.link;
		size = size-1;
	}

	public static long peek(){
		return(top.data);
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
		int n = in.nextInt();
		Node[] arr = new Node[n];
		int count = 0;
		for(int i=0;i<n;i++){
			long x = in.nextLong();
			if(i==0){
				arr[count]=new Node(x,null);
				push(arr[count]);
				count=count+1;
				//printstack();
			}
			else{
				arr[count]=new Node(x,null);
				while(size>0 && peek()<x){
						pop();
				}
				push(arr[count]);
				count=count+1;
				//printstack();
			}
			System.out.println(size);
		}
		
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
}