package binarysearch;

import java.util.Arrays;
import java.util.Comparator;

public class Solutions {
    public static void main(String[] args) {

//        int [] nums = {-1,-2,-3,-4};
//        int [][] grid = {
//                {4,3,2,-1},
//                {3,2,1,-1},
//                {1,1,-1,-2},
//                {-1,-1,-2,-3}
//        };
//        int [] statues = {6,2,3,8};
//        int [] seq = {1, 2, 1, 2};
//        int [] seq2 = {1, 2, 5, 3, 5};
//        System.out.println(countNegatives(nums));
//        System.out.println(countNegatives(grid));
//
//        System.out.println( solution(15));
//        System.out.println(solution("aabaa"));
//        System.out.println(solution(statues));
//        System.out.println(isInc(statues));


        //        char[] chars = {'c','f','j'};
//        System.out.println(nextGreatestLetter(chars,'k'));

//        System.out.println(isPerfectSquare(808201));
//        System.out.println(mySqrt(1));

        int[] arr = {5,6,7,8,9};
        System.out.println(findKthPositive(arr,4));
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        if (nums.length==0 || target< nums[0] || target>nums[right]){
            return new int[] {-1,-1};
        }

        int mid = -1;

        while (left<=right){
            mid = left + (right-left)/2;
            if (nums[mid] == target){
                break;
            }
            if (target<nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if (nums[mid] != target){
            return new int[] {-1,-1};
        } else {
            left = mid;
            right = mid;
            // Chap tomonga target qiymatini qidirish
            while (left > 0 && nums[left - 1] == target) {
                left--;
            }

            // O'ng tomonga target qiymatini qidirish
            while (right < nums.length - 1 && nums[right + 1] == target) {
                right++;
            }

            return new int[] {left,right};
        }

    }

    public static int searchInsert(int[] nums, int target) {

        int left = 0, right = nums.length-1;
        if (target>nums[right]) return  nums.length;

        while (left<=right){
            int mid = left + (right-left)/2;
            if (nums[mid] == target) return mid;
            if (target<nums[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while (left<=right){

            int mid = left + (right-left)/2;

            if (nums[mid]==target){
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (nums[mid] >= target && nums[left] <= target)
                    right = mid - 1;
                else
                    left = mid + 1;

            } else {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return -1;
    }
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left<right){

            int mid = left + (right-left)/2;
            // Agar o'rta element o'ngdagi elementdan katta bo'lsa, unda minimum o'ng tomonda bo'ladi
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Aks holda, minimum chap tomonda yoki o'rta elementning o'zida bo'ladi
                right = mid;
            }
        }
        return nums[left];
    }

     public static int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left<right){

            int mid = left + (right-left)/2;
            if (nums[mid]>nums[right]){
                left = mid +1;
            } else if(nums[mid]<nums[right]){
                right = mid;
            } else {
                right--;
            }

        }
        return nums[left];
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // Agar left butun arrayni aylanib chiqib bo'lgan bo'lsa,
        // keyingi katta harf arrayning boshida bo'ladi
        return letters[left % letters.length];
    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int left, right, mid;
        for (int i = 0; i < grid.length; i++) {
            left = 0;
            right = grid[i].length-1;
            if (grid[i][0]<0){
                count = count + (grid.length -i) * grid[i].length;
                break;
            }
            while (left<=right){
                mid = left + (right-left)/2;
                if (grid[i][mid]>=0){
                    left = mid+1;
                }else {
                    right = mid - 1;
                }
            }
            count = count + grid[i].length - left;
        }

        return count;
    }


    public static int countNegatives(int[] nums) {
        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }


        return nums.length-left;
    }

   static int solution(int year){
        return (int) Math.ceil((float) year /100);
   }

    static boolean solution(String inputString) {
        StringBuilder reverseStr = new StringBuilder(inputString);
        reverseStr.reverse();
        System.out.println(reverseStr);
        return inputString.contentEquals(reverseStr);
    }

    static int solution(int[] statues) {
        int min = statues[0], max = 0;
        for (int i = 0; i < statues.length; i++) {
            if(min>statues[i]){
                min = statues[i];
            }
            if(max<statues[i]){
                max = statues[i];
            }
        }
        System.out.println("max = "+max);
        System.out.println("min = "+min);
        return max - min + 1 - statues.length;
    }

    static boolean isInc(int[] sequence) {
        boolean isInc = true;
        int countDeleted = 0;
        int lastElement = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            if(sequence[i]>lastElement){
                lastElement = sequence[i];
            } else {
                if(countDeleted<1){
                    countDeleted++;
                    if (i==1) {
                        lastElement = sequence[i];
                    } else {
                        if (i<sequence.length-1){
                            if (sequence[i-1] < sequence[i+1]){
                                lastElement = sequence[i-1];
                            } else if (sequence[i]>sequence[i-2]){
                                lastElement =sequence[i];
                            }
                        } else {
                            lastElement = sequence[i - 1];
                        }
                    }
                } else {
                    isInc = false;
                    break;
                }
            }
        }
        return isInc;
    }



    public int[] findRightInterval(int[][] intervals) {

        int[] result = new int[intervals.length];
        int[][] indexed = new int[intervals.length][3];
        for (int i = 0; i < intervals.length; i++) {
            indexed[i][0]=intervals[i][0];
            indexed[i][1]=intervals[i][1];
            indexed[i][2]=i;

        }


        Arrays.sort(indexed, Comparator.comparingInt(a->a[0]));
        int left, right, mid, end, foundIndex;
        for (int i = 0; i < intervals.length ; i++) {
            left = 0;
            right = indexed.length - 1;
            end = intervals[i][1];
            foundIndex = -1;

            while (left<=right){
                mid = left + (right-left)/2;
                if(indexed[mid][0] >= end){
                    right = mid -1;
                    foundIndex = indexed[mid][2];
                }else {
                    left = mid +1;
                }
            }
            result[i] = foundIndex;

        }

        return result;
    }

    public static boolean isPerfectSquare(int num) {

        long left = 0, right = num, mid, square;

        while (left<=right){
            mid = (left+right)/2;
            square = mid * mid;
            if (square==num) return true;

            if (square>num) right = mid-1;
            else left = mid+1;

        }

        return false;
    }


    public static int mySqrt(int x) {
        long left = 0, right = x, mid, square;
        int result = 0;

        while (left<=right){
            mid = (left+right)/2;
            square = mid * mid;

            if (square==x) return (int) mid;

            if (square>x){
                right = mid-1;
            }
            else {
                left = mid+1;
                result = (int) mid;
            }

        }

        return result;
    }


    public static int arrangeCoins(int n) {
        long left = 0, right = n, mid, sum,i = 0;
        while (left<=right){
            mid = (left + right)/2;
            sum = (1+mid)*mid/2;
            if (sum==n) return (int)mid;
            if (sum>n){
                right = mid -1;
            } else{
                left = mid + 1;
                i = mid;
            }

        }
        return (int)i;
    }

    public static int findKthPositiveOld(int[] arr, int k) {

        if (arr.length==arr[arr.length-1]){
            return arr[arr.length-1]+k;
        }

        int[] countMissing = new int[k];
        int l=-1;
        for (int j = 1; j < arr[0]; j++) {
            if (l<k-1) {
                countMissing[++l] = j;
            } else {
                return countMissing[k-1];
            }
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = arr[i]+1; j < arr[i+1]; j++) {
                if (l<k-1) {
                    countMissing[++l] = j;
                } else {
                    return countMissing[k-1];
                }

            }
        }
        for (int i = l+1; i < k ; i++) {
            countMissing[i] = ++arr[arr.length-1];
        }

        Arrays.stream(countMissing).forEach(System.out::println);
        return countMissing[k-1];
    }

    public static int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length, mid;
        while (left<right){
            mid = (right+left)/2;
            if (arr[mid]-(mid+1)<k){
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left+k;
    }
}



