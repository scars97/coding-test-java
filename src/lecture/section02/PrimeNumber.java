package lecture.section02;

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

/**
 * 에라토스테네스의 체는 N보다 작거나 같은 모든 소수를 찾는 유명한 알고리즘이다.
 * 이 알고리즘은 다음과 같다.
 * 1. 2부터 N까지 모든 정수를 적는다.
 * 2. 아직 지우지 않은 수 중 가장 작은 수를 찾는다. 이것을 P라고 하고, 이 수는 소수이다.
 * 3. P를 지우고, 아직 지우지 않은 P의 배수를 크기 순서대로 지운다.
 * 4. 아직 모든 수를 지우지 않았다면, 다시 2번 단계로 간다.
 *
 * N, K가 주어졌을 때, K번째 지우는 수를 구하는 프로그램을 작성하시오.
 *
 * in : 7 3
 * out : 6
 *
 * in : 15 12
 * out : 7
 *
 * in : 10 7
 * out : 9
 */
public class PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] intArray = new int[n - 1];
        for (int i = 2; i <= n; i++) {
            intArray[i-2] = i;
        }

        int count = 0;
        int result = 0;

        for (int i = 0; i < intArray.length; i++) {
            int tmp = intArray[i];

            if (tmp != 0) {
                count++;
                if (count == k) {
                    result = tmp;
                    break;
                }

                int length = n / tmp;
                for (int j = 1; j < length; j++) {
                    int fold = tmp * j;
                    int tmp2 = intArray[i+fold];
                    if (tmp2 != 0) {
                        count++;
                        intArray[i+fold] = 0;
                    }

                    if (count == k) {
                        result = tmp2;
                        break;
                    }
                }
            }

            if (count == k) {
                break;
            }
            intArray[i] = 0;
        }

        System.out.println(result);
        sc.close();
    }
}
