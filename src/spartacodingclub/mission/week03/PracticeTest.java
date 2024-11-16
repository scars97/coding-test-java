package spartacodingclub.mission.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeTest {

    public static void main(String[] args) {

        int[] answers1 = {1, 2, 3, 4, 5};
        int[] answers2 = {1, 3, 2, 4, 2};
        int[] solution = new PracticeTest().solution(answers1);
        System.out.println(Arrays.toString(solution));
    }

    public int[] solution(int[] answers) {
        int[] counts = new int[3];

        int[] take1 = {1, 2, 3, 4, 5};
        int[] take2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] take3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int idx1 = 0, idx2 = 0, idx3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == take1[idx1]) counts[0]++;
            if (answers[i] == take2[idx2]) counts[1]++;
            if (answers[i] == take3[idx3]) counts[2]++;

            idx1++;
            idx2++;
            idx3++;

            if (idx1 == take1.length) idx1 = 0;
            if (idx2 == take2.length) idx2 = 0;
            if (idx3 == take3.length) idx3 = 0;
        }

        int max = Math.max(counts[0], Math.max(counts[1], counts[2]));
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == max) answer.add(i + 1);
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}
