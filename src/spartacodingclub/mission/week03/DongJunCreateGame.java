package spartacodingclub.mission.week03;

import java.io.*;

public class DongJunCreateGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i = scores.length - 1; i > 0; i--) {
            int last = scores[i];
            int next = scores[i - 1];

            if (last <= next) {
                scores[i - 1] = last - 1;
                result += (next - scores[i - 1]);
            }
        }

        System.out.println(result);
        br.close();
    }
}
