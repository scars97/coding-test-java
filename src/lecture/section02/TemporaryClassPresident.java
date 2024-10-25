package lecture.section02;

import java.util.Scanner;

/**
 * 임시 반장 정하기
 *
 * 같은 반이었던 n번 학생과 또 같은 반이 되는 경우는 제외
 */
public class TemporaryClassPresident {

    private static final int GRADE = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] classes = new int[n+1][GRADE+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= GRADE; j++) {
                classes[i][j] = sc.nextInt();
            }
        }

        int classPresident = 0;
        int max = 0;
        for (int student = 1; student <= n; student++) {
            int sameClassCounts = 0;
            for (int otherStudent = 1; otherStudent <= n; otherStudent++) {
                for (int grade = 1; grade <= GRADE; grade++) {
                    if (classes[student][grade] == classes[otherStudent][grade]) {
                        sameClassCounts++;
                        break;
                    }
                }
                if (max < sameClassCounts) {
                    max = sameClassCounts;
                    classPresident = student;
                }
            }
        }

        System.out.println(classPresident);
        sc.close();
    }
}
