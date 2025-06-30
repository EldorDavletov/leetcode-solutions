package dp;

import java.lang.reflect.Field;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecodeWays {
    Map<Integer,Integer> memo = new HashMap<>();

    public static void main(String[] args) throws Exception {
        int[] arr = new int[100000000];
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("start at "+LocalTime.now());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println("end at "+LocalTime.now());
        int previousCapacity = getCapacity(list);

        System.out.println("Initial Capacity: " + previousCapacity);

        for (int i = 0; i < 100000000; i++) {
            list.add(i+1);
            int currentCapacity = getCapacity(list);

            if (currentCapacity > previousCapacity) {
                System.out.println("Resized! New Capacity: " + currentCapacity + " at size: " + list.size());
                previousCapacity = currentCapacity;
            }
        }

        System.out.println("end at "+LocalTime.now());
    }

    private static int getCapacity(ArrayList<?> list) throws Exception {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        return ((Object[]) field.get(list)).length;
    }

    public int numDecodings0(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;

        int n = s.length();
        int[] dp = new int[n + 1];

        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i)); // s[i-1] (yakka son)
            int twoDigits = Integer.parseInt(s.substring(i - 2, i)); // s[i-2]s[i-1] (ikkita son)

            if (oneDigit >= 1) {
                dp[i] += dp[i - 1]; // 1 xonali raqam decoding
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2]; // 2 xonali raqam decoding
            }
        }

        return dp[n];
    }
    public int numDecodings(String s) {
        return helper(0,s);
    }

    public int helper(int index,String s){
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (memo.containsKey(index)) return memo.get(index);
        int ways = helper(index + 1, s); // Single digit case
        if (index < s.length() - 1 && Integer.parseInt(s.substring(index, index + 2)) <= 26) {
            ways += helper(index + 2, s); // Two digits case
        }
        memo.put(index,ways);

        return ways;
    }
}
