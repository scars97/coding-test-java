package spartacodingclub.mission.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StackingDice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] dices = new int[N][6];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int tmp = 0;
        for (int i = 0; i < 6; i++) {
            if (dices[0][i] == 1) {
                if (i == 0 || i == 5) {
                    tmp = i == 0 ? dices[0][5] : dices[0][0];
                } else if (i <= 2) {
                    tmp = dices[0][i + 2];
                } else {
                    tmp = dices[0][i - 2];
                }
            }
        }

        for (int[] dice : dices) {
            int underIdx = 0;
            for (int i = 0; i < dice.length; i++) {
                if (dice[i] == tmp) {
                    underIdx = i;
                    break;
                }
            }

            if (underIdx == 0 || underIdx == 5) {
                tmp = underIdx == 0 ? dice[5] : dice[0];
                dice[5] = 0;
                dice[0] = 0;
            } else if (underIdx <= 2) {
                tmp = dice[underIdx + 2];
                dice[underIdx + 2] = 0;
                dice[underIdx] = 0;
            } else {
                tmp = dice[underIdx - 2];
                dice[underIdx] = 0;
                dice[underIdx - 2] = 0;
            }
        }

        int result = 0;
        for (int[] dice : dices) {
            int max = 0;
            for (int number : dice) {
                max = Math.max(number, max);
            }
            result += max;
        }

        System.out.println(result);
        br.close();
    }
}
