package baekjoon;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String password = "";
        while (true) {
            password = sc.nextLine();

            if ("END".equals(password)) {
                break;
            }

            String reverse = new StringBuilder(password).reverse().toString();
            sb.append(reverse).append("\n");
        }

        System.out.println(sb);
        sc.close();
    }
}
