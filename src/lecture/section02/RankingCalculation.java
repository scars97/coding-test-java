package lecture.section02;

import java.util.Scanner;

/**
 * 등수 구하기
 */
public class RankingCalculation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        for (int i = 0; i < scores.length; i++) {
            int selectedScore = scores[i];

            int rank = n;
            for (int j = 0; j < scores.length; j++) {
                if (j != i) {
                    if (selectedScore >= scores[j]) {
                        rank--;
                    }
                }
            }
            System.out.printf("%d ", rank);
        }
        sc.close();
    }

}
