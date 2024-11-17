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
            while (totalSize / col >= col) {
                if (totalSize % col == 0) {
                    // 갈색 테두리는 1줄.
                    // (가로 - 2) * (세로 - 2) = yellow 개수
                    if ((totalSize / col - 2) * (col - 2) == yellow) {
                        answer[0] = totalSize / col;
                        answer[1] = col;
                        break;
                    }
                }
                col++;
            }

            return answer;
        }
    }
}
