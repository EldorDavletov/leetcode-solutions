package greedy;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = nums[i]+"";
        }
        Arrays.sort(numbers,(a,b)->(b+a).compareTo(a+b));
        if (numbers[0].equals("0")) return "0";
        StringBuilder result = new StringBuilder();
        for(String number : numbers){
            result.append(number);
        }
        return result.toString();
    }
}
