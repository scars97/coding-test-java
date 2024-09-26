package section01;

import java.util.Scanner;

/**
 * 회문 문자열 - 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열
 */
public class PalindromeString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String reverseStr = new StringBuilder(str).reverse().toString();

        String upperCaseOfStr = str.toUpperCase();
        String upperCaseOfReverseStr = reverseStr.toUpperCase();

        if (upperCaseOfStr.equals(upperCaseOfReverseStr)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
