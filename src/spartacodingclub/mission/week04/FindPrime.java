package spartacodingclub.mission.week04;

import java.util.HashSet;
import java.util.Set;

public class FindPrime {

    public static void main(String[] args) {
        int solution = new Solution().solution("011");
        System.out.println(solution);
    }

    static class Solution {
        public char[] number;
        public boolean[] visited;
        public Set<Integer> set = new HashSet<>();

        public int solution(String numbers) {
            int answer = 0;

            number = new char[numbers.length()];
            visited = new boolean[numbers.length()];
            for (int i = 0; i < numbers.length(); i++) {
                number[i] = numbers.charAt(i);
            }

            dfs(set, "");

            for (Integer number : set) {
                if (isPrime(number)) answer++;
            }

            return answer;
        }

        private void dfs(Set<Integer> set, String s) {
            for (int i = 0; i < number.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    set.add(Integer.parseInt(s + number[i]));
                    dfs(set, s + number[i]);
                    visited[i] = false;
                }
            }
        }

        private boolean isPrime(int number) {
            if (number < 2) return false;

            for (int i = 2; i < number; i++) {
                for (int j = 1; j <= number / i; j++) {
                    if (i * j == number) return false;
                }
            }
            return true;
        }
    }
}
