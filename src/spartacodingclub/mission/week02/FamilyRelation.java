package spartacodingclub.mission.week02;

import java.util.ArrayList;
import java.util.Scanner;

public class FamilyRelation {

    static ArrayList<Integer>[] relations;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int m = sc.nextInt();

        relations = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            relations[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            relations[x].add(y);
            relations[y].add(x);
        }

        dfs(start, end, 0);

        System.out.println(result);
        sc.close();
    }


    static void dfs(int current, int target, int depth) {
        visited[current] = true;

        if (current == target) {
            result = depth;
            return;
        }

        for (int next : relations[current]) {
            if (!visited[next]) {
                dfs(next, target, depth + 1);

                if (result != -1) return;
            }
        }
    }
}
