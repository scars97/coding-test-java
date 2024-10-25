package lecture.string;

import java.util.Scanner;

/**
 * 문장 속 단어
 * 문장 속 가장 긴 단어 출력
 */
public class WordsInSentences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String result = "";
        for (String s : str.split(" ")) {
            int length = s.length();
            if (result.length() < length) {
                result = s;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
