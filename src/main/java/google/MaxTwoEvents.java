package google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxTwoEvents {
    record Event(int startTime,int endTime,int value){}

    public static void main(String[] args) {
        int[][] events ={
                {1,5,3},
                {1,5,1},
                {6,6,5}
        };

        System.out.println(maxTwoEvents(events));
    }

    public static int maxTwoEvents(int[][] events) {
        int n = events.length;
        List<Event> eventList = new ArrayList<>();
        for (int[] event : events) {
            eventList.add(new Event(event[0], event[1], event[2]));
        }

        // 1-qadam: Tugash vaqtiga qarab tartiblash
        eventList.sort(Comparator.comparingInt(Event::endTime));

        // 2-qadam: Har bir nuqtagacha maksimal qiymatni saqlash
        int[] maxBefore = new int[n];
        maxBefore[0] = eventList.get(0).value;
        for (int i = 1; i < n; i++) {
            maxBefore[i] = Math.max(maxBefore[i - 1], eventList.get(i).value);
        }

        int maxTotal = 0;
        // 3-qadam: Har bir tadbirni oxirgi deb olib, oldingi maksimum bilan birlashtirish
        for (int i = 0; i < n; i++) {
            int currValue = eventList.get(i).value;
            int prevIdx = binarySearch(eventList, i); // To'qnashmaydigan eng oxirgi tadbir

            if (prevIdx != -1) {
                currValue += maxBefore[prevIdx];
            }
            maxTotal = Math.max(maxTotal, currValue); // Faqat bitta tadbir varianti
        }

        return maxTotal;
    }
    public static int maxTwoEvents0(int[][] events) {
        int n = events.length;
        int k = 2;
        List<Event> eventList = new ArrayList<>();
        for (int[] event : events){
            eventList.add(new Event(event[0],event[1],event[2]));
        }

        eventList.sort(Comparator.comparingInt(Event::endTime));
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
        }

        return dp[n][k];
    }

    public static int binarySearch(List<Event> events, int curIndex) {
        int left = 0, right = curIndex - 1, result = -1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (events.get(mid).endTime < events.get(curIndex).startTime) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}

