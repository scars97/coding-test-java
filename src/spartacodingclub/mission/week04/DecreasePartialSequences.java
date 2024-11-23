package spartacodingclub.mission.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
* 백준 11722번 - 가장 긴 감소하는 부분 수열
*/
public class DecreasePartialSequences {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = getLdsLength(arr);
        System.out.println(result);
        br.close();
    }

    private static int getLdsLength(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int el = arr[i];
            if (list.get(list.size() - 1) > el) {
                list.add(el);
            } else {
                int idx = binarySearch(list, el);
                list.set(idx, el);
            }
        }

        return list.size();
    }

    private static int binarySearch(ArrayList<Integer> list, int el) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) == el) {
                return mid;
            } else if (list.get(mid) > el) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
