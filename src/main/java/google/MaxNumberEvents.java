package google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Event{
    int startDay, endDay,value;
    public Event(int startDay,int endDay, int value){
        this.startDay = startDay;
        this.endDay = endDay;
        this.value = value;
    }
}
public class MaxNumberEvents {
    public static void main(String[] args) {
        int[][] events = {
                {1,2,4},
                {3,4,3},
                {2,3,10}
        };
        int[][] events2 = {
                {1,1,1},
                {2,2,2},
                {3,3,3},
                {4,4,4}
        };


        System.out.println(maxValue(events,2));
        System.out.println(maxValue(events2,3));
    }

    public static int maxValue(int[][] events, int k) {
        int n = events.length;
        List<Event> eventList = new ArrayList<>();
        for (int[] ints : events) {
            eventList.add(new Event(ints[0], ints[1], ints[2]));
        }
        eventList.sort(Comparator.comparingInt(event->event.endDay));

        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            int lastNonOverlap = binarySearch(eventList, i - 1);

            for (int j = 1; j <= k; j++) {
                // Option 1: Don't take this event
                dp[i][j] = dp[i-1][j];

                // Option 2: Take this event
                int include = eventList.get(i-1).value;
                if (lastNonOverlap != -1){
                    include += dp[lastNonOverlap + 1][j - 1];
                }
                dp[i][j] = Math.max(dp[i][j],include);
            }
//            printDP(dp);
        }

        return dp[n][k];
    }

    public static int binarySearch(List<Event> events, int curIndex) {
        int left = 0, right = curIndex - 1, result = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (events.get(mid).endDay < events.get(curIndex).startDay) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private static void printDP(int[][] dp) {
        System.out.println("DP Table:");
        for (int i = 0; i < dp.length; i++) {
            System.out.print("i=" + i + ":\t");
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
