package section02;

import java.util.Scanner;

/**
 * 소수(에라토스테네스 체)
 *
 * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
 * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
 *
 * in : 20
 * out : 8
 */
public class PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] intArray = new int[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = i + 1;
        }

        int count = 0;

        intArray[0] = 0;
        for (int i = 1; i < n; i++) {
            int tmp = intArray[i];

            if (tmp != 0) {
                int length = n / tmp;
                for (int j = 1; j < length; j++) {
                    int fold = tmp * j;
                    intArray[i+fold] = 0;
                }
                count++;
            }

        }

        System.out.println(count);
        sc.close();
    }
}
