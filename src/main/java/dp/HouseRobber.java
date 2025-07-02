package dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        HouseRobber obj = new HouseRobber();
        System.out.println(obj.rob(nums));
    }

    Map<Integer,Integer> memo = new HashMap<>();

    public int rob(int[] nums) {
        return dp(nums,memo,nums.length-1);
    }


    private int dp(int[] nums, Map<Integer,Integer> memo, int index){
        if(index == 0) return nums[0];
        if(index == 1) return Math.max(nums[0],nums[1]);

        if(!memo.containsKey(index)){
            memo.put(index, Math.max(dp(nums,memo,index-1),dp(nums,memo,index-2) + nums[index]));
        }

        return memo.get(index);
    }
}
