package spartacodingclub.mission.week02;

import java.util.*;

public class SpecificDistanceSearch {

    static ArrayList<Integer>[] graph;
    static int[] distance;
    static boolean[] visited;
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        k = sc.nextInt();
        int x = sc.nextInt();

        graph = new ArrayList[n + 1];
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
        }

        ArrayList<Integer> results = new ArrayList<>();
        bfs(x, results);

        if (!results.isEmpty()) {
            Collections.sort(results);
            for (int result : results) {
                System.out.println(result);
            }
        } else {
            System.out.println(-1);
        }
        sc.close();
    }

    private static void bfs(int start, ArrayList<Integer> results) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int tmp = queue.remove();

            for (int node : graph[tmp]) {
                if (!visited[node]) {
                    visited[node] = true;
                    distance[node] = distance[tmp] + 1;

                    queue.add(node);
                    if (distance[node] == k) {
                        results.add(node);
                    }
                }
            }
        }
    }
}
