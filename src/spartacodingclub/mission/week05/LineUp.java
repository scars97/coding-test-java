package spartacodingclub.mission.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
* 백준 2631번 - 줄 세우기
* */
public class LineUp {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        int result = lis(arr, N);
        System.out.println(result);
    }

    private static int lis(int[] arr, int N) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int tmp = arr[i];
            if (list.get(list.size() - 1) < tmp) {
                list.add(tmp);
            } else {
                int index = binarySearch(list, tmp);
                list.set(index, tmp);
                count++;
            }
        }

        // -1 을 한 이유
        // 1번이 옮겨진다 해도 자기 자신만 맨 앞으로 이동하면 되기 때문에
        // 자리를 바꾼 횟수에 포함 시키지 않았다.
        return count != 0 ? count - 1 : 0;
    }

    private static int binarySearch(ArrayList<Integer> list, int tmp) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < tmp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
