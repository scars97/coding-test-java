package spartacodingclub.mission.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BamYangGang {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 8;
        int k = 1;
        while (true) {
            double powerOfTwo = Math.pow(2, k);
            if (N == powerOfTwo) {
                count += k + 2;
                break;
            } else if (N < powerOfTwo) {
                count += k + 1;
                break;
            }
            k++;
        }

        System.out.println(count);
        br.close();
    }
}
