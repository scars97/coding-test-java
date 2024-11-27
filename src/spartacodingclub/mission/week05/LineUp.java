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
        System.out.println(N - result);
    }

    private static int lis(int[] arr, int N) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 0; i < N; i++) {
            int tmp = arr[i];
            if (list.get(list.size() - 1) < tmp) {
                list.add(tmp);
            } else {
                int index = binarySearch(list, tmp);
                list.set(index, tmp);
            }
        }

        return list.size();
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
