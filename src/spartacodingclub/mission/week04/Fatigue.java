package spartacodingclub.mission.week04;

public class Fatigue {

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int solution = new Solution().solution(k, dungeons);
        System.out.println(solution);
    }

    static class Solution {

        public boolean[] visited;
        public int result = 0;
        public int solution(int k, int[][] dungeons) {
            visited = new boolean[dungeons.length];

            dfs(0, k, dungeons);

            return result;
        }

        void dfs(int depth, int fatigue, int[][] dg) {
            for (int i = 0; i < dg.length; i++) {
                if (!visited[i] && dg[i][0] <= fatigue) {
                    visited[i] = true;
                    dfs(depth + 1, fatigue - dg[i][1], dg);
                    visited[i] = false; // 다른 던전부터 탐험하는 경우도 있기 때문에 방문 초기화
                }
            }

            result = Math.max(result, depth);
        }

    }
}
