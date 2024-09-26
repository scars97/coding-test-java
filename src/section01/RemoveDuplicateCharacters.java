package section01;

import java.util.Scanner;

/**
 * 중복 문자 제거
 */
public class RemoveDuplicateCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            // str.indexOf(str.charAt(i)) 해당 문자열에 대한 index 를 출력하기 때문에
            // i 값과 다르다면 중복 문자
            if (i == str.indexOf(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }

        System.out.println(sb);
    }
}
