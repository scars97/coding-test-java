package spartacodingclub.mission.week02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {

    static int m;
    static int n;
    static int h;
    static int[][] tomatoBoxes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        tomatoBoxes = new int[n * h][m];
        Queue<Spot> queue = new LinkedList<>();
        for (int row = 0; row < n * h; row++) {
            for (int col = 0; col < m; col++) {
                tomatoBoxes[row][col] = sc.nextInt();

                if (tomatoBoxes[row][col] == 1) {
                    queue.add(new Spot(row, col));
                }
            }
        }

        bfs(queue);

        int result = checkDay();

        System.out.println(result);
        sc.close();
    }

    private static int checkDay() {
        int day = 0;

        for (int row = 0; row < n * h; row++) {
            for (int col = 0; col < m; col++) {
                if (tomatoBoxes[row][col] == 0) {
                    return -1;
                }

                day = Math.max(tomatoBoxes[row][col], day);
            }
        }

        return day - 1;
    }

    static void bfs(Queue<Spot> queue) {

        while (!queue.isEmpty()) {
            Spot spot = queue.remove();
            int row = spot.row;
            int col = spot.col;

            if (tomatoBoxes[row][col] >= 1) {
                int nextDay = tomatoBoxes[row][col] + 1;

                if (row - 1 >= 0) {
                    if (tomatoBoxes[row - 1][col] == 0) {
                        tomatoBoxes[row - 1][col] = nextDay;
                        queue.add(new Spot(row - 1, col));
                    }
                }

                if (row + 1 < n * h) {
                    if (tomatoBoxes[row + 1][col] == 0) {
                        tomatoBoxes[row + 1][col] = nextDay;
                        queue.add(new Spot(row + 1, col));
                    }
                }

                if (col - 1 >= 0) {
                    if (tomatoBoxes[row][col - 1] == 0) {
                        tomatoBoxes[row][col - 1] = nextDay;
                        queue.add(new Spot(row, col - 1));
                    }
                }

                if (col + 1 < m) {
                    if (tomatoBoxes[row][col + 1] == 0) {
                        tomatoBoxes[row][col + 1] = nextDay;
                        queue.add(new Spot(row, col + 1));
                    }
                }

                if (row + n < n * h) {
                    if (tomatoBoxes[row + n][col] == 0) {
                        tomatoBoxes[row + n][col] = nextDay;
                        queue.add(new Spot(row + n, col));
                    }
                }

                if (row - n >= 0) {
                    if (tomatoBoxes[row - n][col] == 0) {
                        tomatoBoxes[row - n][col] = nextDay;
                        queue.add(new Spot(row - n, col));
                    }
                }
            }

        }

    }

    static class Spot {
        public int row, col;

        public Spot(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
