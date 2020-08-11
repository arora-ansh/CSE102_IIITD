import java.util.*;

public class bintree{

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
			if(key.data<root.data){
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


	public static void main(String[] args){
		Node a = new Node(4,null,null);
		Node b = new Node(2,null,null);
		Node c = new Node(6,null,null);
		Node d = new Node(1,null,null);
		Node e = new Node(3,null,null);
		Node f = new Node(5,null,null);
		Node g = new Node(7,null,null);
		a.setLeft(b);
		a.setRight(c);
		b.setLeft(d);
		b.setRight(e);
		c.setLeft(f);
		c.setRight(g);
		broot = a;
		if(bstsearch(a,5)) System.out.println("true"); else System.out.println("false");
		if(bstsearch(a,8)) System.out.println("true"); else System.out.println("false");
		Node h = new Node(8,null,null);
		indisplay(a);
		System.out.println();
		insert(h );
		indisplay(a);
		System.out.println();
		if(bstsearch(a,8)) System.out.println("true"); else System.out.println("false");
		System.out.println(broot.data);
		bstdelete(5,a);
		indisplay(a);
		System.out.println();
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