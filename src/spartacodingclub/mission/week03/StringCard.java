package spartacodingclub.mission.week03;

import java.util.Scanner;

public class StringCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            String[] alphabets = new String[N];
            for (int j = 0; j < N; j++) {
                alphabets[j] = sc.next();
            }

            String first = alphabets[0];
            String result = first;
            for (int j = 1; j < alphabets.length; j++) {
                String tmp = alphabets[j];

                // 사전 순으로 첫 번째 알파벳보다 tmp가 앞에 있으면 왼쪽으로 이동
                if (first.hashCode() > tmp.hashCode()) {
                    result = tmp.concat(result);
                } else {
                    result = result.concat(tmp);
                }
            }

            System.out.println(result);
        }

        sc.close();
    }
}
