package array;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {2,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0,k=-1;
        int[] arr = new int[n+m];
        while (i < m && j < n){
            if (nums1[i] <= nums2[j]){
                arr[++k] = nums1[i];
                i++;
            }else {
                arr[++k] = nums2[j];
                j++;
            }
        }
        while (i<m){
            arr[++k] = nums1[i++];
        }
        while (j<n){
            arr[++k] = nums2[j++];
        }

        for (int l = 0; l < arr.length; l++) {
            nums1[l] = arr[l];
        }
//        System.out.println(Arrays.toString(nums1));
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // nums1 oxirgi elementini ko'rsatadi
        int j = n - 1; // nums2 oxirgi elementini ko'rsatadi
        int k = m + n - 1; // nums1 oxiridan boshlaydi

        // Kattaroq elementlarni oxiriga joylashtirish
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Agar nums2 dan elementlar qolgan bo'lsa, ularni joylashtirish
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        // nums1 ni chop etish (shunchaki tekshirish uchun)
        System.out.println(Arrays.toString(nums1));
    }

}
