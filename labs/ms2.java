import java.util.*;

public class ms2{
	static Node front=null;
	static int size=0;
	public static void flinsert(Node n){
		if(front == null){
			front = n;
		}
		else{
			n.setLink(front);
			front = n;
		}
	}
	public static void printlist(){
		System.out.print("List: ");
		Node ptr = front;
		while(ptr.link!=null){
			System.out.print(ptr.data+" ");
			ptr=ptr.link;
		}
		System.out.print(ptr.data+" ");
		System.out.println("Size: "+size);
	}
	public static void insert(Node n1, Node n2){
		n2.setLink(n1.link);
		n1.link = n2;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		Node[] arr = new Node[100000];
		for(int i=0;i<n;i++){
			int temp = in.nextInt();
			arr[i] = new Node(temp,null);
			if(i==0)
				flinsert(arr[i]);
			else
				insert(arr[i-1],arr[i]);
		}
		int count = n;
		Node pos = new Node(1,null);
		if(n!=0)
			pos = arr[0];
		size = n;
		for(int i=0;i<q;i++){
			int qu = in.nextInt();
			if(qu==1){
				if(front!=null){
					System.out.println(pos.data);
					printlist();
				}
			}
			else if(qu==2){
				if(pos.link!=null && front!=null){
					pos = pos.link;
					printlist();
				}
			}
			else if(qu==3){
				int temp = in.nextInt();
				arr[count] = new Node(temp,null);
				if(size==0){
					flinsert(arr[count]);
					size = size+1;
				}
				else{
					insert(pos,arr[count]);
					size = size+1;
				}
				count = count+1;
				printlist();
			}
		}
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
		public int getData(){
			return data;
		}
	}