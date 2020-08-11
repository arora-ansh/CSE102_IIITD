import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	String mystr;

	public Solution(String string){
		mystr=string;
	}

	public boolean checkPal(String mystr){
		int i = 0, j = mystr.length() - 1;
		String m = mystr.toLowerCase();
		while(i<j) {
			if(m.charAt(i) != m.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public int sqcalc(String mystr){
		int n = mystr.length();
		return(n*n);
	}

	public StringBuffer caesar(String mystr){
		int n = mystr.length();
		StringBuffer x = new StringBuffer();
		for(int i=0; i<n ; i++){
			if (Character.isUpperCase(mystr.charAt(i))) 
            { 
                char ch = (char)(((int)mystr.charAt(i) + 3 - 65) % 26 + 65); 
                x.append(ch); 
            } 
            else
            { 
                char ch = (char)(((int)mystr.charAt(i) + 3 - 97) % 26 + 97); 
                x.append(ch); 
            }
		}
		return x;
	}


    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        String x = str.nextLine();
        Solution lol = new Solution(x);
        System.out.println((lol.checkPal(x))?"Palindrome":"Not a palindrome");
        System.out.println(lol.sqcalc(x));
        System.out.println(lol.caesar(x));
    }
}