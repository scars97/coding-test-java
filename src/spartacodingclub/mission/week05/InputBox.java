package spartacodingclub.mission.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
* 백준 1965번 - 상자 넣기
*/
public class InputBox {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] boxes = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int result = lis(boxes, n);
        System.out.println(result);
    }

    private static int lis(int[] boxes, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(boxes[0]);

        for (int i = 1; i < n; i++) {
            int tmp = boxes[i];
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
            if (list.get(mid) == tmp) {
                return mid;
            } else if (list.get(mid) < tmp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

}
