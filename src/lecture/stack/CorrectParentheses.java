package lecture.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 올바른 괄호
 */
public class CorrectParentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        char open = '(';
        char close = ')';

        String result = "YES";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if (tmp == open) {
                stack.push(str.charAt(i));
            }
            if (tmp == close) {
                if (stack.isEmpty()) {
                    result = "NO";
                    break;
                }

                if (stack.peek() == open) {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            result = "NO";
        }

        System.out.println(result);
        sc.close();
    }

}
