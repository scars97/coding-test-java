package spartacodingclub.mission.week04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Fatigue {

    public static void main(String[] args) {

        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int solution = new Solution().solution(80, dungeons);
        System.out.println(solution);
    }

    static class Solution {
        public int solution(int k, int[][] dungeons) {

            List<DungeonsFatigue> dungeonList = new ArrayList<>();
            for (int i = 0; i < dungeons.length; i++) {
                dungeonList.add(new DungeonsFatigue(dungeons[i][0], dungeons[i][1]));
            }
            Collections.sort(dungeonList);

            int count = 0;
            for (DungeonsFatigue dungeon : dungeonList) {
                if (k < dungeon.required) {
                    continue;
                }

                if (k >= dungeon.consumption) {
                    k -= dungeon.consumption;
                    count++;
                }
            }

            return count;
        }

    }

    static class DungeonsFatigue implements Comparable<DungeonsFatigue> {
        public int required;
        public int consumption;

        public DungeonsFatigue(int required, int consumption) {
            this.required = required;
            this.consumption = consumption;
        }

        @Override
        public int compareTo(DungeonsFatigue o) {

            int other = o.required - o.consumption;
            int current = this.required - this.consumption;

            if (other == current) {
                return Integer.compare(o.required, this.required);
            }
            return Integer.compare(other, current);
        }
    }
}
