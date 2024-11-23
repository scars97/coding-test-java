package spartacodingclub.mission.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 백준 11722번 - 가장 긴 감소하는 부분 수열
*/
public class DecreasePartialSequences {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] sequences = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequences[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (sequences[j] > sequences[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
        br.close();
    }
}
