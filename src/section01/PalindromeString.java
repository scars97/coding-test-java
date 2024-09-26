package section01;

import java.util.Scanner;

/**
 * 회문 문자열 - 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열
 */
public class PalindromeString {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String upperCaseOfStr = str.toUpperCase();

        String result = "YES";
        int endIndex = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (upperCaseOfStr.charAt(i) != upperCaseOfStr.charAt(endIndex - i)) {
                result = "NO";
                break;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
