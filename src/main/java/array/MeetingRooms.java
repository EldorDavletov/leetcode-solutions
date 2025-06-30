package array;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = {{9,14},{5,6},{3,5},{12,19}};
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0) return true;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end > intervals[i][0] || intervals[i][0] == intervals[i-1][0]){
                return false;
            }else {
                end = intervals[i][1];
            }
        }
        return true;
    }
}
