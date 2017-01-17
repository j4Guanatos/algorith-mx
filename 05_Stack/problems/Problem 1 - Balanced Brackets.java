/**
 * @author Miriam Lee
 * @date Jan 17, 2017
 * @link https://www.hackerrank.com/challenges/ctci-balanced-brackets
 * @status Accepted
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static String o = "({[";//open
    static String c = ")}]";//close
    
    public static boolean isBalanced(String e) {
        Stack s = new Stack();
    
        for (int i=0; i<e.length(); i++){
            if (o.indexOf(e.charAt(i)) != -1)
                s.push(e.charAt(i));
            else{
                if(!s.isEmpty() && o.indexOf((char)s.peek()) == c.indexOf((char)e.charAt(i)))
                    s.pop();
                else return false;
            }
                
        }
        return s.empty();//contains no unmatched brackets
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
