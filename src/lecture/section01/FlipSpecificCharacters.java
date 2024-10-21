package lecture.section01;

import java.util.Scanner;

/**
 * 특정 문자 뒤집기
 */
public class FlipSpecificCharacters {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int lt = 0;
        int rt = str.length() - 1;
        char[] charArray = str.toCharArray();

        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) lt++;
            else if (!Character.isAlphabetic(charArray[rt])) rt--;
            else {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }
        }

        String result = String.valueOf(charArray);
        System.out.println(result);

        sc.close();
    }
}
