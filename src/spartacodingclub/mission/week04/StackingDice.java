package spartacodingclub.mission.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StackingDice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dices = new int[N][6]; // 주사위 데이터를 저장

        // 주사위 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dices[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 반대 면을 구하기 위한 배열
        int[] opposite = {5, 3, 4, 1, 2, 0};

        int maxSum = 0;

        // 첫 번째 주사위의 아랫면 선택
        for (int i = 0; i < 6; i++) {
            int sum = 0;
            int bottom = dices[0][i]; // 첫 주사위의 아랫면
            int top = dices[0][opposite[i]]; // 첫 주사위의 윗면

            // 첫 번째 주사위의 옆면 최댓값
            sum += getMaxSide(bottom, top);

            // 이후 주사위 처리
            for (int j = 1; j < N; j++) {
                int bottomIdx = findIndex(dices[j], top); // 이전 윗면이 현재 주사위의 아랫면
                bottom = dices[j][bottomIdx];
                top = dices[j][opposite[bottomIdx]];
                sum += getMaxSide(bottom, top);
            }

            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }

    // 아랫면과 윗면을 제외한 옆면 중 최댓값 구하기
    private static int getMaxSide(int bottom, int top) {
        int max = 0;
        for (int i = 1; i <= 6; i++) {
            if (i != bottom && i != top) {
                max = Math.max(max, i);
            }
        }
        return max;
    }

    // 배열에서 값을 찾고 인덱스 반환
    private static int findIndex(int[] dice, int value) {
        for (int i = 0; i < dice.length; i++) {
            if (dice[i] == value) {
                return i;
            }
        }
        return -1; // 없는 경우는 발생하지 않음
    }
}
