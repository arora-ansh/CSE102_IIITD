import java.util.*;
public class l6p1{
	static Node front=null;
	static Node rear=null;
	static int size=0;
	public static void enqueue(Node n){
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
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node[] arr = new Node[1000];
		int count = 0;
		for(int i=0;i<n+1;i++){
			String temp = in.nextLine();
			String[] temparr = temp.split(" ");
			/*for(int j=0;j<temparr.length;j++)
				System.out.print(temparr[j]+" ");
			System.out.println();*/
			if(temparr[0].equals("enqueue")==true){
				long x = Long.parseLong(temparr[1]);
				arr[count]=new Node(x,null);
				enqueue(arr[count]);
				count = count+1;
				System.out.println(front.data);
			}
			else if(temparr[0].equals("dequeue")==true){
				if(size>0)
					dequeue();
				if(size==0)
					System.out.println("EMPTY");
				else
					System.out.println(front.data);
			}
			else if(temparr[0].equals("inc")==true){
				int l = Integer.parseInt(temparr[1]);
				long d = Long.parseLong(temparr[2]);
				Node ptr = front;
				for(int j=0;j<(size-l);j++)
					ptr=ptr.link;
				while(ptr.link!=null){
					ptr.data=ptr.data + d;
					ptr=ptr.link;
				}
				ptr.data = ptr.data + d;
				System.out.println(front.data);
			}
			
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

