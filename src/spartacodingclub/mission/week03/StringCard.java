package spartacodingclub.mission.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StringCard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] alphabets = new String[N];
            for (int j = 0; j < N; j++) {
                alphabets[j] = st.nextToken();
            }

            Deque<String> deque = new ArrayDeque<>();
            deque.addFirst(alphabets[0]);

            for (int j = 1; j < alphabets.length; j++) {
                char tmp = alphabets[j].charAt(0);

                if (deque.getFirst().charAt(0) >= tmp) { // first
                    deque.addFirst(alphabets[j]);
                } else { // last
                    deque.addLast(alphabets[j]);
                }
            }

            while (!deque.isEmpty()) {
                sb.append(deque.remove());
            }
            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
