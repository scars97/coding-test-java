package lecture.array;

import java.util.Scanner;

/**
 * 봉우리
 */
public class Peaks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                grid[row][col] = sc.nextInt();
            }
        }

        int peakCount = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid.length; col++) {
                int origin = grid[row][col];

                // 상 : row-1 col
                if (row - 1 >= 0 && origin <= grid[row - 1][col]) continue;
                // 하 : row+1 col
                if (row + 1 < grid.length && origin <= grid[row + 1][col]) continue;
                // 좌 : row col-1
                if (col - 1 >= 0 && origin <= grid[row][col - 1]) continue;
                // 우 : row co1+1
                if (col + 1 < grid.length && origin <= grid[row][col + 1]) continue;

                peakCount++;
            }
        }

        System.out.println(peakCount);
        sc.close();
    }
}
