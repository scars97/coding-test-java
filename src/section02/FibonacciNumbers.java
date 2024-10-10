package section02;

import java.util.Scanner;

/**
 * 피보나치 수열
 *
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 *
 * in : 10
 * out : 1 1 2 3 5 8 13 21 34 55
 */
public class FibonacciNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] intArray = new int[n];

        for (int i = 0; i < n; i++) {
            if (i - 2 < 0) {
                intArray[i] = 1;
            } else {
                int tmp1 = intArray[i-2];
                int tmp2 = intArray[i-1];

                intArray[i] = tmp1 + tmp2;
            }

            System.out.print(intArray[i] + " ");
        }

        sc.close();
    }
}
