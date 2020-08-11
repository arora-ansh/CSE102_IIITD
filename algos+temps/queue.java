import java.util.*;
public class queue{
	static Node front=null;
	static Node rear=null;
	static int size=0;
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
	public static void main(String[] args){
		enqueue(8);
		printqueue();
		printsize();
		enqueue(3);
		printqueue();
		printsize();
		dequeue();
		printqueue();
		printsize();
		enqueue(2);
		printqueue();
		printsize();
		enqueue(5);
		printqueue();
		printsize();
		dequeue();
		printqueue();
		printsize();
		dequeue();
		printqueue();
		printsize();
		enqueue(9);
		printqueue();
		printsize();
		enqueue(1);
		printqueue();
		printsize();
		//System.out.println(front.data+" "+(front.link).data+" "+((front.link).link).data);
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

