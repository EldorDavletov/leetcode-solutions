package bit_manipulation;

import java.util.*;

public class CountingBits {
    public static void main0(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }

    public static int[] countBits(int n) {
        if(n == 0) return new int[]{0};
        int[] result = new int[n+1];
        for (int i = 0; i <= n; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0){
                return c;
            }
            map.put(c,map.getOrDefault(c,0)-1);
        }
        return ' ';
    }

    public static char findTheDifference2(String s, String t) {
        int ans = 0;
        String str = s + t;

        for (char c: str.toCharArray()) {
            ans ^= c;
        }
        return  (char)ans;
    }

    static int a;
    static double b;
    static float c;
    static boolean d;
    public static void main(String[] args) {


        int[] nums = {2,2,2};
        System.out.println(findDuplicate(nums));
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

    }


    public static int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        int prev = -1;
        int curr = -1;
        int max = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1' && prev == -1){
                prev = i;
            } else if (binaryString.charAt(i) == '1') {
                curr = i;
            }
            if (curr>prev){
                max = Math.max(max, curr - prev);
                prev = curr;
            }
        }
        return max;
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // 1. Cycle detection: slow - 1 step, fast - 2 steps
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // 2. Find entry point of cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }


}
