package section01;

import java.util.Scanner;

/**
 * 유효한 펠린드롬(회문)
 *
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 * 알파벳 이외의 문자들의 무시합니다.
 */
public class ValidPalindromes {

    static final String REGEX = "[^A-Z]";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        // 문제에서는 알바벳 이외의 문자들은 무시한다 말하고 있다.
        // fail-1 : 특수문자를 기준으로 split
        // fail-2 : 만약 숫자가 입력될 시 숫자까지 포함해서 String 배열에 저장된다.
        String[] split = str.split(REGEX);

        // 반복문을 돌리지 않아도 된다.
        String result = "YES";
        for (int i = 0; i < split.length / 2; i++) {
            boolean palindrome = isPalindrome(split[i], split[split.length - i - 1]);
            if (!palindrome) {
                result = "NO";
                break;
            }
        }

        System.out.println(result);
        sc.close();
    }

    static boolean isPalindrome(String origin, String reverse) {
        String reverseOfOrigin = new StringBuilder(origin).reverse().toString();
        return reverseOfOrigin.equalsIgnoreCase(reverse);
    }
}
