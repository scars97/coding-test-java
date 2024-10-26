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

            if (i == 0 && tmp == close) {
                result = "NO";
                break;
            }

            if (tmp == close) {
                if (stack.peek() == open) {
                    stack.pop();
                }
            }

            if (tmp == open) {
                stack.push(str.charAt(i));
            }
        }

        if (!stack.isEmpty()) {
            result = "NO";
        }

        System.out.println(result);

        sc.close();
    }

}
