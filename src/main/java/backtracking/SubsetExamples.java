package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetExamples {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,0,nums,new ArrayList<>());
        return result;
    }

    private static void backtrack(List<List<Integer>> result, int index,int[]nums,List<Integer> list){
        System.out.println("enter index: "+index);
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(result,i+1,nums,list);
            list.removeLast();
        }
        System.out.println("exit index: "+index);
    }

}
