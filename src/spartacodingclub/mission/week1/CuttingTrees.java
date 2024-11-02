package spartacodingclub.mission.week1;

import java.util.Scanner;

public class CuttingTrees {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = sc.nextInt();
        }

        int left = 0;
        int right= (int) 1e9;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            int totalHeight = 0;
            for (int tree : trees) {
                if (tree - mid > 0) {
                    totalHeight += (tree - mid);
                }
            }

            // 나무 길이를 최대 m 만큼 얻는 것이 아니라,
            // 최소 m 이상 얻을 수 있는 최대 높이를 찾는 것
            if (totalHeight <= m) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
