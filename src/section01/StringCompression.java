package section01;

import java.util.Scanner;

/**
 * 문자열 압축
 *
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 * 단 반복횟수가 1인 경우 생략합니다.
 *
 * in : KKHSSSSSSSE
 * out : K2HS7E
 *
 * in-2 : KSTTTSEEKFKKKDJJGG
 * out-2 : KST3SE2KFK3DJ2G2
 */
public class StringCompression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 0; i < str.length(); i++) {

            char c = str.charAt(i);
            if (i != str.length() - 1) {
                if (c == str.charAt(i + 1)) {
                    count++;
                } else {
                    sb.append(c);

                    if (count > 1) {
                        sb.append(count);
                    }

                    count = 1;
                }
            } else {
                sb.append(c);
                if (c == str.charAt(i - 1)) {
                    sb.append(count);
                }
            }
        }

        System.out.println(sb);
        sc.close();
    }
}
