package divide_and_concuer;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3,3,4};
        System.out.println(majorityElement(nums));

        int[][] matrix = {{-5}};
        System.out.println(searchMatrix(matrix,-5));
    }

    public static int majorityElement(int[] nums) {
        return majorElRec(nums,0, nums.length-1);
    }

    public static int majorElRec(int[] nums, int left, int right){
        if (left == right) return nums[left];
        int mid = left+ (right-left)/2;

        int leftMajor = majorElRec(nums,left,mid);
        int rightMajor = majorElRec(nums,mid+1,right);

        if (leftMajor == rightMajor) return leftMajor;

        int leftHertz = count(nums, left, right, leftMajor);
        int rightHertz = count(nums, left, right, rightMajor);

        return leftHertz > rightHertz ? leftMajor : rightMajor;

    }

    public static int count(int[] nums, int left, int right, int num){
        int count = 0;
        for (int i = left; i <= right ; i++) {
            if (nums[i]==num) count++;
        }

        return count;
    }


    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0]<=target){
                if(binarySearch(matrix[i],target)){
                    return true;
                }
            }

        }
        return false;
    }
    public static boolean binarySearch(int[] nums,int target){
        int left = 0, right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums[mid]==target){
                return true;
            }
            if (nums[mid]<target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

//    public TreeNode sortedArrayToBST(int[] nums) {
//
//
//    }
}
