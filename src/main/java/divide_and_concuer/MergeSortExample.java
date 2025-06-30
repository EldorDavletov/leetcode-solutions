package divide_and_concuer;

import java.util.Arrays;

public class MergeSortExample {
    public static void main(String[] args) {
        int[] nums1 = {0,7,8,9};
        int[] nums2 = {1,2,9};
        int[] nums = {9,8,7,4,5,6,3,2,1};
        System.out.println(Arrays.toString(merge(nums1, nums2)));
        int[] sortedArray = sort(nums,0, nums.length-1);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] sort(int[] nums, int left, int right) {
        System.out.println(Arrays.toString(nums));
        if (left >= right) {
            return new int[]{nums[left]};
        }


        int mid = (left + right) / 2;
        int[] leftArr = sort(nums, left, mid);
        int[] rightArr = sort(nums, mid + 1, right);

        return merge(leftArr, rightArr);

    }


    public static int[] merge (int[] left, int[] right){
        int l1 = left.length;
        int l2 = right.length;
        int[] result = new int[l1 + l2];

        int i = 0, j = 0, k = -1;
        while (i<l1 && j<l2){

            if (left[i]<right[j]){
                result[++k] = left[i];
                i++;
            }else if (left[i]>right[j]){
                result[++k] = right[j];
                j++;
            } else {
                result[++k] = left[i];
                result[++k] = right[j];
                i++;
                j++;
            }
        }

        while (i < l1) {
            result[++k] = left[i++];
        }

        while (j < l2) {
            result[++k] = right[j++];
        }

        return result;

    }
}
