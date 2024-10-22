package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long sum = 1;
        long f1 = 0;
        long f2 = 1;

        for(int i = 1 ; i < n ; i++) {
            sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }

        System.out.println(sum);

        /*int[] intArr = new int[n + 1];

        for (int i = 0; i < intArr.length; i++) {
            if (i > 1) {
                intArr[i] = intArr[i-1] + intArr[i-2];
                continue;
            }

            intArr[i] = i;
        }

        System.out.println(Arrays.toString(intArr));
        System.out.println(intArr[n]);*/
    }

}
