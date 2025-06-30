package binarysearch;

import java.util.Arrays;
import java.util.Random;

public class RandomPick {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        RandomPick obj = new RandomPick(arr);
        for (int i = 0; i < 8; i++) {
            System.out.println(obj.pickIndex());
        }
    }
    private int[] prefixSum;
    private int sum;
    private Random rand;
    public RandomPick(int[] arr){
        int n = arr.length;
        prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }
        sum = prefixSum[n-1];
        rand = new Random();
    }
    public int pickIndex(){
        int target = rand.nextInt(sum) + 1;
        int left = 0, right = prefixSum.length - 1;
        while (left < right){
            int mid = (left + right)/2;
            if (prefixSum[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;
    }
}
