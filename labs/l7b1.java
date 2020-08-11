import java.util.*;

public class l7b1{

	public static Node broot = null;

	public static void predisplay(Node root){
		if(root!=null){
			System.out.print(root.data+" ");
			predisplay(root.left);
			predisplay(root.right);
		}
	}
	public static void indisplay(Node root){
		if(root!=null){
			indisplay(root.left);
			System.out.print(root.data+" ");
			indisplay(root.right);
		}
	}

	public static void insum(Node root){
		if(root!=null){
			insum(root.left);
			//System.out.print(root.data+" ");
			summer(root);
			System.out.println(sum-root.data);
			sum=0;
			insum(root.right);
		}
	}

	public static boolean bstrulefollow(Node root, int prev){
		if(root.data<prev){
			return false;
		}
		if(root!=null){
			indisplay(root.left);
			System.out.print(root.data+" ");
			indisplay(root.right);
		}
		return true;
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
	public static boolean bstsearch(Node root, int key){
		Node current = root;
		while(current!=null){
			if(current.data==key){
				return(true);
			}
			else if(current.data>key){
				return(bstsearch(current.left,key));
			}
			else{
				return(bstsearch(current.right,key));
			}
		}
		return false;
	}
	public static void insert(Node key){
		broot = bstinsert(key, broot);
	}
	public static Node bstinsert(Node key, Node root){
		if(root==null){
			root=key;
		}
		else{
			if(key.data<=root.data){
				root.left=bstinsert(key, root.left);
			}
			else{
				root.right=bstinsert(key, root.right);
			}
		}
		return root;
	}

	public static void delete(int key){
		broot = bstdelete(key, broot);
	}
	public static Node bstdelete(int key, Node root){
		if(root==null){
			return root; //base case if no elements
		}
		if(key<root.data){
			root.left = bstdelete(key, root.left);
		}
		else if(key>root.data){
			root.right = bstdelete(key, root.right);
		}
		//if nothing matches so far, i.e. equivalent match found, we go to the following conditions.
		else{
			//here, if either of the two is missing the other will be returned, if both are missing then will pass back the present one 
			if(root.left == null){
				return root.right;
			}
			else if(root.right == null){
				return root.left;
			}
			Node w = root.right;
			int min = w.data;
			while(w.left!=null){
				min = w.left.data;
				w=w.left;
			}
			root.data = min;
			root.right = bstdelete(root.data,root.right);
		}
		return root;
	}
	public static long sum = 0;
	public static void summer(Node root){
		if(root!=null){
			sum=sum+root.data;
			summer(root.left);
			summer(root.right);
		}
	}


	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node[] arr = new Node[n];
		for(int i=0;i<n;i++){
			int temp = in.nextInt();
			arr[i] = new Node(temp,null,null);
		}
		for(int i=1;i<n;i++){
			bstinsert(arr[i],arr[0]);
		}
		//indisplay(arr[0]);
		insum(arr[0]);

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