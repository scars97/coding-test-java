package spartacodingclub.mission.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 백준 11054번 - 가장 긴 바이토닉 부분 수열
* */
public class BitonicSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] lis = new int[N];
        int[] lds = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lis[i] = 1;
            lds[i] = 1;
        }
        br.close();

        /*
        * 풀이방법
        * LIS 와 LDS 배열을 각각 나누고
        * 두 배열의 같은 인덱스를 가지는 값끼리 더하여 최댓값을 찾는다.
        * 원소들이 1개씩 중복되어 있기 때문에 최댓값에서 -1 을 해준다.
        * */

        // LIS
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // LDS
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= i; j--) {
                if (arr[j] < arr[i]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, lis[i] + lds[i]);
        }

        System.out.println(result - 1);
    }
}
