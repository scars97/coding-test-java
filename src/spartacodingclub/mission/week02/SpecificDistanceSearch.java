package spartacodingclub.mission.week02;

import java.util.*;

public class SpecificDistanceSearch {

    static ArrayList<Integer>[] graph;
    static int[] distance;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        k = sc.nextInt();
        int x = sc.nextInt();

        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, -1); // 거리 배열 초기값을 -1로 설정
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }

        ArrayList<Integer> results = bfs(x);

        if (!results.isEmpty()) {
            results.stream()
                    .sorted()
                    .forEach(System.out::println);
        } else {
            System.out.println(-1);
        }
        sc.close();
    }

    private static ArrayList<Integer> bfs(int start) {
        ArrayList<Integer> results = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            int tmp = queue.remove();

            for (int node : graph[tmp]) {
                if (distance[node] == -1) { // 방문하지 않은 노드만 추가
                    distance[node] = distance[tmp] + 1;

                    if (distance[node] == k) {
                        results.add(node);
                    }

                    // 탐색 범위 축소 -> 불필요한 노드 방문 줄임
                    if (distance[node] < k) {
                        queue.add(node);
                    }
                }
            }
        }

        return results;
    }
}
