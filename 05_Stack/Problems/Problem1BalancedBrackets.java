/**
 * @author Miriam Lee
 * @date Jan 17, 2017
 * @link https://www.hackerrank.com/challenges/ctci-balanced-brackets
 * @status Accepted
 */
package Problems;

import java.util.Scanner;


public class Problem1BalancedBrackets {
    static String o = "({[";//open
    static String c = ")}]";//close

    public static boolean isBalanced(String e) {
        MyStack s = new MyStack();

        for (int i = 0; i < e.length(); i++) {
            if (o.indexOf(e.charAt(i)) != -1)
                s.push(e.charAt(i));
            else {
                try {
                    if (!s.isEmpty() && o.indexOf((char) s.peek()) == c.indexOf(e.charAt(i)))
                        s.pop();

                    else return false;
                } catch (StackUnderflowException e1) {
                    e1.printStackTrace();
                }
            }

        }
        return s.isEmpty();//contains no unmatched brackets
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
