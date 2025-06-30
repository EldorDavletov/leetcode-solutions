package greedy;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public record Interval(int start, int end){}
    public static void main(String[] args) {
        CharSequence sequence = "02:40";
        String str = (String) sequence;
        System.out.println("22:08".compareTo("02:40"));

        int[][] intervals = {
                {1,2},{2,3},{3,4},{1,3}
        };

        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Interval[] intervalList = new Interval[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            intervalList[i] = new Interval(intervals[i][0],intervals[i][1]);
        }
        Arrays.sort(intervalList, Comparator.comparingInt(interval -> interval.end));
        System.out.println(Arrays.toString(intervalList));
        int end = intervalList[0].end;
        int count = 0;

        for (int i = 1; i < intervalList.length; i++) {
            Interval interval = intervalList[i];
            if (end > interval.start) {
                count++;
            }else {
                end = interval.end;
            }
        }

        return count;
    }

    public static int eraseOverlapIntervals0(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0, end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                count++; // overlap
            } else {
                end = intervals[i][1];
            }
        }
        return count;
    }


    public boolean haveConflict(String[] event1, String[] event2) {
        LocalTime time1 = LocalTime.parse(event1[1]);
        LocalTime time2 = LocalTime.parse(event2[0]);
        return time1.isAfter(time2) || event1[1].equals(event2[0]);
    }

}
