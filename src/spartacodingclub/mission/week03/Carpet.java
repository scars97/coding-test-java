package spartacodingclub.mission.week03;

import java.util.Arrays;

public class Carpet {

    public static void main(String[] args) {
        int[] solution = new Solution().solution(24, 24);
        System.out.println(Arrays.toString(solution));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            int totalSize = brown + yellow;
            for (int col = 3; col <= totalSize; col++) {
                if ((totalSize / col - 2) * (col - 2) == yellow) {
                    answer[0] = totalSize / col;
                    answer[1] = col;
                    break;
                }
            }

            return answer;
        }
    }
}
