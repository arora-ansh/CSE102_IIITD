import java.util.*;

public class huffman{

	public static void printer(HNode root, String s){
		if(root.left==null && root.right==null && Character.isLetter(root.c)){
			System.out.println(root.c+":"+s);
			return;
		}
		printer(root.left, s+"0");
		printer(root.right, s+"1");
	}

	public static void main(String[] args){
		int n = 6;
		char[] carr = {'a','b','c','d','e','f'};
		int[] cfreq = {5,9,12,13,16,45};
		PriorityQueue<HNode> q = new PriorityQueue<HNode>(n, new MyComparator());

		for(int i=0;i<n;i++){
			HNode temp = new HNode();
			temp.c = carr[i];
			temp.data = cfreq[i];
			temp.left = null;
			temp.right = null;
			q.add(temp);
		}

		HNode root = null;
		int size = n;

		while(size > 1){
			HNode x = q.peek();
			q.poll();
			HNode y = q.peek();
			q.poll();
			HNode temp = new HNode();
			temp.data = x.data + y.data;
			temp.c = '?';
			temp.left = x;
			temp.right = y;
			root = temp;
			q.add(root);
			size = size-1;
		}

		printer(root,"");
	}
}

class HNode{

	char c;
	int data;
	HNode left;
	HNode right;
}

class MyComparator implements Comparator<HNode> { 
    public int compare(HNode x, HNode y) 
    { 
  
        return x.data - y.data; 
    } 
}
