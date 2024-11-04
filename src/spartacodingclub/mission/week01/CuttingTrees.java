package spartacodingclub.mission.week01;

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

            // 오버플로우 - 베어낸 나무 길이의 합이 int 범위를 넘을 수 있다.
            long totalHeight = 0;
            for (int tree : trees) {
                if (tree - mid > 0) {
                    totalHeight += (tree - mid);
                }
            }

            if (totalHeight >= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
