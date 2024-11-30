package spartacodingclub.mission.week05;

import java.time.LocalDate;
import java.util.*;

/*
* 프로그래머스 - 개인정보 수집 유효기간
* */
public class PrivacyValidityPeriod {

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        List<Integer> solution = new Solution().solution(today, terms, privacies);
        System.out.println(solution.toString());
    }

    static class Solution {
        public List<Integer> solution(String today, String[] terms, String[] privacies) {

            // 현재 날짜 Date 형식으로 변경
            LocalDate todayDate = convertToDate(today);

            // terms 에서 약관, 유효기간 분리
            Map<String, Long> termsMap = termsTypeWithPeriod(terms);

            // privacies 의 유효기간 구하기
            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < privacies.length; i++) {
                String[] privacyArr = privacies[i].split(" ");

                LocalDate startCollectDate = convertToDate(privacyArr[0]);

                Long period = termsMap.get(privacyArr[1]);
                LocalDate validityPeriod = startCollectDate.plusMonths(period).minusDays(1L);

                // 현재 날짜와 비교
                if (validityPeriod.isBefore(todayDate)) {
                    answer.add(i + 1);
                }
            }

            return answer;
        }

        private Map<String, Long> termsTypeWithPeriod(String[] terms) {
            Map<String, Long> termsMap = new HashMap<>();
            for (String term : terms) {
                String[] termArr = term.split(" ");
                termsMap.put(termArr[0], Long.valueOf(termArr[1]));
            }
            return termsMap;
        }

        private LocalDate convertToDate(String date) {
            String[] split = date.split("\\.");
            return LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }
    }
}
