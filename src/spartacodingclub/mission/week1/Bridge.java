package spartacodingclub.mission.week1;

import java.util.Scanner;

public class Bridge {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            long n = sc.nextLong();

            long left = 0;
            long right = Integer.MAX_VALUE;
            long result = 0;

            while (left <= right) {
                long mid = (left + right) / 2;
                long sum = (mid * (mid + 1)) / 2;

                if (sum <= n) {
                    result = Math.max(mid, result);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
