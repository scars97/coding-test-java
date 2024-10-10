package section02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 보이는 학생
 *
 * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
 * 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
 *
 * in : 8
 *      130 135 148 140 145 150 150 153
 * out : 5
 */
public class VisibleStudents {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heightOfStudents = new int[n];
        for (int i = 0; i < n; i++) {
            heightOfStudents[i] = sc.nextInt();
        }
        
        int count = 0;
        int height = 0;
        for (int i = 0; i < n; i++) {
            if (height < heightOfStudents[i]) {
                count++;
                height = heightOfStudents[i];
            }
        }

        System.out.println(count);
        sc.close();
    }
}
