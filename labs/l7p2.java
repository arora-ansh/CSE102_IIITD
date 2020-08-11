import java.util.*;

public class l7p2{

	public static Node broot = null;

	public static int x = 0; //This gives us the parent nodes from the preorder case
	public static Node treegen(int[] preo, int[] ino, int first, int last){
		if(first>last){
			return null;
		}
		Node root = new Node(preo[x],null,null);
		x = x+1;
		if(first==last){
			return root;
		}
		int y=-1;
		for(int i=first;i<=last;i++){
			if(ino[i]==root.data){
				y=i;
			}
		}
		root.left = treegen(preo,ino,first,y-1);
		root.right = treegen(preo,ino,y+1,last);
		return root;
	}

	public static void postdisplay(Node root){
		if(root!=null){
			postdisplay(root.left);
			postdisplay(root.right);
			System.out.print(root.data+" ");
		}
	}
	public static int nodecount(Node root){
		if(root==null){
			return(0);
		}
		else{
			return(1+nodecount(root.left)+nodecount(root.right));
		}
	}
	public static int height(Node root){
		if(root==null){
			return(0);
		}
		else{
			return(1+Math.max(height(root.left),height(root.right)));
		}
	}
	public static Node copier(Node root){
		if(root==null){
			return null;
		}
		else{
			Node copy = new Node(root.data,null,null);
			copy.left = copier(root.left);
			copy.right = copier(root.right);
			return copy;
		}
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] preo = new int[n];
		int[] ino = new int[n];
		for(int i=0;i<n;i++){
			preo[i] = in.nextInt();
		}
		for(int i=0;i<n;i++){
			ino[i] = in.nextInt();
		}
		Node lol = treegen(preo,ino,0,n-1);
		postdisplay(lol);
		int oof = 0;
		for(int i=1;i<n;i++){
			if(ino[i]<ino[i-1])
				oof=1;
		}
		System.out.println();
		if(oof==0){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}

class Node{
	int data;
	Node left;
	Node right;

	public Node(int x,Node a,Node b){
		data = x;
		left = a;
		right = b;
	}

	public void setLeft(Node a){
		left = a;
	}

	public void setRight(Node b){
		right = b;
	}
}