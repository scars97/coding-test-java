package spartacodingclub.mission.week02;

import java.util.ArrayList;
import java.util.Scanner;

public class YesOryes {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] fans;
    static int count = 0;

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
        fans = new int[s];
        for (int i = 0; i < s; i++) {
            fans[i] = sc.nextInt();
        }

        dfs(1);

        System.out.println(count == 0 ? "Yes" : "yes");
        sc.close();
    }

    static void dfs(int node) {
        for (int fan : fans) {
            if (node == fan) {
                return;
            }
        }

        if (graph[node].isEmpty()) {
            count++;
        }

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
