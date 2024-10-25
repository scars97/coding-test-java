package lecture.section02;

import java.util.Scanner;

public class TemporaryClassPresident {

    private static final int GRADE = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] sameClassCounts = new int[n];
        int[][] classes = new int[n][GRADE];
        for (int i = 0; i < n; i++) {
            sameClassCounts[i] = 0;
            for (int j = 0; j < GRADE; j++) {
                classes[i][j] = sc.nextInt();
            }
        }

        for (int grade = 0; grade < GRADE; grade++) {
            for (int student = 0; student < n; student++) {
                for (int otherStudent = 0; otherStudent < n; otherStudent++) {
                    if (student != otherStudent) {
                        if (classes[student][grade] == classes[otherStudent][grade]) {
                            sameClassCounts[student]++;
                            break;
                        }
                    }
                }
            }
        }

        int classPresident = 0;
        int maxCount = 0;
        for (int i = 0; i < sameClassCounts.length; i++) {
            if (maxCount < sameClassCounts[i]) {
                maxCount = sameClassCounts[i];
                classPresident = i + 1;
            }
        }

        if (maxCount == 0) {
            classPresident = 1;
        }

        System.out.println(classPresident);
        sc.close();
    }
}
