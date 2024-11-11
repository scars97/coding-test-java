package spartacodingclub.mission.week03;

import java.util.*;

public class StringCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            String[] alphabets = new String[N];
            for (int j = 0; j < N; j++) {
                alphabets[j] = sc.next();
            }

            String result = alphabets[0];
            for (int j = 1; j < alphabets.length; j++) {
                char tmp = alphabets[j].charAt(0);

                // 반복문을 돌때마다 생성되는 결과 문자열의 첫 번째 문자와 비교
                if (result.charAt(0) >= tmp) { // first
                    result = alphabets[j].concat(result);
                } else { // last
                    result = result.concat(alphabets[j]);
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
