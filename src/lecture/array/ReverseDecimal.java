package lecture.array;

import java.util.Scanner;

/**
 * 뒤집은 소수
 */
public class ReverseDecimal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] naturalNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            naturalNumbers[i] = sc.nextInt();
        }

        int[] reverseNumbers = reversingNaturalNumbers(naturalNumbers);

        for (int i = 0; i < reverseNumbers.length; i++) {
            int reverseNumber = reverseNumbers[i];
            if (isPrimeNumber(reverseNumber)) {
                System.out.printf("%d ", reverseNumber);
            }
        }

        sc.close();
    }

    private static boolean isPrimeNumber(int givenNumber) {
        if (givenNumber == 1) {
            return false;
        }

        for (int i = 2; i < givenNumber; i++) {
            if (givenNumber % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static int[] reversingNaturalNumbers(int[] naturalNumbers) {
        for (int i = 0; i < naturalNumbers.length; i++) {
            int tmp = naturalNumbers[i];
            int reverse = 0;

            while (tmp != 0) {
                int digit = tmp % 10;
                reverse = reverse * 10 + digit;
                tmp /= 10;
            }

            naturalNumbers[i] = reverse;
        }

        return naturalNumbers;
    }


}
