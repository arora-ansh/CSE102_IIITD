import java.util.*;

public class LinkList{
	static Node front;
	public static void flinsert(Node n){
		if(front == null){
			front = n;
		}
		else{
			n.setLink(front);
			front = n;
		}
	}

	public static void blinsert(Node n){
		Node ptr = front;
		while(ptr.link!=null){
			ptr = ptr.link;
		}
		ptr.setLink(n);
	}
	public static void printlist(){
		Node ptr = front;
		while(ptr.link!=null){
			System.out.print(ptr.data+" ");
			ptr=ptr.link;
		}
		System.out.print(ptr.data+" ");
		System.out.println();
	}

	public static void deletelast(){
		Node ptr = front;
		Node cur = front.link;
		while(cur.link!=null){
			ptr=cur;
			cur=ptr.link;
		}
		ptr.link = null;
	}
	public static void delete(Node n){
		Node ptr = front;
		while (true){
			if(ptr.link==n){
				ptr.setLink(n.link);
				break;
			}
			ptr=ptr.link;
		}
	}

	public static void insert(Node n1, Node n2){
		n2.setLink(n1.link);
		n1.link = n2;
	}

	public static void main(String[] args){

		/*Node o1 = new Node(50,null);
		Node o2 = new Node(30,null);
		Node o3 = new Node(20,null);
		flinsert(o1);
		o1.setLink(o2);
		o2.setLink(o3);
		printlist();
		deletelast();
		flinsert(o3);
		printlist();*/
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		/*int k = in.nextInt();*/
		Node[] arr = new Node[n];
		for(int i=0;i<n;i++){
			int temp = in.nextInt();
			arr[i] = new Node(temp, null);
		}
		for(int i=0;i<n;i++){
			if(i==0)
				flinsert(arr[0]);
			else
				arr[i-1].setLink(arr[i]);
		}
		int[] arr3 = new int[n];
		for(int i=0;i<n;i++){
			arr3[i]=arr[i].getData();
		}
		/*for(int i=0;i<k;i++){
			deletelast();
			flinsert(arr[n-1-i]);
		}*/
		//Reversal
		for(int i=0;i<n-1;i++){
			deletelast();
			if(i==0)
				flinsert(arr[n-1]);
			else
				insert(arr[n-i],arr[n-1-i]);
		}
		int[] arr4 = new int[n];
		for(int i=0;i<n;i++){
			arr4[i]=arr[i].getData();
		}
		int key = 0;
		for(int i=0;i<n;i++){
			if(arr3[i]!=arr4[i]){
				key=1;
			}
		}
		if(key==0)
			System.out.println("Palindrome");
		else{
			System.out.println("Nope");
		}
		/*int[] arr2 = new int[n];
		int s = 0;
		for(int i=0;i<n;i++){
			int key=0;
			for(int j=0;j<arr2.length;j++){
				if(arr2[j]==arr[i].data){
					delete(arr[i]);
					key=1;
				}
			}
			if(key==0){
				int t  = arr[i].getData();
				arr2[s]=t;
				s=s+1;
			}
		}*/
		printlist();
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