import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class sol{

    public static void op(String str){
        int l = str.indexOf(' ');
        int len =str.length();
        String numx = str.substring(0,l);
        int num1 = Integer.valueOf(numx);
        char operand = str.charAt(l+1);
        String numy = str.substring(l+3,len);
        int num2 = Integer.valueOf(numy);
        switch(operand){
            case '+':
                System.out.println(num1+num2);
                break;
            case '-':
                System.out.println(num1-num2);
                break;
            case '*':
                System.out.println(num1*num2);
                break;
            case '/':
                System.out.println((float) num1/num2);
                break;
            default:
                System.out.println("Invalid");
        }

    }

    public static void main(String[] args){
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        num.nextLine();
        String[] a = new String[1000];
        for(int i=0;i<n;i++){
            a[i] = num.nextLine();
        }
        for(int i=0;i<n;i++){
            op(a[i]);
        }

    }
}