package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},{3,5},{6,7},{8,10},{12,16}
        };
        int[] newInterval = {4,8};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // 1. Oldin joylashgan interval'larni qo‘shamiz
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Overlap bo'lgan interval'larni birlashtiramiz
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // merge qilingan intervalni qo‘shamiz

        // 3. Qolgan interval'larni qo‘shamiz
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
