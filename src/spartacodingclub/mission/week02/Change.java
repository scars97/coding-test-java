package spartacodingclub.mission.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Change {

    static final int[] COINS = {5, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        if (n != 1) {
            for (int coin : COINS) {
                if (n >= coin) {
                    if (n % coin == 1) {
                        count = -1;
                        break;
                    }

                    if (n % coin == 3) {
                        count = (n / coin) - 1;
                        n -= (coin * count);
                    } else {
                        count += (n / coin);
                        n %= coin;
                    }
                }
            }
        } else {
            count = -1;
        }


        System.out.println(count);
        br.close();
    }
}
