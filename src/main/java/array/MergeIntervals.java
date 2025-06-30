package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,3},{2,6},{8,10},{15,18}
        };

        System.out.println(Arrays.deepToString(merge(intervals)));
    }


    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];
            if (current[1] >= next[0]){
                current[1] = Math.max(current[1],next[1]);
            }else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}
