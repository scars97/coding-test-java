package spartacodingclub.mission.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RockGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // DP 배열: dp[i] = true면 SK 승리, false면 CY 승리
        boolean[] dp = new boolean[N + 1];

        // 초기 상태 설정
        dp[1] = true; // 1개일 때 SK 승리
        if (N > 1) dp[2] = false; // 2개일 때 CY 승리
        if (N > 2) dp[3] = true; // 3개일 때 SK 승리

        // 동적 계획법 계산
        for (int i = 4; i <= N; i++) {
            dp[i] = !dp[i - 1] || !dp[i - 3];
        }

        // 결과 출력
        System.out.println(dp[N] ? "SK" : "CY");
    }
}
