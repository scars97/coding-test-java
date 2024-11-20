package spartacodingclub.mission.week04;

import java.util.*;

public class SplittingTheGridInTwo {
    public static void main(String[] args) {
        int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        int solution = new Solution().solution(4, wires);
        System.out.println(solution);
    }

    static class Solution {

        private List<Integer>[] tree;
        private boolean[] visited;

        public int solution(int n, int[][] wires) {
            int answer = Integer.MAX_VALUE;

            // 간선 초기화
            tree = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                tree[i] = new LinkedList<>();
            }

            // 간선 연결
            for (int i = 0; i < wires.length; i++) {
                tree[wires[i][0]].add(wires[i][1]);
                tree[wires[i][1]].add(wires[i][0]);
            }

            // 모든 간선을 하나씩 끊었을 때 전력망마다 가지게 되는 송전탑 수를 구한다.
            // 분리된 전력망의 송전탑 차를 구한다.
            // 위 과정을 반복하면서 송전탑 차의 최솟값을 반환한다.
            for (int i = 0; i < wires.length; i++) {
                // 간선 끊기 - 전력망 분리
                tree[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
                tree[wires[i][1]].remove(Integer.valueOf(wires[i][0]));

                // 노드 방문 초기화
                visited = new boolean[n + 1];

                // 분리된 전력망의 송전탑 갯수를 구한다.
                int count = bfs(1);
                answer = Math.min(answer, Math.abs(count - (n - count)));

                tree[wires[i][0]].add(wires[i][1]);
                tree[wires[i][1]].add(wires[i][0]);
            }

            return answer;
        }

        private int bfs(int start) {
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(start);
            visited[start] = true;

            int count = 1;
            while (!queue.isEmpty()) {
                int current = queue.remove();

                for (int node : tree[current]) {
                    if (!visited[node]) {
                        visited[node] = true;
                        queue.add(node);
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
