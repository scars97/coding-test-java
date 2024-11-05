package spartacodingclub.mission.week02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MovementOfKnight {

    static final int MOVE_COUNT = 8;
    static final int[] ROW_MOVE = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] COL_MOVE = {1, 2, 2, 1, -1, -2, -2 ,-1};
    static int n;
    static int[][] chessBoard;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            int startRow = sc.nextInt();
            int startCol = sc.nextInt();
            int endRow = sc.nextInt();
            int endCol = sc.nextInt();

            chessBoard = new int[n][n];
            visited = new boolean[n][n];

            bfs(startRow, startCol);

            sb.append(chessBoard[endRow][endCol]).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }

    static void bfs(int startRow, int startCol) {
        Queue<Spot> queues = new LinkedList<>();
        queues.add(new Spot(startRow, startCol));
        visited[startRow][startCol] = true;

        while (!queues.isEmpty()) {
            Spot spot = queues.remove();
            for (int i = 0; i < MOVE_COUNT; i++) {
                int row = spot.row;
                int col = spot.col;
                int newRow = row + ROW_MOVE[i];
                int newCol = col + COL_MOVE[i];

                if ((newRow >= 0 && newRow < n) && (newCol >= 0 && newCol < n)) {
                    if (!visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        chessBoard[newRow][newCol] = chessBoard[row][col] + 1;
                        queues.add(new Spot(newRow, newCol));
                    }
                }
            }
        }
    }

    static class Spot {
        public int row;
        public int col;

        public Spot(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }
}
