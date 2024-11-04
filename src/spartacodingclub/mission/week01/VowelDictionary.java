package spartacodingclub.mission.week01;

import java.util.ArrayList;
import java.util.List;

public class VowelDictionary {

    private static final String[] ALPHABETS = {"A", "E", "I", "O", "U"};
    private static final List<String> DICTIONARY = new ArrayList<>();

    public static void main(String[] args) {
        String word = "EIO";
        System.out.println(solution(word));
    }

    static int solution(String word) {
        generateWords("");
        return DICTIONARY.indexOf(word);
    }

    static void generateWords(String word) {
        if (word.length() > 5) return;
        DICTIONARY.add(word);

        for (int i = 0; i < ALPHABETS.length; i++) {
            generateWords(word + ALPHABETS[i]);
        }
    }
}
