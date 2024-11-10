package spartacodingclub.mission.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChange {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;

        if (n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }

        while (n > 0) {
            if (n % 5 == 0) {
                count += n / 5;
                break;
            }

            n -= 2;
            count++;
        }

        System.out.println(count);
        br.close();
    }
}
