	import java.util.*;

	public class msl2{
		static Node rear;
		
		public static void einsert(Node ni){
			rear = ni;
			rear.link = ni;
		}
		public static void insert(Node n, Node ni){
			ni.setLink(n.link);
			n.link = ni;
		}
		public static void printlist(){
			Node ptr = rear.link;
			System.out.print("List: ");
			while(ptr.link!=rear){
				System.out.print(ptr.data+" ");
				ptr=ptr.link;
			}
			System.out.print((ptr.link).data);
			System.out.println();
		}
		public static void main(String[] args){
			Scanner in = new Scanner(System.in);
			long q = in.nextLong();
			Node[] arr = new Node[1000000];
			long[] arr2 = new long[1000000];
			arr[0] = new Node(1,null);
			einsert(arr[0]);
			Node posx=arr[0];
			int pos=0;
			int count=0;
			int c=0;
			for(int i=0;i<q;i++){
				int qu = in.nextInt();
				if(qu == 1){
					long temp=in.nextLong();
					count = count+1;
					arr[count]=new Node(temp,null);
					insert(arr[pos],arr[count]);
					printlist();
				}
				else if(qu == 2){
					pos = pos+1;
					//posx=posx.link;
					printlist();
				}
				else if(qu == 3){
					arr2[c]=arr[pos].data;
					c=c+1;	
					printlist();
				}
			}
			for(int i=0;i<c;i++){
				System.out.println(arr2[i]);
			}
		}
	}

	class Node{
	public long data;
	public Node link;
	public Node pos;

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