import java.util.*;

public class stacks{
	static Node top=null;
	static int size=0;

	public static void push(Node n){
		n.setLink(top);
		top=n;
		size = size+1;
	}

	public static void pop(){
		System.out.println(top.data);
		top=top.link;
		size = size-1;
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
		Node n1 = new Node(1,null);
		Node n2 = new Node(2,null);
		Node n3 = new Node(3,null);
		push(n1);
		printstack();
		push(n2);
		printstack();
		push(n3);
		printstack();
		pop();
		printstack();
		pop();
		printstack();
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