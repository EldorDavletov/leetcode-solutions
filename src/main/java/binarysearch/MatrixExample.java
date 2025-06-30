package binarysearch;

public class MatrixExample {
    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left, right, mid;
        for (int i = 0; i < matrix.length; i++) {

            if(matrix[i][0]>target){
                break;
            }
            left = 0;
            right = matrix[i].length-1;
            while (left<=right){
                mid = (left+right)/2;
                if (matrix[i][mid]==target) return true;
                if (matrix[i][mid]>target){
                    right = mid-1;
                }else {
                    left = mid +1;
                }
            }
        }

        return false;
    }

//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length == 0 && nums2.length == 0){
//            return 0;
//        }
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        int i = 0, j = 0;
//
//        while (i<len1 && j<len2){
//
//        }
//
//    }


}
