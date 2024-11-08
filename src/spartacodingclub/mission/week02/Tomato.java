package spartacodingclub.mission.week02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {

    static int m, n, h;
    static int[][][] tomatoBoxes; // 3차원 배열로 변경
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1}; // 위, 아래 이동을 위한 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        tomatoBoxes = new int[h][n][m];
        Queue<Spot> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    tomatoBoxes[i][j][k] = sc.nextInt();
                    if (tomatoBoxes[i][j][k] == 1) {
                        queue.add(new Spot(i, j, k));
                    }
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

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoBoxes[i][j][k] == 0) {
                        return -1;
                    }
                    day = Math.max(day, tomatoBoxes[i][j][k]);
                }
            }
        }
        return day - 1;
    }

    static void bfs(Queue<Spot> queue) {
        while (!queue.isEmpty()) {
            Spot spot = queue.remove();
            int z = spot.z, y = spot.y, x = spot.x;

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nz >= 0 && nz < h && ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (tomatoBoxes[nz][ny][nx] == 0) {
                        tomatoBoxes[nz][ny][nx] = tomatoBoxes[z][y][x] + 1;
                        queue.add(new Spot(nz, ny, nx));
                    }
                }
            }
        }
    }

    static class Spot {
        public int z, y, x;

        public Spot(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
}
