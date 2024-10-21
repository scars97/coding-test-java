package lecture.section01;

import java.util.Scanner;

/**
 * 가장 짧은 문자거리
 *
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 *
 * in : teachermode e
 * out : 1 0 1 2 1 0 1 2 2 1 0
 */
public class ShortestCharacterDistance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char t = sc.next().charAt(0);

        int[] result = new int[s.length()];

        int rNum = 1000;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t) {
                rNum++;
            } else {
                rNum = 0;
            }

            result[i] = rNum;
        }

        int lNum = 1000;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != t) {
                lNum++;
            } else {
                lNum = 0;
            }

            if (result[i] > lNum) {
                result[i] = lNum;
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
