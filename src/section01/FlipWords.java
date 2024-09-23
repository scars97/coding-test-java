package section01;

import java.util.Scanner;

/**
 * 단어 뒤집기
 */
public class FlipWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = sc.next();
        }

        for (String s : strArray) {
            StringBuilder sb = new StringBuilder();
            for (int i = s.length() - 1; i >= 0 ; i--) {
                sb.append(s.charAt(i));
            }

            System.out.println(sb);
        }
        
        // 강의 코드
        /*for (String s : strArray) {
            String tmp = new StringBuilder(s).reverse().toString();
            System.out.println(tmp);
        }*/

        sc.close();
    }
}
