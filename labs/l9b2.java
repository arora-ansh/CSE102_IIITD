import java.util.*;

public class l9b2{

	public static String[][] arr = new String[26][2];
	public static int count = 0;
	public static void printer(HNode root, String s){
		if(root.left==null && root.right==null && Character.isLetter(root.c)){
			//System.out.println(root.c+":"+s);
			arr[count][0]=String.valueOf(root.c);
			arr[count][1]=s;
			count=count+1;
			return;
		}
		printer(root.left, s+"0");
		printer(root.right, s+"1");
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int n = 26;
		char[] carr = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		int[] cfreq = new int[26];
		int l = 0;
		while(l<s.length()){
			for(int j=0;j<26;j++){
				if(carr[j]==s.charAt(l)){
					cfreq[j]+=1;
				}
			}
			l=l+1;
		}

		PriorityQueue<HNode> q = new PriorityQueue<HNode>(n, new MyComparator());

		for(int i=0;i<n;i++){
			HNode temp = new HNode();
			temp.c = carr[i];
			temp.data = cfreq[i];
			temp.left = null;
			temp.right = null;
			q.add(temp);
			//System.out.println(temp.c+" "+temp.data);
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
		for(int i=0;i<26;i++){
			for(int j=0;j<26;j++){
				if(arr[j][0].charAt(0)==carr[i]){
					System.out.println(arr[j][1]);
				}
			}
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
  
        return x.data - y.data; 
    } 
}
