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
            int count = 1;

            if (!map.isEmpty()) {
                if (map.get(tmp) != null) {
                    map.put(tmp, map.get(tmp) + 1);
                } else {
                    map.put(tmp, count);
                }
            } else {
                map.put(tmp, count);
            }
        }

        String result = "";
        int max = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey().toString();
            }
        }

        System.out.println(result);
        sc.close();
    }
}
