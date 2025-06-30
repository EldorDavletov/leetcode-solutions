package binarysearch;

import java.util.*;

public class RussianDollEnvelopes {
    record Envelope(int width, int height){}
    public static void main(String[] args) {
        int[][] env = {{5,4},{6,4},{6,7},{2,3}};
    }

    public int maxEnvelopes(int[][] envelopes) {
        List<Envelope> list = new ArrayList<>();
        for(int[] e : envelopes){
            list.add(new Envelope(e[0],e[1]));
        }
        list.sort((a, b) -> {
            if (a.width() == b.width()) {
                return b.height() - a.height();
            } else {
                return a.width() - b.width();
            }
        });


        int[] heights = list.stream().mapToInt(Envelope::height).toArray();

        List<Integer> lis = new ArrayList<>();
        for(int height : heights){
            int index = Collections.binarySearch(lis,height);
            if (index < 0){
                index = -(index + 1);
            }
            if (index == lis.size()){
                lis.add(height);
            }else {
                lis.set(index,height);
            }
        }

        return lis.size();
    }
    public int maxEnvelopes3(int[][] envelopes) {
        // Step 1: Sort envelopes by width ASC, height DESC
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // height DESC
            } else {
                return a[0] - b[0]; // width ASC
            }
        });


        // Step 2: Extract heights and apply LIS
        int[] dp = new int[envelopes.length];
        int len = 0;

        for (int[] env : envelopes) {
            int height = env[1];
            int i = binarySearch(dp, 0, len, height);
            dp[i] = height;
            if (i == len) len++;
        }

        return len;
    }



    public int maxEnvelopes2(int[][] envelopes) {
        // Step 1: Sort envelopes
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1]; // height descending if width equal
            } else {
                return a[0] - b[0]; // width ascending
            }
        });

        // Step 2: Extract heights and apply LIS
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        // Step 3: LIS using binary search
        List<Integer> lis = new ArrayList<>();
        for (int height : heights) {
            int idx = Collections.binarySearch(lis, height);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx == lis.size()) {
                lis.add(height);
            } else {
                lis.set(idx, height);
            }
        }

        return lis.size();
    }

    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = binarySearch(dp, 0, len, num);
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }

    private int binarySearch(int[] dp, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
