package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class WiggleSort {
    public static void main(String[] args) {
        int[] nums = {3,5,2,1,6,4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void wiggleSort(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>( Arrays.stream(nums).boxed().toList());
        int i = 0;
        while (!queue.isEmpty()){
            if ((i+1)%2==1 || i == n-1){
                nums[i++] = queue.poll();
            }else {
                int num = queue.poll();
                nums[i++] = queue.poll();
                nums[i++] = num;
            }
        }
    }

    public void wiggleSort1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) ||
                    (i % 2 == 1 && nums[i] < nums[i + 1])) {
                // swap
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
        }
    }

    public static void wiggleSort2(int[] nums) {

    }

}
