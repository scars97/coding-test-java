package spartacodingclub.mission.week03;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Censor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (N < K) {
            System.out.println(0);
            br.close();
            return;
        }

        // 센서 좌표 오름차순 정렬
        int[] censors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < censors.length; i++) {
            censors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(censors);

        // 센서 거리 차이 - 오름차순 정렬
        int[] diff = new int[N - 1];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = censors[i + 1] - censors[i];
        }
        Arrays.sort(diff);

        int result = 0;
        for (int i = 0; i < diff.length - (K - 1); i++) {
            result += diff[i];
        }

        System.out.println(result);
        br.close();
    }
}
