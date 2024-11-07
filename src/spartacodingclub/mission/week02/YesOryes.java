package spartacodingclub.mission.week02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class YesOryes {

    static final int START_NODE = 1;

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Set<Integer> fans;
    static int unmeetCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
        }

        int s = sc.nextInt();
        fans = new HashSet<>();
        for (int i = 0; i < s; i++) {
            fans.add(sc.nextInt());
        }

        visited[START_NODE] = true;
        dfs(START_NODE);

        System.out.println(unmeetCount == 0 ? "Yes" : "yes");
        sc.close();
    }

    static void dfs(int node) {
        if (fans.contains(node)) return;

        if (graph[node].isEmpty()) {
            unmeetCount++;
            return;
        }

        for (int next : graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}
