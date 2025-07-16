package binarysearch;

import java.util.Arrays;

public class MinimumSpeed {

    public static void main(String[] args) {
        int[] dist = {1,3,2};

        MinimumSpeed obj = new MinimumSpeed();

//        System.out.println(obj.minSpeedOnTime(dist,6));
        System.out.println(obj.minSpeedOnTime(dist,2.7));
//        System.out.println(obj.minSpeedOnTime(dist,1.9));
    }


    public int minSpeedOnTime(int[] dist, double hour) {

        int left = 1;
        int n = dist.length;
        int right = Arrays.stream(dist).max().getAsInt()*100;
        double totalTime = 0;
        for (int i = 0; i < n-2; i++) {
            totalTime += Math.ceil((double) dist[i] /right);
        }
        totalTime +=  (double) dist[n - 1] /right;
        if (totalTime > hour) return -1;


        while (left <= right){
            int mid = left + (right - left)/2;
            if (canReach(dist,hour,mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReach(int[] dist, double hour, int speed){
        int len = dist.length;
        double totalTime = 0;
        for (int i = 0; i <= len - 2; i++) {
            totalTime += Math.ceil((double) dist[i] /speed);
        }
        totalTime = totalTime + (double) dist[len - 1] /speed;

        return totalTime <= hour;
    }

}
