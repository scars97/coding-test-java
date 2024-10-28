package spartacodingclub.mission.week1;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = sc.nextDouble();
        double y = sc.nextDouble();
        double z = (y / x) * 100.0;

        int resultRate = (int) z;
        int count = 0;
        if (x != y) {
            for (double i = y + 1; i <= x + 1; i++) {
                x++;

                double tmp = (i / x) * 100.0;
                int rate = (int) tmp;

                count++;

                if (resultRate != rate) {
                    break;
                }
            }
        } else {
            count = -1;
        }

        System.out.println(count);
        sc.close();
    }
}
