package lecture.array;

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
        for (int rootStd = 1; rootStd <= n; rootStd++) {
            for (int otherStd = 1; otherStd <= n; otherStd++) {
                int winnerCount = 0;

                for (int test = 1; test <= m; test++) {
                    int rootTh = 0;
                    int otherTh = 0;
                    for (int th = 1; th <= n; th++) {
                        if (arr[test][th] == rootStd) rootTh = th;
                        if (arr[test][th] == otherStd) otherTh = th;
                    }
                    if (rootTh < otherTh) winnerCount++;
                }
                if (winnerCount == m) resultCount++;
            }
        }

        System.out.println(resultCount);
        sc.close();
    }
}
