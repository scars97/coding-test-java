package lecture.section02;

import java.util.Scanner;

/**
 * 점수 계산
 */
public class ScoreCalculation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scoring = new int[n];
        for (int i = 0; i < n; i++) {
            scoring[i] = sc.nextInt();
        }

        int totalScore = getTotalScore(scoring);

        System.out.println(totalScore);
        sc.close();
    }

    private static int getTotalScore(int[] scoring) {
        int totalScore = 0;
        int count = 0;
        for (int i = 0; i < scoring.length; i++) {
            if (scoring[i] == 1) {
                count++;
                totalScore += count;
            } else {
                count = 0;
            }
        }
        return totalScore;
    }


}
