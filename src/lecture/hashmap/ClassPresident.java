package lecture.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 학급 회장
 */
public class ClassPresident {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = sc.next();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        int max = 0;
        char result = ' ';
        for (char key : map.keySet()) {
            int value = map.get(key);
            if (max < map.get(key)) {
                max = value;
                result = key;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
