package spartacodingclub.mission.week02;

import java.io.*;

public class MoreCatAreBetter {

    static long catCount = 0;
    static int GENERATE_COUNT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        int action = 0;

        while (catCount < n) {
            long remainingCount = n - catCount;

            long copyCount = Math.min(catCount, remainingCount);
            long copy = catCount + copyCount;
            long generate = catCount + GENERATE_COUNT;

            long max = generate >= copy ? GENERATE_COUNT : copyCount;

            catCount += max;
            action++;
        }

        System.out.println(action);
        br.close();
    }
}
