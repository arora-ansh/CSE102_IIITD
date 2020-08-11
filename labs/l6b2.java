import java.util.*;

public class l6b2{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int p = in.nextInt();
		int q = in.nextInt();
		Queue[] arr = new Queue[p];
		for(int i=0;i<q;i++){
			int qu=in.nextInt();
			if(qu==1){
				int pn = in.nextInt();
				arr[pn]
			}
			else if(qu==2){

			}
		}
	}
}
class Queue{
	static Node front=null;
	static Node rear=null;
	static int size=0;
	static int reqs=0;
	public static void enqueue(int x){
		Node n = new Node(x,null);
		if(rear==null){
			front=n;
		}
		else{
			rear.setLink(n);
		}
		rear=n;
		size=size+1;
	}
	public static void dequeue(){
		front = front.link;
		if(front==null){
			rear=null;
		}
		size=size-1;
	}
	public static void printqueue(){
		Node ptr = front;
		while(ptr.link!=null){
			System.out.print(ptr.data+" ");
			ptr=ptr.link;
		}
		System.out.print(ptr.data+" ");
		System.out.println();
	}
	public static void printsize(){
		System.out.println(size);
	}
}
class Node{
	public int data;
	public Node link;

	Node(int n){
		data = n;
		link = null;
	}
	Node(int n, Node p){
		data = n;
		link = p;
	}
	public void setLink(Node p){
		link = p;
	}
}