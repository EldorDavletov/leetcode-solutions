package binarysearch;

import java.util.Arrays;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        KokoEatingBananas obj = new KokoEatingBananas();
        System.out.println(obj.minEatingSpeed(piles,6));
    }

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1, right = Arrays.stream(piles).max().getAsInt();
        while (left <= right){
            int mid = (left + right)/2;
            if (canEat(piles,h,mid)){
                right = mid-1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canEat(int[] piles, int h, int k){
        int time = 0;
        for (int pile : piles){
            time += (int) Math.ceil((double) pile /k);
        }
        return time <= h;
    }
}
