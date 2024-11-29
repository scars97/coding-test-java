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
            StringBuilder answer = new StringBuilder(new_id.toLowerCase());

            for (int i = 0; i < answer.length(); i++) {
                char ch = answer.charAt(i);
                if (!(Character.isLowerCase(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.')) {
                    answer.deleteCharAt(i);
                    i--;
                }
            }

            for (int i = 1; i < answer.length(); i++) {
                if (answer.charAt(i) == '.' && answer.charAt(i - 1) == '.') {
                    answer.deleteCharAt(i);
                    i--;
                }
            }
            if (answer.length() > 0 && answer.charAt(0) == '.') {
                answer.deleteCharAt(0);
            }
            if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.') {
                answer.deleteCharAt(answer.length() - 1);
            }
            if (answer.length() == 0) {
                answer.append("a");
            }
            if (answer.length() > 15) {
                answer.setLength(15);
                if (answer.charAt(answer.length() - 1) == '.') {
                    answer.deleteCharAt(answer.length() - 1);
                }
            }
            while (answer.length() < 3) {
                answer.append(answer.charAt(answer.length() - 1));
            }
            return answer.toString();
        }
    }
}
