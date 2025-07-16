package binarysearch;

import java.util.Arrays;

public class CapacityShip {
    public static void main(String[] args) {
        int[] weight = {1,2,3,4,5,6,7,8,9,10};
        int[] weight2 = {3,2,2,4,1,4};
        int[] weight3 = {1,2,3,1,1};
        CapacityShip obj = new CapacityShip();
//        System.out.println(obj.shipWithinDays(weight,5));
//        System.out.println(obj.shipWithinDays(weight2,3));
        System.out.println(obj.shipWithinDays(weight3,4));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left <= right){
            int mid = (left + right)/2;
            if (canShip(weights,mid,days)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canShip(int[] weights, int capacity, int days){
        int day = 1;
        int sum = 0;
        for (int weight : weights){
            if (sum + weight <= capacity){
                sum += weight;
            }else {
                sum = weight;
                day++;
            }
        }
        return day <= days;
    }
}
