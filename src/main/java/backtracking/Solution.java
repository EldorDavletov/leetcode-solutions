package backtracking;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        int[] nums2 = {10,1,2,7,6,1,5};
//        System.out.println(combinationSum2(nums2,8));

        int[] nums = {1,2,3};

        System.out.println(permute(nums));

    }



    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(target,new ArrayList<>(),0,candidates,result);

        return result;
    }

     public static void backtrack(int remain, List<Integer> current, int start, int[] arr, List<List<Integer>> list){
        if (remain==0){
            list.add(new ArrayList<>(current));
        }
        if (remain > 0){
            for (int i = start; i < arr.length; i++) {
                current.add(arr[i]);
                backtrack(remain-arr[i],current,i,arr,list);
                current.removeLast();
            }
        }
     }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        backtrack2(target,new ArrayList<>(),0,candidates,result);

        return new ArrayList<>(result);
    }

    public static void backtrack2(int remain, List<Integer> current, int start, int[] arr, Set<List<Integer>> list){
        if (remain==0){
            list.add(new ArrayList<>(current));
        }
        for (int i = start; i < arr.length; i++) {
            // Bir xil qiymatlar bilan takrorlarni o'tkazib yuborish
            if (i > start && arr[i] == arr[i - 1]) continue;

            if (arr[i] > remain) break; // Agar element targetdan katta bo'lsa, davom ettirmaymiz

            current.add(arr[i]);
            backtrack2(remain - arr[i], current, i + 1, arr, list);
            current.removeLast();
        }
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result,nums,used,new ArrayList<>());
        return result;
    }

    public static void backtrack(List<List<Integer>> result, int[] nums, boolean[] used, List<Integer> current){
        if (current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]){
                current.add(nums[i]);
                used[i]=true;
                backtrack(result,nums,used,current);

                current.removeLast();
                used[i] = false;
            }

        }
    }

}
