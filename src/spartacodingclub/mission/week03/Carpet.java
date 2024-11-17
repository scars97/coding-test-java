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
            int col = 3;
            int row = totalSize / col;
            while (totalSize / col >= col) {
                if (totalSize % col == 0) {
                    row = Math.min(row, totalSize / col);
                }
                col++;
            }

            answer[0] = row;
            answer[1] = totalSize / row;

            return answer;
        }
    }
}
