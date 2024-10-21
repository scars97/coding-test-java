package baekjoon;

import java.util.Scanner;

public class CommandPrompt {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] fileNames = new String[n];
        for (int i = 0; i < n; i++) {
            fileNames[i] = sc.next();
        }

        int strCount = fileNames[0].length();
        for (int i = 0; i < strCount; i++) {

            char print = fileNames[0].charAt(i);
            for (int j = 0; j < fileNames.length - 1; j++) {
                char current = fileNames[j].charAt(i);
                char next = fileNames[j+1].charAt(i);

                if (current != next) {
                    print = '?';
                    break;
                }
            }

            System.out.print(print);
        }

        sc.close();
    }
}
