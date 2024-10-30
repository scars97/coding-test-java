package spartacodingclub.mission.week1;

public class Immigration {

    public static void main(String[] args) {

        long answer = solution(6, new int[]{7, 10});
        System.out.println(answer);
    }

    static long solution(int n, int[] times) {
        long answer = 0;

        long left = 0;
        long right = (long) (30 * n);

        while (left <= right) {
            long mid = (left + right) / 2;

            long totalPeople = 0;
            for (int time : times) {
                totalPeople += (mid / time);
                if (totalPeople >= n) break;
            }

            if (totalPeople >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

}
