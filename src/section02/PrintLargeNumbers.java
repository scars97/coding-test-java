package section02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 큰 수 출력하기
 *
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요. (첫 번째 수는 무조건 출력한다)
 *
 * in : 6
 *      7 3 9 5 6 12
 * out : 7 9 6 12
 */
public class PrintLargeNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nArray = new int[n];
        for (int i = 0; i < n; i++) {
            nArray[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(nArray[0]).append(" ");
        for (int i = 1; i < n; i++) {
            if (nArray[i] > nArray[i- 1]) {
                sb.append(nArray[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
