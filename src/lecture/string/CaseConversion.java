package lecture.string;

import java.util.Scanner;

/**
 * 대소문자 변환
 */
public class CaseConversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }

        System.out.println(sb);

        sc.close();
    }
}
