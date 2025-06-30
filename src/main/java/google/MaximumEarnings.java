package google;

import java.util.Arrays;
import java.util.Comparator;

class Ride{
    int start, end, tip;
    public Ride(int start, int end, int tip){
        this.start = start;
        this.end = end;
        this.tip = tip;
    }
}
public class MaximumEarnings {
    public static void main(String[] args) {
        int[][] rides = {
                {1,6,1},
                {3,10,2},
                {10,12,3},
                {11,12,2},
                {12,15,2},
                {13,18,1}
        };

        System.out.println(maxTaxiEarnings(20,rides));
    }

    public static long maxTaxiEarnings(int n, int[][] rides) {
        int i = 0;
        Ride[] rides1 = new Ride[rides.length];
        for(int[] ride : rides){
            rides1[i++] = new Ride(ride[0],ride[1],ride[2]);
        }
        Arrays.sort(rides1, Comparator.comparingInt(a -> a.end));
        long[] dp = new long[rides1.length];
        dp[0] = (rides1[0].end - rides1[0].start + rides1[0].tip);
        for (int j = 1; j < rides1.length; j++) {
            int lastIndex = binarySearch(rides1,j);
            long include = rides1[j].end - rides1[j].start + rides1[j].tip;
            if (lastIndex != -1){
                include += dp[lastIndex];
            }
            dp[j] = Math.max(dp[j-1],include);
        }
        return dp[rides1.length-1];
    }
    public static int binarySearch(Ride[] rides, int curIndex){
        int left = 0, right = curIndex - 1, result = -1;
        while (left<=right){
            int mid = (right+left)/2;
            if (rides[mid].end <= rides[curIndex].start){
                result = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return result;
    }
}
