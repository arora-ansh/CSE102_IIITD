import java.util.*;
import java.io.*;

public class l7p1{

	public static Node broot = null;

	public static void indisplay(Node root){
		if(root!=null){
			indisplay(root.left);
			System.out.print(root.data+" ");
			indisplay(root.right);
		}
	}
	public static int fcount = 1;
	public static int fkey = 0;
	public static void finder(Node root, int k){
		if(root!=null){
			finder(root.left,k);
			if(fcount==k){
				System.out.println(root.data);
				fkey = 1;
			}
			fcount=fcount+1;
			finder(root.right,k);
		}
	}
	public static int incount = 0;
	public static void counter(Node root, long x){
		if(root!=null){
			counter(root.left,x);
			if(root.data<x){
				incount = incount + 1;
			}
			counter(root.right,x);
		}
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
				root.lcount=root.lcount+1;
				root.left=bstinsert(key, root.left);
			}
			else if(key.data>root.data){
				root.rcount=root.rcount+1;
				root.right=bstinsert(key, root.right);
			}
		}
		return root;
	}

	public static void delete(long key){
		broot = bstdelete(key, broot);
	}
	public static Node bstdelete(long key, Node root){
		if(root==null){
			return root; //base case if no elements
		}
		if(key<root.data){
			root.lcount = root.lcount-1;
			root.left = bstdelete(key, root.left);
		}
		else if(key>root.data){
			root.rcount = root.rcount-1;
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
			long min = w.data;
			while(w.left!=null){
				min = w.left.data;
				w=w.left;
			}
			root.data = min;
			root.right = bstdelete(root.data,root.right);
		}
		return root;
	}


	public static void main(String[] args)throws IOException{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node[] arr = new Node[n];
		int count = 0;
		for(int i=0;i<n+1;i++){
			String temp = in.nextLine();
			String[] temparr = temp.split(" ");
			if(temparr[0].equals("INSERT")){
				long x = Long.parseLong(temparr[1]);
				arr[count]= new Node(x,null,null);
				if(count==0){
					broot = arr[count];
				}
				insert(arr[count]);
				count = count+1;
			}
			else if(temparr[0].equals("DELETE")){
				long x = Long.parseLong(temparr[1]);
				delete(x);
			}
			else if(temparr[0].equals("FIND")){
				int y = Integer.parseInt(temparr[1]);
				finder(broot,y);
				fcount=1;
				if (fkey==0){
					System.out.println(-1);
				}
				fkey=0;
			}
			else if(temparr[0].equals("COUNT")){
				long x = Long.parseLong(temparr[1]);
				counter(broot,x);
				System.out.println(incount);
				incount=0;
			}
		}
	}
}

class Node{
	long data;
	int lcount;
	int rcount;
	Node left;
	Node right;

	public Node(long x,Node a,Node b){
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