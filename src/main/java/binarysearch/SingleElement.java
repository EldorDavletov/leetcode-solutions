package binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SingleElement {
    public static void main(String[] args) {
//        int[] nums = {1,1,2,3,3,4,4,8,8};
//        int[] nums = {1,1,4};
//        int[] nums = {3,3,7,7,10,11,11,12,12,13,13,14,14};
//        System.out.println(singleNonDuplicate(nums));
        int[] nums = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(nums));

        List<Integer> list = IntStream.rangeClosed(1, 13)
                .boxed()
                .sorted((a, b) -> String.valueOf(a).compareTo(String.valueOf(b)))
                .collect(Collectors.toList());
        System.out.println(list);
    }

    public static int singleNonDuplicate0(int[] nums) {
        int i=0;
        while (i<nums.length-1){
            if (nums[i]==nums[i+1]){
                i=i+2;
            }else {
                break;
            }
        }
        return nums[i];
    }

    public static int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid % 2 == 1) mid--;  // juft indeksga moslash
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }


    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length-1, max = arr[0];
        while (left<right){
            int mid = (left+right)/2;
            if (arr[mid]>arr[mid+1]){
                right = mid;
                max = arr[mid];
            }else {
                left = mid + 1;
            }
        }

        return right;
    }
}
