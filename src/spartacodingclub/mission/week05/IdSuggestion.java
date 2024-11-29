package spartacodingclub.mission.week05;

/*
* 프로그래머스 - 신규 아이디 추천
* */
public class IdSuggestion {

    public static void main(String[] args) {;
        String newId = "...!@BaT#*..y.abcdefghijklm";
        String solution = new Solution().solution(newId);
        System.out.println(solution);
    }
    static class Solution {

        public String solution(String new_id) {
            String answer = "";

            // 1
            answer = new_id.toLowerCase();

            // 2
            answer = answer.replaceAll("[^a-z0-9._-]", "");

            // 3
            answer = answer.replaceAll("[.]+", ".");

            // 4
            answer = answer.replaceAll("^[.]|[.]$", "");

            // 5
            answer = answer.isEmpty() ? "a" : answer;

            // 6
            if (answer.length() > 15) {
                answer = answer.substring(0, 15);
                answer = answer.replaceAll("[.]$", "");
            }

            // 7
            if (answer.length() <= 2) {
                while (answer.length() != 3) {
                    answer += answer.charAt(answer.length() - 1);
                }
            }

            return answer;
        }
    }
}
