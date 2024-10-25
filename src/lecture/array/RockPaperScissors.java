package lecture.array;

import java.util.Scanner;

/**
 * 가위 바위 보
 *
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 * 가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
 *
 * in : 5
 *      2 3 3 1 3
 *      1 1 2 2 3
 * out : A
 *       B
 *       A
 *       B
 *       D
 */
public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] infoA = new int[n];
        int[] infoB = new int[n];
        for (int i = 0; i < n; i++) {
            infoA[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            infoB[i] = sc.nextInt();
        }


        for (int i = 0; i < n; i++) {
            int a = infoA[i];
            int b = infoB[i];

            String winner = winner(a, b);
            System.out.println(winner);
        }

        sc.close();
    }

    private static String winner(int a, int b) {
        if (a == b) {
            return "D";
        }
        if (a > b) {
            if (a == 3 && b == 1) {
                return "B";
            }
            return "A";
        } else {
            if (b == 3 && a == 1) {
                return "A";
            }
            return "B";
        }
    }
}
