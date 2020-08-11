import java.util.*;

public class l9p1{

	public static String[][] arr = new String[26][2];
	public static int count = 0;
	public static void printer(HNode root, String s){
		if(root.left==null && root.right==null && Character.isLetter(root.c)){
			System.out.println(root.c+":"+s);
			arr[count][0]=String.valueOf(root.c);
			arr[count][1]=s;
			count=count+1;
			return;
		}
		printer(root.left, s+"1");
		printer(root.right, s+"0");
	}
	public static void decoder(String s, String[][] code){
		String ans = "";
		String cur = "";
		for(int i=0;i<s.length();i++){
			cur = cur + String.valueOf(s.charAt(i));
			for(int j=0;j<count;j++){
				if(cur.equals(code[j][1])){
					ans=ans+code[j][0];
					cur = "";
					break;
				}
			}
		}
		System.out.println(ans);
	}

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int l=0;l<t;l++){
			int n = in.nextInt();
			char[] carr = new char[n];
			int[] cfreq = new int[n];
			for(int i=0;i<n;i++){
				carr[i] = in.next().charAt(0);
				cfreq[i] = in.nextInt()+1;
			}
			String cod = in.next();
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
			//System.out.println(q.peek().c);
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
			decoder(cod,arr);
			arr = new String[26][2];
			count = 0;
		}

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
    	if(y.data == x.data)
    		return y.c - x.c;
    	else
        	return y.data - x.data; 
    } 
}
