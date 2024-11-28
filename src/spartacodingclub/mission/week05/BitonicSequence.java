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
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lis[i] = 1;
        }
        br.close();

        /*
        * 풀이 방법
        * LIS 개수 + LDS 개수
        * 구해진 LIS 수열 중 가장 끝자리 숫자 인덱스를 선택
        * 해당 인덱스로 시작하는 LDS 수열을 구한다.
        * */

        // LIS
        int lisCount = 0;
        int ldsStartIdx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
            int beforeCount = lisCount;
            lisCount = Math.max(lisCount, lis[i]);
            if (lisCount != beforeCount) {
                ldsStartIdx = i;
            }
        }

        // LDS
        int[] lds = new int[N];
        int ldsCount = 0;
        for (int i = ldsStartIdx; i < N; i++) {
            for (int j = ldsStartIdx; j < i; j++) {
                if (arr[i] < arr[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
            ldsCount = Math.max(ldsCount, lds[i]);
        }

        System.out.println(lisCount + ldsCount);
    }
}
