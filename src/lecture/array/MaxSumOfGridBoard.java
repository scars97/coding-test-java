package lecture.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 격자판 최대합
 */
public class MaxSumOfGridBoard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] gridBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                gridBoard[i][j] = sc.nextInt();
            }
        }

        List<Integer> sumList = new ArrayList<>();
        calculateOfRowAndCol(gridBoard, sumList);
        calculateOfDiagonal(gridBoard, sumList);

        int result = Integer.MIN_VALUE;
        for (int i : sumList) {
            Math.max(result, i);
        }

        System.out.println(result);

        sc.close();
    }

    private static void calculateOfDiagonal(int[][] gridBoard, List<Integer> sumList) {
        int length = gridBoard.length;

        int diagonalSum1 = 0;
        int diagonalSum2 = 0;
        for (int i = 0; i < length; i++) {
            diagonalSum1 += gridBoard[i][i];
            diagonalSum2 += gridBoard[i][(length-1)-i];
        }
        sumList.add(diagonalSum1);
        sumList.add(diagonalSum2);
    }

    private static void calculateOfRowAndCol(int[][] gridBoard, List<Integer> sumList) {
        for (int row = 0; row < gridBoard.length; row++) {
            int rowSum = 0;
            int colSum = 0;

            for (int col = 0; col < gridBoard.length; col++) {
                rowSum += gridBoard[row][col];
                colSum += gridBoard[col][row];
            }
            sumList.add(rowSum);
            sumList.add(colSum);
        }
    }

}
