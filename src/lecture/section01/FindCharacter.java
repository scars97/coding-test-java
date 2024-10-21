package lecture.section01;

import java.util.Scanner;

/**
 * 문자열 찾기
 */
public class FindCharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        char keyword = sc.next().charAt(0);

        String lowerCaseOfWord = word.toLowerCase();
        char c = Character.toLowerCase(keyword);

        int count = 0;
        for (char t : lowerCaseOfWord.toCharArray()) {
            if (t == c) {
                count++;
            }
        }

        System.out.println(count);

        sc.close();
    }
}
