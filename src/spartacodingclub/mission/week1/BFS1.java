package spartacodingclub.mission.week1;

import java.util.*;

public class BFS1 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int visitedIdx = 1;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        bfs(r);

        for (int i = 1; i <= n; i++) {
            System.out.println(result[i]);
        }
        sc.close();
    }

    static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();

        result[visitedIdx++] = r;
        visited[r] = true;
        queue.add(r);

        while (!queue.isEmpty()) {
            int x = queue.remove();

            for (int node : graph[x]) {
                if (!visited[node]) {
                    visited[node] = true;
                    // 방문 순서 저장이 아닌 방문한 노드 번호를 저장하고 있다.
                    result[visitedIdx++] = node;
                    queue.add(node);
                }
            }
        }
    }
}
