package spartacodingclub.mission.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClassRoom {

    static Queue<Lecture> lectures = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(num, start, end));
        }

        Queue<Integer> rooms = new PriorityQueue<>();
        rooms.add(lectures.remove().end);

        while (!lectures.isEmpty()) {
            int size = rooms.size();
            Lecture lecture = lectures.remove();
            boolean isEmpty = false;

            for (int i = 0; i < size; i++) {
                if (rooms.peek() <= lecture.start) {
                    rooms.remove();
                    rooms.add(lecture.end);
                    isEmpty = true;
                    break;
                }
            }
            if (!isEmpty) rooms.add(lecture.end);
        }

        System.out.println(rooms.size());
        br.close();
    }

    static class Lecture implements Comparable<Lecture> {
        int num;
        int start;
        int end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}
