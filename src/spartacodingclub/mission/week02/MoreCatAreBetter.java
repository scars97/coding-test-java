package spartacodingclub.mission.week02;

import java.io.*;

public class MoreCatAreBetter {

    static long catCount = 0;
    static int GENERATE_COUNT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        int action = 0;

        while (catCount < n) {
            long remainingCount = n - catCount;

            long generate = catCount + GENERATE_COUNT;
            long copyCount = copy(remainingCount);
            long copy = catCount + copyCount;

            long max = generate >= copy ? GENERATE_COUNT : copyCount;

            catCount += max;
            action++;
        }

        bw.write(String.valueOf(action));
        bw.flush();
        br.close();
        bw.close();
    }

    static long copy(long remainingCount) {
        long result = 0;
        for (long i = 0; i <= catCount; i++) {
            if (i <= remainingCount) {
                result = Math.max(result, i);
            }
        }
        return result;
    }
}
