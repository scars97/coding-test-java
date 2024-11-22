package spartacodingclub.mission.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RockGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int bringStones = N >= 3 ? 3 : 1;
        int playCount = 0;
        while (N != 0) {
            N -= bringStones;

            bringStones = N >= 3 ? 3 : 1;

            playCount++;
        }

        String winner = playCount % 2 != 0 ? "SK" : "CY";
        System.out.println(winner);
        br.close();
    }
}
