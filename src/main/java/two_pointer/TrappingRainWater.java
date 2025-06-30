package two_pointer;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        int[] height2 = {4,3,0,3,0,2,0,2,1,3,0,2,0,1};

        System.out.println(trap(height2));
    }

    public static int trap(int[] height) {
        int trap = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if (leftMax < rightMax){
                trap += leftMax - height[left];
                left++;
            }else {
                trap += rightMax - height[right];
                right--;
            }
        }

        return trap;
    }
}
