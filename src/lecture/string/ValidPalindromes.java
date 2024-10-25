package lecture.string;

import java.util.Scanner;

/**
 * 유효한 펠린드롬(회문)
 *
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 * 단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 * 알파벳 이외의 문자들의 무시합니다.
 */
public class ValidPalindromes {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 한 단어가 아닌 한 줄을 읽어야 함.
        String str = sc.nextLine();

        String tmp = str.toUpperCase().replaceAll("[^A-Z]", "");

        String reverseTmp = new StringBuilder(tmp).reverse().toString();
        String result = tmp.equals(reverseTmp) ? "YES" : "NO";

        System.out.println(result);
        sc.close();
    }
}
