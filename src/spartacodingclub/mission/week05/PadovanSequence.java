package spartacodingclub.mission.week05;

import java.io.*;

public class PadovanSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            long result = padovan(N);

            sb.append(result).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static long padovan(int N) {
        if (N < 4) {
            return 1;
        }

        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i <= N; i++) {
            arr[i] = arr[i-2] + arr[i-3];
        }
        return arr[N];
    }
}
