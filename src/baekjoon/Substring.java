package baekjoon;

import java.util.Scanner;

public class Substring {

    public static void main(String[] args) {
        // sequence subsequence
        // person compression
        // VERDI vivaVittorioEmanueleReDiItalia
        // caseDoesMatter CaseDoesMatter

        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();
        char[] charArray = t.toCharArray();

        int indexCount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            for (int j = indexCount; j < charArray.length; j++) {
                if (c == charArray[j]) {
                    indexCount = j + 1;
                    count++;
                    break;
                }
                charArray[j] = '-';
            }
        }

        if (count != s.length()) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

        sc.close();
    }
}
