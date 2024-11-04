package spartacodingclub.mission.week01;

import java.util.*;

public class BFS1 {

    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int visitedIdx = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();

        graph = new ArrayList[n + 1];
        visited = new int[n + 1];

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
            System.out.println(visited[i]);
        }
        sc.close();
    }

    static void bfs(int r) {
        Queue<Integer> queue = new LinkedList<>();

        visited[r] = visitedIdx++;
        queue.add(r);

        while (!queue.isEmpty()) {
            int x = queue.remove();

            for (int node : graph[x]) {
                if (visited[node] == 0) {
                    visited[node] = visitedIdx++;
                    queue.add(node);
                }
            }
        }
    }
}
