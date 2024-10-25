package lecture.section02;

import java.util.Scanner;

/**
 * 멘토링
 */
public class Mentoring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int resultCount = 0;
        int rootStd = 1;
        while (rootStd != n + 1) {
            for (int std = 1; std <= n; std++) {
                if (rootStd != std) {
                    int winnerCount = 0;
                    for (int test = 1; test <= m; test++) {
                        int rootScore = 0;
                        int otherScore = 0;
                        for (int i = 1; i <= n; i++) {
                            if (arr[test][i] == rootStd) {
                                rootScore = i;
                            }
                            if (arr[test][i] == std) {
                                otherScore = i;
                            }
                        }
                        if (rootScore > otherScore) {
                            break;
                        }
                        winnerCount++;
                    }
                    if (winnerCount == m) {
                        resultCount++;
                    }
                }
            }
            rootStd++;
        }

        System.out.println(resultCount);
        sc.close();
    }
}
