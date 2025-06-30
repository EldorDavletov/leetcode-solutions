package google;

import java.util.Arrays;
import java.util.Comparator;

class Job {
    int start, end, profit;
    Job(int s, int e, int p) {
        start = s;
        end = e;
        profit = p;
    }

    @Override
    public String toString() {
        return this.start + " " + this.end + " "+this.profit;
    }
}


public class MaximumProfit {

    public static void main(String[] args) {
        int[] start = {1,2,3,3};
        int[] end = {3,4,5,6};
        int[] profit = {50,10,40,70};

        System.out.println(jobScheduling(start,end,profit));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
            System.out.println(jobs[i].toString());
        }

        // End time bo‘yicha sort qilish kerak
        Arrays.sort(jobs, Comparator.comparingInt(job -> job.end));

        int[] dp = new int[n]; // dp[i] = i-gacha bo‘lgan maksimal profit
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {
            int includeProfit = jobs[i].profit;
            int lastIndex = binarySearch(jobs, i);

            if (lastIndex != -1) {
                includeProfit += dp[lastIndex];
            }

            dp[i] = Math.max(dp[i - 1], includeProfit);
        }

        return dp[n - 1];
    }

    private static int binarySearch(Job[] jobs, int currentIndex) {
        int low = 0, high = currentIndex - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid].end <= jobs[currentIndex].start) {
                result = mid;
                low = mid + 1; // O'ngga siljimayapmiz, chunki eng so‘nggi mos ishni qidirmoqdamiz
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
